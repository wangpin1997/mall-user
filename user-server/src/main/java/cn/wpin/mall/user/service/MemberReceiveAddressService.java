package cn.wpin.mall.user.service;

import cn.wpin.mall.user.entity.Member;
import cn.wpin.mall.user.entity.MemberReceiveAddress;
import cn.wpin.mall.user.example.MemberReceiveAddressExample;
import cn.wpin.mall.user.mapper.MemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户地址管理Service实现类
 *
 * @author wangpin
 */
@Service
public class MemberReceiveAddressService {

    @Autowired
    private MemberReceiveAddressMapper addressMapper;


    public int add(MemberReceiveAddress address) {
        return addressMapper.insert(address);
    }

    public int delete(Long id, Member currentMember) {
        MemberReceiveAddressExample example = new MemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    public int update(Long id, MemberReceiveAddress address) {
        address.setId(null);
        MemberReceiveAddressExample example = new MemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(address.getMemberId()).andIdEqualTo(id);
        return addressMapper.updateByExampleSelective(address, example);
    }

    public List<MemberReceiveAddress> list(Member currentMember) {
        MemberReceiveAddressExample example = new MemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);
    }

    public MemberReceiveAddress getItem(Long id, Member currentMember) {
        MemberReceiveAddressExample example = new MemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<MemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(addressList)) {
            return addressList.get(0);
        }
        return null;
    }
}
