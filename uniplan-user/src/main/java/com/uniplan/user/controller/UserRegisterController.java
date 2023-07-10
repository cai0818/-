package com.uniplan.user.controller;

import com.uniplan.user.model.dto.UserRegisterRequest;
import com.uniplan.user.model.vo.StudentVO;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.service.EnterpriseService;
import com.uniplan.user.service.UniversityService;
import com.uniplan.user.service.UserGenneralService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/user/register")
public class UserRegisterController {

    @Autowired
    UserGenneralService studentService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    UniversityService universityService;


    @PostMapping("/student")
    public StatusResponse registerStudent(@RequestBody UserRegisterRequest studentVo, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        studentService.studentRegister(studentVo);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

    @PostMapping("/university")
    public StatusResponse registerUniversity(HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

    @PostMapping("/enterprise")
    public StatusResponse registerEnterprise(HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }
}
