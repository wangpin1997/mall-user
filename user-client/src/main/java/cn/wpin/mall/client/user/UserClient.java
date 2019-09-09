package cn.wpin.mall.client.user;

import cn.wpin.mall.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("user")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET,value = "user/list")
    List<User> queryUserList();
}
