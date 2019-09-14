package cn.wpin.mall.user.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.dto.AdminParam;
import cn.wpin.mall.user.entity.Admin;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import cn.wpin.mall.user.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 *
 * @author wangpin
 * @date 2019-09-10
 */
@RestController
@Api(tags = "后台用户管理")
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "判断用户是否存在")
    @RequestMapping(value = "/adminIsExist", method = RequestMethod.POST)
    public boolean adminIsExist(@RequestBody AdminParam adminParam) {
        return adminService.adminIsExist(adminParam);
    }

    @ApiOperation("添加用户")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public int addUser(Admin admin) {
        return adminService.add(admin);
    }


    @ApiOperation(value = "添加登录日志记录接口")
    @PostMapping("insertLoginLog")
    public void insertLoginLog(@RequestParam String username) {
        adminService.insertLoginLog(username);
    }


    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Map<String, Object> getAdminInfo(Principal principal) {
        String username = principal.getName();
        Admin Admin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", Admin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("icon", Admin.getIcon());
        return data;
    }

    @RequestMapping(value = "getAdminByUserName", method = RequestMethod.GET)
    public Admin getAdminByUserName(@RequestParam String name) {
        return adminService.getAdminByUsername(name);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<Admin> list(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Admin> adminList = adminService.list(name, pageSize, pageNum);
        return CommonPage.restPage(adminList);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Admin getItem(@PathVariable Long id) {
        return adminService.getItem(id);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.update(id, admin);
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return adminService.delete(id);
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public int updateRole(@RequestParam("adminId") Long adminId,
                          @RequestParam("roleIds") List<Long> roleIds) {
        return adminService.updateRole(adminId, roleIds);
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    public List<Role> getRoleList(@PathVariable Long adminId) {
        return adminService.getRoleList(adminId);
    }

    @ApiOperation("给用户分配+-权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    public int updatePermission(@RequestParam Long adminId,
                                @RequestParam("permissionIds") List<Long> permissionIds) {
        return adminService.updatePermission(adminId, permissionIds);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public List<Permission> getPermissionList(@PathVariable Long adminId) {
        return adminService.getPermissionList(adminId);
    }
}
