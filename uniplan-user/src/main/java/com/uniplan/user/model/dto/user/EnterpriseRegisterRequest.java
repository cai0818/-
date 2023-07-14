package com.uniplan.user.model.dto.user;

import lombok.Data;

@Data
public class EnterpriseRegisterRequest {
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
