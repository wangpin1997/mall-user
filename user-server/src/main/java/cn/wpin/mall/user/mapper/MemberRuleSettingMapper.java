package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberRuleSetting;
import cn.wpin.mall.user.example.MemberRuleSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberRuleSettingMapper {
    long countByExample(MemberRuleSettingExample example);

    int deleteByExample(MemberRuleSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberRuleSetting record);

    int insertSelective(MemberRuleSetting record);

    List<MemberRuleSetting> selectByExample(MemberRuleSettingExample example);

    MemberRuleSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberRuleSetting record, @Param("example") MemberRuleSettingExample example);

    int updateByExample(@Param("record") MemberRuleSetting record, @Param("example") MemberRuleSettingExample example);

    int updateByPrimaryKeySelective(MemberRuleSetting record);

    int updateByPrimaryKey(MemberRuleSetting record);
}