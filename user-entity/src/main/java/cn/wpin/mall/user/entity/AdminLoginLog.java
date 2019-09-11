package cn.wpin.mall.user.entity;

import cn.wpin.mall.common.entity.IdEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 登录日志实体
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminLoginLog extends IdEntity {

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;

    @ApiModelProperty(value = "浏览器登录类型")
    private String userAgent;


}