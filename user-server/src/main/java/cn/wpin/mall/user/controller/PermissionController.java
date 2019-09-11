package cn.wpin.mall.user.controller;

import cn.wpin.mall.user.dto.PermissionNode;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户权限管理
 *
 * @author wagpin
 * @date 19-09-10
 */
@RestController
@Api(tags = "后台用户权限管理")
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation("添加权限")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody Permission permission) {
        return permissionService.create(permission);
    }

    @ApiOperation("修改权限")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody Permission permission) {
        return permissionService.update(id,permission);
    }

    @ApiOperation("根据id批量删除权限")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return permissionService.delete(ids);
    }

    @ApiOperation("以层级结构返回所有权限")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    public List<PermissionNode> treeList() {
        return permissionService.treeList();
    }

    @ApiOperation("获取所有权限列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Permission> list() {
        return permissionService.list();
    }
}
