package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberStatisticsInfo;
import cn.wpin.mall.user.example.MemberStatisticsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberStatisticsInfoMapper {
    long countByExample(MemberStatisticsInfoExample example);

    int deleteByExample(MemberStatisticsInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberStatisticsInfo record);

    int insertSelective(MemberStatisticsInfo record);

    List<MemberStatisticsInfo> selectByExample(MemberStatisticsInfoExample example);

    MemberStatisticsInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberStatisticsInfo record, @Param("example") MemberStatisticsInfoExample example);

    int updateByExample(@Param("record") MemberStatisticsInfo record, @Param("example") MemberStatisticsInfoExample example);

    int updateByPrimaryKeySelective(MemberStatisticsInfo record);

    int updateByPrimaryKey(MemberStatisticsInfo record);
}