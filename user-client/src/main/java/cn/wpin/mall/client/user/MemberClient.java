package cn.wpin.mall.client.user;

import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangpin
 */
@FeignClient("user")
public interface MemberClient {

    @GetMapping("member/getByUsername")
    Member getByUsername(@RequestParam String username);

    @GetMapping("member/{id}")
    Member getById(@PathVariable Long id);

    @PostMapping("member/register")
    CommonResult register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String telephone);


    @PostMapping("member/updatePassword")
    CommonResult updatePassword(@RequestParam String telephone,
                                @RequestParam String password);


    @PostMapping("member/updateIntegration")
    int updateIntegration(@RequestParam Long id,
                          @RequestParam Integer integration);
}
