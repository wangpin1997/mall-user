package cn.wpin.mall.user.service;

import cn.wpin.mall.user.entity.MemberLevel;
import cn.wpin.mall.user.example.MemberLevelExample;
import cn.wpin.mall.user.mapper.MemberLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * @author wangpin
 */
@Service
public class MemberLevelService{
    @Autowired
    private MemberLevelMapper memberLevelMapper;
   
    public List<MemberLevel> list(Integer defaultStatus) {
        MemberLevelExample example = new MemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
