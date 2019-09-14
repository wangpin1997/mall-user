package cn.wpin.mall.user.controller;

import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import cn.wpin.mall.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色管理
 * @author wangpin 2019-09-10.
 */
@RestController
@Api(tags = "用户角色")
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody Role role) {
        return roleService.update(id, role);
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int  delete(@RequestParam("ids") List<Long> ids) {
        return roleService.delete(ids);
    }

    @ApiOperation("获取相应角色权限")
    @RequestMapping(value = "/permission/{roleId}", method = RequestMethod.GET)
    public List<Permission> getPermissionList(@PathVariable Long roleId) {
        return roleService.getPermissionList(roleId);
    }

    @ApiOperation("修改角色权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    public int updatePermission(@RequestParam Long roleId,
                                         @RequestParam("permissionIds") List<Long> permissionIds) {
        return roleService.updatePermission(roleId, permissionIds);
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
       return roleService.list();
    }

}
