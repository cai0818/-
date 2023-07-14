package com.uniplan.user.model.dto.user;

import lombok.Data;

@Data
public class EnterpriseLoginRequest {
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
