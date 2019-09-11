package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.GrowthChangeHistory;
import cn.wpin.mall.user.example.GrowthChangeHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrowthChangeHistoryMapper {
    long countByExample(GrowthChangeHistoryExample example);

    int deleteByExample(GrowthChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GrowthChangeHistory record);

    int insertSelective(GrowthChangeHistory record);

    List<GrowthChangeHistory> selectByExample(GrowthChangeHistoryExample example);

    GrowthChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GrowthChangeHistory record, @Param("example") GrowthChangeHistoryExample example);

    int updateByExample(@Param("record") GrowthChangeHistory record, @Param("example") GrowthChangeHistoryExample example);

    int updateByPrimaryKeySelective(GrowthChangeHistory record);

    int updateByPrimaryKey(GrowthChangeHistory record);
}