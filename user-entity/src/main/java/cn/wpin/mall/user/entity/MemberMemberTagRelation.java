package cn.wpin.mall.user.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MemberMemberTagRelation extends IdEntity {

    private Long memberId;

    private Long tagId;

}