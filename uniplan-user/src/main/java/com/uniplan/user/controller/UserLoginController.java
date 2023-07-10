package com.uniplan.user.controller;

import com.uniplan.user.model.dto.UserLoginRequest;
import com.uniplan.user.model.vo.StudentVO;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.service.EnterpriseService;
import com.uniplan.user.service.UniversityService;
import com.uniplan.user.service.UserGenneralService;
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
    UserGenneralService studentService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    UniversityService universityService;

    @PostMapping("/student")
    public StatusResponse loginStudent(@RequestBody UserLoginRequest userLoginRequest, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        String token = studentService.studentLogin(userLoginRequest);
        if (token != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(token);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
