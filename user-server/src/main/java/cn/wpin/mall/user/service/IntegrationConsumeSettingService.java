package cn.wpin.mall.user.service;

import cn.wpin.mall.user.entity.IntegrationConsumeSetting;
import cn.wpin.mall.user.mapper.IntegrationConsumeSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangpin
 */
@Component
public class IntegrationConsumeSettingService {

    @Autowired
    private IntegrationConsumeSettingMapper integrationConsumeSettingMapper;

    public IntegrationConsumeSetting selectByPrimaryKey(Long id){
        return integrationConsumeSettingMapper.selectByPrimaryKey(id);
    }
}
