package cn.wpin.mall.user.controller;

import cn.wpin.mall.user.entity.Member;
import cn.wpin.mall.user.entity.MemberReceiveAddress;
import cn.wpin.mall.user.service.MemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangpin
 */
@RestController
@RequestMapping("memberReceive")
public class MemberReceiveAddressController {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;


    @PostMapping("add")
    public int add(@RequestBody MemberReceiveAddress address,
                   @RequestBody Member currentMember) {
        return memberReceiveAddressService.add(address, currentMember);
    }

    @DeleteMapping("delete")
    public int delete(@RequestParam Long id,
                      @RequestBody Member currentMember) {
        return memberReceiveAddressService.delete(id, currentMember);
    }

    @PutMapping("update")
    public int update(@RequestParam Long id,
                      @RequestBody MemberReceiveAddress address,
                      @RequestBody Member currentMember) {
        return memberReceiveAddressService.update(id, address, currentMember);
    }

    @GetMapping("list")
    public List<MemberReceiveAddress> list(@RequestBody Member currentMember) {
        return memberReceiveAddressService.list(currentMember);
    }

    @GetMapping("getItem")
    public MemberReceiveAddress getItem(@RequestParam Long id, @RequestBody Member currentMember) {
        return memberReceiveAddressService.getItem(id, currentMember);
    }
}
