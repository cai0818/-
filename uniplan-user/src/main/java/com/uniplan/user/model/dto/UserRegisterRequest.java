package com.uniplan.user.model.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    /**
     *
     */
    private String account;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String confirmPassword;
}
