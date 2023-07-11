package com.uniplan.user.model.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;
}
