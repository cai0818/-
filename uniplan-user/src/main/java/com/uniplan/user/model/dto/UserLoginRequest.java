package com.uniplan.user.model.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    /**
     *
     */
    private String account;

    /**
     *
     */
    private String password;
}
