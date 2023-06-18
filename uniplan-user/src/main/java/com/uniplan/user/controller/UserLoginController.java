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

@RestController
@RequestMapping("/user/login")
public class UserLoginController {

    @Autowired
    UserGenneralService studentService;

    @PostMapping("/student")
    public StatusResponse loginStudent(@RequestBody StudentVO studentVo, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        String token = studentService.studentLogin(studentVo);
        if (token != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(token);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
