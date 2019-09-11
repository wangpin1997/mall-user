package cn.wpin.mall.user.dao;

import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户角色管理自定义Dao
 * @author wangpin 
 */
public interface RolePermissionRelationDao {
    /**
     * 批量插入角色和权限关系
     */
    int insertList(@Param("list") List<RolePermissionRelation> list);

    /**
     * 根据角色获取权限
     */
    List<Permission> getPermissionList(@Param("roleId") Long roleId);
}
