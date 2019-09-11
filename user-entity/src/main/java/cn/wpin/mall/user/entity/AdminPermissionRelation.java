package cn.wpin.mall.user.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminPermissionRelation extends IdEntity {

    private Long adminId;

    private Long permissionId;

    private Integer type;

}