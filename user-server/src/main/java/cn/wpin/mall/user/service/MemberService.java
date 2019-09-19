package cn.wpin.mall.user.service;


import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.Member;
import cn.wpin.mall.user.entity.MemberLevel;
import cn.wpin.mall.user.example.MemberExample;
import cn.wpin.mall.user.example.MemberLevelExample;
import cn.wpin.mall.user.mapper.MemberLevelMapper;
import cn.wpin.mall.user.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 会员管理Service实现类
 *
 * @author wangpin
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberLevelMapper memberLevelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Member getByUsername(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    public Member getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    public CommonResult register(String username, String password, String telephone) {
        //查询是否已有该用户
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<Member> members = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(members)) {
            return CommonResult.failed("该用户已经存在");
        }
        //没有该用户进行添加操作
        Member member = new Member();
        member.setUsername(username);
        member.setPhone(telephone);
        member.setPassword(passwordEncoder.encode(password));
        member.setCreateTime(new Date());
        member.setStatus(1);
        //获取默认会员等级并设置
        MemberLevelExample levelExample = new MemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<MemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            member.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(member);
        member.setPassword(null);
        return CommonResult.success(null, "注册成功");
    }


    public CommonResult updatePassword(String telephone, String password) {
        MemberExample example = new MemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(memberList)) {
            return CommonResult.failed("该账号不存在");
        }
        Member member = memberList.get(0);
        member.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(member);
        return CommonResult.success(null, "密码修改成功");
    }


    public int updateIntegration(Long id, Integer integration) {
        Member record = new Member();
        record.setId(id);
        record.setIntegration(integration);
        return memberMapper.updateByPrimaryKeySelective(record);
    }


}
