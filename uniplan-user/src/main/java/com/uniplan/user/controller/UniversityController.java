package com.uniplan.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.model.domain.University;
import com.uniplan.user.model.dto.university.UniversityQueryRequest;
import com.uniplan.user.service.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UniversityController {
    @Resource
    UniversityService universityService;

    @PostMapping("/add")
    public StatusResponse addUniversity(@RequestBody University university, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = universityService.addUniversity(university);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);

        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @GetMapping("/select")
    public StatusResponse selectUniversity(HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        List<University> universitys = universityService.selectUniversity();
        if (universitys != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(universitys);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }


    @PostMapping("/delete")
    public StatusResponse deleteUniversity(@RequestBody University university, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = universityService.deleteUniversity(university.getId());
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    public StatusResponse updateUniversity(@RequestBody University university, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = universityService.updateUniversity(university);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);

        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
    @GetMapping("/select/page")
    public StatusResponse listUserByPage(@RequestBody UniversityQueryRequest universityQueryRequest, HttpServletRequest request) {
        StatusResponse statusResponse = new StatusResponse();
        long current = universityQueryRequest.getCurrent();
        long size = universityQueryRequest.getPageSize();
        Page<University> userPage = universityService.page(new Page<>(current, size), universityService.getQueryWrapper(universityQueryRequest));
        statusResponse.setData(userPage);
        statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        return statusResponse;
    }

}
