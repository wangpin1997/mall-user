package cn.wpin.mall.user.dto;

import cn.wpin.mall.user.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionNode extends Permission {
    private List<PermissionNode> children;
}
