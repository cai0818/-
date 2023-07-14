package com.uniplan.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.model.domain.UserGeneral;
import com.uniplan.user.model.dto.user.UserQueryRequest;
import com.uniplan.user.service.UserGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserGeneralService userGeneralService;

    @GetMapping("/select/page")
    public StatusResponse listUserByPage(@RequestBody UserQueryRequest userQueryRequest, HttpServletRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        long current = userQueryRequest.getCurrent();
        long size = userQueryRequest.getPageSize();
        Page<UserGeneral> userPage = userGeneralService.page(new Page<>(current, size), userGeneralService.getQueryWrapper(userQueryRequest));
        statusResponse.setData(userPage);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }
}
