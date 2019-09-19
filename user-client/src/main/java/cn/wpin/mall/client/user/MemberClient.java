package cn.wpin.mall.client.user;

import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("user")
public interface MemberClient {

    @GetMapping("member/getByUsername")
    Member getByUsername(@RequestParam String username);

    @GetMapping("member/{id}")
    Member getById(@PathVariable Long id);

    @PostMapping("member/register")
    CommonResult register(String username, String password, String telephone);


    @PutMapping("member/updatePassword")
    CommonResult updatePassword(String telephone, String password);


    @PutMapping("member/updateIntegration")
    int updateIntegration(Long id, Integer integration);
}
