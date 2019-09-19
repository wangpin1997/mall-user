package cn.wpin.mall.user.controller;

import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.Member;
import cn.wpin.mall.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangpin
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getByUsername")
    public Member getByUsername(@RequestParam String username) {
        return memberService.getByUsername(username);
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PostMapping("/register")
    public CommonResult register(String username, String password, String telephone) {
        return memberService.register(username, password, telephone);
    }


    @PutMapping("/updatePassword")
    public CommonResult updatePassword(String telephone, String password) {
        return memberService.updatePassword(telephone, password);
    }


    @PutMapping("/updateIntegration")
    public int updateIntegration(Long id, Integer integration) {
        return memberService.updateIntegration(id, integration);
    }

}
