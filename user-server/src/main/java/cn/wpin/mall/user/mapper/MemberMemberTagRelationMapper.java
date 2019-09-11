package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberMemberTagRelation;
import cn.wpin.mall.user.example.MemberMemberTagRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMemberTagRelationMapper {
    long countByExample(MemberMemberTagRelationExample example);

    int deleteByExample(MemberMemberTagRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberMemberTagRelation record);

    int insertSelective(MemberMemberTagRelation record);

    List<MemberMemberTagRelation> selectByExample(MemberMemberTagRelationExample example);

    MemberMemberTagRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberMemberTagRelation record, @Param("example") MemberMemberTagRelationExample example);

    int updateByExample(@Param("record") MemberMemberTagRelation record, @Param("example") MemberMemberTagRelationExample example);

    int updateByPrimaryKeySelective(MemberMemberTagRelation record);

    int updateByPrimaryKey(MemberMemberTagRelation record);
}