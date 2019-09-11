package cn.wpin.mall.user.service;

import cn.wpin.mall.user.dao.RolePermissionRelationDao;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import cn.wpin.mall.user.entity.RolePermissionRelation;
import cn.wpin.mall.user.example.RoleExample;
import cn.wpin.mall.user.example.RolePermissionRelationExample;
import cn.wpin.mall.user.mapper.RoleMapper;
import cn.wpin.mall.user.mapper.RolePermissionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台角色管理Service实现类
 * @author wangpin 2019-09-10
 */
@Service
public class RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private RolePermissionRelationDao rolePermissionRelationDao;
   
    public int create(Role role) {
        role.setCreateTime(new Date());
        role.setStatus(1);
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

   
    public int update(Long id, Role role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

   
    public int delete(List<Long> ids) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.deleteByExample(example);
    }

   
    public List<Permission> getPermissionList(Long roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

   
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        RolePermissionRelationExample example=new RolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);
        //批量插入新关系
        List<RolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            RolePermissionRelation relation = new RolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionRelationDao.insertList(relationList);
    }

   
    public List<Role> list() {
        return roleMapper.selectByExample(new RoleExample());
    }
}
