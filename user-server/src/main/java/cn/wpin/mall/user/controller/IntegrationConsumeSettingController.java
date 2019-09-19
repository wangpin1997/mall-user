package cn.wpin.mall.user.controller;

import cn.wpin.mall.user.entity.IntegrationConsumeSetting;
import cn.wpin.mall.user.service.IntegrationConsumeSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangpin
 */
@RestController
@RequestMapping("integration/consume/setting")
public class IntegrationConsumeSettingController {

    @Autowired
    private IntegrationConsumeSettingService integrationConsumeSettingService;

    @GetMapping("selectByKey/{id}")
    public IntegrationConsumeSetting selectByKey(@PathVariable Long id){
        return integrationConsumeSettingService.selectByPrimaryKey(id);
    }
}
