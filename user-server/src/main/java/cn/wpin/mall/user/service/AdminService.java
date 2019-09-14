package cn.wpin.mall.user.service;

import cn.wpin.mall.user.dao.AdminPermissionRelationDao;
import cn.wpin.mall.user.dao.AdminRoleRelationDao;
import cn.wpin.mall.user.dto.AdminParam;
import cn.wpin.mall.user.entity.*;
import cn.wpin.mall.user.example.AdminExample;
import cn.wpin.mall.user.example.AdminPermissionRelationExample;
import cn.wpin.mall.user.example.AdminRoleRelationExample;
import cn.wpin.mall.user.mapper.AdminLoginLogMapper;
import cn.wpin.mall.user.mapper.AdminMapper;
import cn.wpin.mall.user.mapper.AdminPermissionRelationMapper;
import cn.wpin.mall.user.mapper.AdminRoleRelationMapper;
import com.github.pagehelper.PageHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 会员service层实现类
 * @author wangpin
 */
@Service
public class AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private AdminPermissionRelationMapper adminPermissionRelationMapper;
    @Autowired
    private AdminPermissionRelationDao adminPermissionRelationDao;
    @Autowired
    private AdminLoginLogMapper loginLogMapper;

   
    public Admin getAdminByUsername(String username) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

   
    public boolean adminIsExist(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        //查询是否有相同用户名的用户
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> adminList = adminMapper.selectByExample(example);
        return !CollectionUtils.isEmpty(adminList);
    }

    /**
     * 添加用户
     * @param admin
     * @return
     */
    public int add(Admin admin){
        return adminMapper.insert(admin);
    }


    /**
     * 添加登录记录
     * @param username 用户名
     */
    public void insertLoginLog(String username) {
        Admin admin = getAdminByUsername(username);
        AdminLoginLog loginLog = new AdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        Admin record = new Admin();
        record.setLoginTime(new Date());
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

   
    public Admin getItem(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

   
    public List<Admin> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andUsernameLike("%" + name + "%");
            example.or(example.createCriteria().andNickNameLike("%" + name + "%"));
        }
        return adminMapper.selectByExample(example);
    }

   
    public int update(Long id, Admin admin) {
        admin.setId(id);
        //密码已经加密处理，需要单独修改
        admin.setPassword(null);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

   
    public int delete(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

   
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        AdminRoleRelationExample adminRoleRelationExample = new AdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<AdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                AdminRoleRelation roleRelation = new AdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

   
    public List<Role> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

   
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        //删除原所有权限关系
        AdminPermissionRelationExample relationExample = new AdminPermissionRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminPermissionRelationMapper.deleteByExample(relationExample);
        //获取用户所有角色权限
        List<Permission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Long> rolePermissionList = permissionList.stream().map(Permission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<AdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(convert(adminId,1,addPermissionIdList));
            relationList.addAll(convert(adminId,-1,subPermissionIdList));
            return adminPermissionRelationDao.insertList(relationList);
        }
        return 0;
    }

    /**
     * 将+-权限关系转化为对象
     */
    private List<AdminPermissionRelation> convert(Long adminId, Integer type, List<Long> permissionIdList) {
        List<AdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            AdminPermissionRelation relation = new AdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }

   
    public List<Permission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}
