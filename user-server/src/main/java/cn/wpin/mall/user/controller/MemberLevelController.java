package cn.wpin.mall.user.controller;

import cn.wpin.mall.user.entity.MemberLevel;
import cn.wpin.mall.user.service.MemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员等级管理Controller
 * @author wangpin
 */
@RestController
@Api(tags = "会员等级")
@RequestMapping("memberLevel")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation("查询所有会员等级")
    public List<MemberLevel> list(@RequestParam("defaultStatus") Integer defaultStatus) {
        return memberLevelService.list(defaultStatus);
    }
}
