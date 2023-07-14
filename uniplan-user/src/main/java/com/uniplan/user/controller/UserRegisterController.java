package com.uniplan.user.controller;

import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.model.dto.user.EnterpriseRegisterRequest;
import com.uniplan.user.model.dto.user.UniversityRegisterRequest;
import com.uniplan.user.model.dto.user.UserRegisterRequest;
import com.uniplan.user.service.UserGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户注册
 */
@RestController
@RequestMapping("/user/register")
public class UserRegisterController {

    @Autowired
    UserGeneralService userGeneralService;

    @PostMapping("/student")
    public StatusResponse registerStudent(@RequestBody UserRegisterRequest userRegisterRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        userGeneralService.studentRegister(userRegisterRequest);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

    @PostMapping("/university")
    public StatusResponse registerUniversity(@RequestBody UniversityRegisterRequest universityRegisterRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        userGeneralService.universityRegister(universityRegisterRequest);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

    @PostMapping("/enterprise")
    public StatusResponse registerEnterprise(@RequestBody EnterpriseRegisterRequest enterpriseRegisterRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        userGeneralService.enterpriseRegister(enterpriseRegisterRequest);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }
}
