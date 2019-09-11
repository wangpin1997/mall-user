package cn.wpin.mall.client.user;

import cn.wpin.mall.user.dto.PermissionNode;
import cn.wpin.mall.user.entity.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
public interface PermissionClient {

    /**
     * 添加权限
     */
    @RequestMapping(value = "permission/create", method = RequestMethod.POST)
    int create(@RequestBody Permission permission);

    /**
     * 修改权限
     */
    @RequestMapping(value = "permission/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody Permission permission);

    /**
     * 根据id批量删除权限
     */
    @RequestMapping(value = "permission/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 以层级结构返回所有权限
     */
    @RequestMapping(value = "permission/treeList", method = RequestMethod.GET)
    List<PermissionNode> treeList();

    /**
     * 获取所有权限列表
     */
    @RequestMapping(value = "permission/list", method = RequestMethod.GET)
    List<Permission> list();


}
