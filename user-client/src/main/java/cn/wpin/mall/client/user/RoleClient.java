package cn.wpin.mall.client.user;

import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
public interface RoleClient {

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "role/create", method = RequestMethod.POST)
    int create(@RequestBody Role role);

    /**
     * 修改角色
     *
     * @param id
     * @param role
     * @return
     */
    @RequestMapping(value = "role/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody Role role);

    /**
     * 批量删除角色
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "role/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);


    /**
     * 获取相应角色权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "role/permission/{roleId}", method = RequestMethod.GET)
    List<Permission> getPermissionList(@PathVariable Long roleId);

    /**
     * 修改角色权限
     */
    @RequestMapping(value = "role/permission/update", method = RequestMethod.POST)
    int updatePermission(@RequestParam Long roleId,
                         @RequestParam("permissionIds") List<Long> permissionIds);

    /**
     * 获取所有角色
     */
    @RequestMapping(value = "role/list", method = RequestMethod.GET)
    Object list();
}
