package cn.wpin.mall.client.user;

import cn.wpin.mall.user.entity.MemberLevel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user")
public interface MemberLevelClient {

    /**
     * 查询所有会员等级
     * @param defaultStatus
     * @return
     */
    @GetMapping(value = "memberLevel/list")
    List<MemberLevel> list(@RequestParam("defaultStatus") Integer defaultStatus);
}
