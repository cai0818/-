package com.uniplan.user.model.dto.user;

import com.uniplan.user.common.PageRequest;
import lombok.Data;

import java.util.Date;
@Data
public class UserQueryRequest extends PageRequest {
    /**
     *
     */
    private String id;

    /**
     * "账号"
     */
    private String account;

    /**
     * "用户密码"
     */
    private String password;

    /**
     * "角色"
     */
    private String role;

    /**
     * "注册时间"
     */
    private Date time;

    /**
     * "绑定电话"
     */
    private String phone;

    /**
     * "绑定邮箱"
     */
    private String email;

    /**
     * "标签"
     */
    private String tag;
}
