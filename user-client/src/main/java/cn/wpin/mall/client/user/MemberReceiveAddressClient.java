package cn.wpin.mall.client.user;

import cn.wpin.mall.user.entity.Member;
import cn.wpin.mall.user.entity.MemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@FeignClient("user")
public interface MemberReceiveAddressClient {


    @PostMapping("memberReceive/add")
    int add(@RequestBody MemberReceiveAddress address);

    @DeleteMapping("memberReceive/delete")
    int delete(@RequestParam Long id,
               @RequestBody Member currentMember);

    @PutMapping("memberReceive/update")
    int update(@RequestParam Long id,
               @RequestBody MemberReceiveAddress address);

    @GetMapping("memberReceive/list")
    List<MemberReceiveAddress> list(@RequestBody Member currentMember);

    @GetMapping("memberReceive/getItem")
    MemberReceiveAddress getItem(@RequestParam Long id, @RequestBody Member currentMember);
}
