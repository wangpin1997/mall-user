package cn.wpin.mall.user.mapper;


import cn.wpin.mall.user.entity.AdminPermissionRelation;
import cn.wpin.mall.user.example.AdminPermissionRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionRelationMapper {
    long countByExample(AdminPermissionRelationExample example);

    int deleteByExample(AdminPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminPermissionRelation record);

    int insertSelective(AdminPermissionRelation record);

    List<AdminPermissionRelation> selectByExample(AdminPermissionRelationExample example);

    AdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminPermissionRelation record, @Param("example") AdminPermissionRelationExample example);

    int updateByExample(@Param("record") AdminPermissionRelation record, @Param("example") AdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(AdminPermissionRelation record);

    int updateByPrimaryKey(AdminPermissionRelation record);
}