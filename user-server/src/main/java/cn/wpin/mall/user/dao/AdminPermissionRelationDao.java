package cn.wpin.mall.user.dao;

import cn.wpin.mall.user.entity.AdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户权限自定义Dao
 * @author wangpin
 */
public interface AdminPermissionRelationDao {
    int insertList(@Param("list") List<AdminPermissionRelation> list);
}
