package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.IntegrationChangeHistory;
import cn.wpin.mall.user.example.IntegrationChangeHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegrationChangeHistoryMapper {
    long countByExample(IntegrationChangeHistoryExample example);

    int deleteByExample(IntegrationChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegrationChangeHistory record);

    int insertSelective(IntegrationChangeHistory record);

    List<IntegrationChangeHistory> selectByExample(IntegrationChangeHistoryExample example);

    IntegrationChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegrationChangeHistory record, @Param("example") IntegrationChangeHistoryExample example);

    int updateByExample(@Param("record") IntegrationChangeHistory record, @Param("example") IntegrationChangeHistoryExample example);

    int updateByPrimaryKeySelective(IntegrationChangeHistory record);

    int updateByPrimaryKey(IntegrationChangeHistory record);
}