package cn.wpin.mall.user.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminRoleRelation extends IdEntity {

    private Long adminId;

    private Long roleId;
}