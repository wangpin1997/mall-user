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
    public CommonResult register(@RequestParam String username, @RequestParam String password, @RequestParam String telephone) {
        return memberService.register(username, password, telephone);
    }


    @PostMapping("/updatePassword")
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String password) {
        return memberService.updatePassword(telephone, password);
    }


    @PostMapping("/updateIntegration")
    public int updateIntegration(@RequestParam Long id, @RequestParam Integer integration) {
        return memberService.updateIntegration(id, integration);
    }

}
