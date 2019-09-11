package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.IntegrationConsumeSetting;
import cn.wpin.mall.user.example.IntegrationConsumeSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegrationConsumeSettingMapper {
    long countByExample(IntegrationConsumeSettingExample example);

    int deleteByExample(IntegrationConsumeSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegrationConsumeSetting record);

    int insertSelective(IntegrationConsumeSetting record);

    List<IntegrationConsumeSetting> selectByExample(IntegrationConsumeSettingExample example);

    IntegrationConsumeSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegrationConsumeSetting record, @Param("example") IntegrationConsumeSettingExample example);

    int updateByExample(@Param("record") IntegrationConsumeSetting record, @Param("example") IntegrationConsumeSettingExample example);

    int updateByPrimaryKeySelective(IntegrationConsumeSetting record);

    int updateByPrimaryKey(IntegrationConsumeSetting record);
}