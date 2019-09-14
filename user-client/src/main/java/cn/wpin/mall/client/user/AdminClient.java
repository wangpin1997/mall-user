package cn.wpin.mall.client.user;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.user.dto.AdminParam;
import cn.wpin.mall.user.entity.Admin;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @author wangpin
 */
@FeignClient("user")
public interface AdminClient {

    /**
     * 判断用户是否存在
     *
     * @param adminParam
     * @return
     */
    @RequestMapping(value = "/adminIsExist", method = RequestMethod.POST)
    boolean adminIsExist(@RequestBody AdminParam adminParam);

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    int addUser(Admin admin);

    @GetMapping(value = "admin/info")
    Map<String, Object> getAdminInfo(@RequestBody Principal principal);

    @GetMapping(value = "admin/list")
    CommonPage<Admin> list(@RequestParam("name") String name,
                           @RequestParam("pageSize") int pageSize,
                           @RequestParam("pageNum") int pageNum);

    @GetMapping(value = "admin/{id}")
    Admin getItem(@PathVariable("id") Integer id);

    @PostMapping(value = "admin/update/{id}")
    int update(@PathVariable Long id, @RequestBody Admin admin);

    @PostMapping(value = "admin/delete/{id}")
    int delete(@PathVariable Long id);

    @PostMapping(value = "admin/role/update")
    int updateRole(@RequestParam("adminId") Long adminId,
                   @RequestParam("roleIds") List<Long> roleIds);

    @GetMapping(value = "admin/role/{adminId}")
    List<Role> getRoleList(@PathVariable Long adminId);

    @PostMapping(value = "admin//permission/update")
    int updatePermission(@RequestParam Long adminId,
                         @RequestParam("permissionIds") List<Long> permissionIds);

    @GetMapping(value = "admin/permission/{adminId}")
    List<Permission> getPermissionList(@PathVariable Long adminId);

    @GetMapping(value = "admin/getAdminByUserName")
    Admin getAdminByUserName(@RequestParam String name);

    @PostMapping(value = "admin/insertLoginLog")
    void insertLoginLog(@RequestParam String username);
}
