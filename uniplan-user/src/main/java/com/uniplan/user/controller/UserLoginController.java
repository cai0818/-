package com.uniplan.user.controller;

import com.uniplan.user.model.dto.user.EnterpriseLoginRequest;
import com.uniplan.user.model.dto.user.UniversityLoginRequest;
import com.uniplan.user.model.dto.user.UserLoginRequest;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.service.EnterpriseService;
import com.uniplan.user.service.UniversityService;
import com.uniplan.user.service.UserGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/login")
public class UserLoginController {

    @Autowired
    UserGeneralService userGeneralService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    UniversityService universityService;

    @PostMapping("/student")
    public StatusResponse loginStudent(@RequestBody UserLoginRequest userLoginRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        String account = userLoginRequest.getAccount();
        String password = userLoginRequest.getPassword();
        String token = userGeneralService.studentLogin(account,password,session);
        if (token != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(token);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/university")
    public StatusResponse loginUniversity(@RequestBody UniversityLoginRequest universityLoginRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        String account = universityLoginRequest.getAccount();
        String password = universityLoginRequest.getPassword();
        String token = userGeneralService.universityLogin(account,password,session);
        if (token != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(token);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/enterprise")
    public StatusResponse loginEnterprise(@RequestBody EnterpriseLoginRequest enterpriseLoginRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        String account = enterpriseLoginRequest.getAccount();
        String password = enterpriseLoginRequest.getPassword();
        String token = userGeneralService.enterpriseLogin(account,password,session);
        if (token != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(token);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
