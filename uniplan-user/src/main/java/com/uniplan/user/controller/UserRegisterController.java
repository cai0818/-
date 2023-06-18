package com.uniplan.user.controller;

import com.uniplan.user.VO.StudentVO;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.service.StudentInfoService;
import com.uniplan.user.service.UserGenneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/user/register")
public class UserRegisterController {

    @Autowired
    UserGenneralService studentService;

    @PostMapping("/student")
    public StatusResponse registerStudent(@RequestBody StudentVO studentVo, HttpSession session) {
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
}
