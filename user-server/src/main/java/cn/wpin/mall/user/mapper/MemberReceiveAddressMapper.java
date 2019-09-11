package cn.wpin.mall.user.mapper;

import cn.wpin.mall.user.entity.MemberReceiveAddress;
import cn.wpin.mall.user.example.MemberReceiveAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberReceiveAddressMapper {
    long countByExample(MemberReceiveAddressExample example);

    int deleteByExample(MemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberReceiveAddress record);

    int insertSelective(MemberReceiveAddress record);

    List<MemberReceiveAddress> selectByExample(MemberReceiveAddressExample example);

    MemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberReceiveAddress record, @Param("example") MemberReceiveAddressExample example);

    int updateByExample(@Param("record") MemberReceiveAddress record, @Param("example") MemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(MemberReceiveAddress record);

    int updateByPrimaryKey(MemberReceiveAddress record);
}