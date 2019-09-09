package cn.wpin.mall.user.controller;

import cn.wpin.mall.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpin
 */
@Api(tags = "用户管理")
@RequestMapping("user")
@RestController
public class UserController {

    @GetMapping("list")
    @ApiOperation(value = "查询用户列表")
    public List<User> queryUserList(){
        return null;
    }
}
