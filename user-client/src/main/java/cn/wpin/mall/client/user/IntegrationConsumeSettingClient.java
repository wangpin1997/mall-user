package cn.wpin.mall.client.user;

import cn.wpin.mall.user.entity.IntegrationConsumeSetting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangpin
 */
@FeignClient("user")
public interface IntegrationConsumeSettingClient {


    /**
     * 根据主键查信息
     */
    @GetMapping("integration/consume/setting/selectByKey/{id}")
    IntegrationConsumeSetting selectByKey(@PathVariable Long id);
}
