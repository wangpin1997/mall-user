package cn.wpin.mall.user.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author wangpin
 */
@Data
public class User extends IdEntity {

    private String username;


    private String password;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Date createTime;

    private Date loginTime;

    private Integer status;


}
