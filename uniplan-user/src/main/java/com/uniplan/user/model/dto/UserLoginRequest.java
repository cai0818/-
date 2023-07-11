package com.uniplan.user.model.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
