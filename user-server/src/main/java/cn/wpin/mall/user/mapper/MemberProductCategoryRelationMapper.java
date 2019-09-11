package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberProductCategoryRelation;
import cn.wpin.mall.user.example.MemberProductCategoryRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberProductCategoryRelationMapper {
    long countByExample(MemberProductCategoryRelationExample example);

    int deleteByExample(MemberProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberProductCategoryRelation record);

    int insertSelective(MemberProductCategoryRelation record);

    List<MemberProductCategoryRelation> selectByExample(MemberProductCategoryRelationExample example);

    MemberProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberProductCategoryRelation record, @Param("example") MemberProductCategoryRelationExample example);

    int updateByExample(@Param("record") MemberProductCategoryRelation record, @Param("example") MemberProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(MemberProductCategoryRelation record);

    int updateByPrimaryKey(MemberProductCategoryRelation record);
}