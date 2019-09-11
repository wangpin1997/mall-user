package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberTask;
import cn.wpin.mall.user.example.MemberTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberTaskMapper {
    long countByExample(MemberTaskExample example);

    int deleteByExample(MemberTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberTask record);

    int insertSelective(MemberTask record);

    List<MemberTask> selectByExample(MemberTaskExample example);

    MemberTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberTask record, @Param("example") MemberTaskExample example);

    int updateByExample(@Param("record") MemberTask record, @Param("example") MemberTaskExample example);

    int updateByPrimaryKeySelective(MemberTask record);

    int updateByPrimaryKey(MemberTask record);
}