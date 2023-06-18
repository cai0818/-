package com.uniplan.user.controller;

import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.domain.Major;
import com.uniplan.user.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {

    @Resource
    MajorService majorService;

    @PostMapping("/add")
    public StatusResponse addMajor(@RequestBody Major major, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = majorService.addMajor(major);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @GetMapping("/select")
    public StatusResponse selectMajor(HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        List<Major> majors = majorService.selectMajor();
        if (majors != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(majors);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }


    @PostMapping("/delete")
    public StatusResponse deleteMajor(@RequestBody Major major, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = majorService.deleteMajor(major.getId());
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    public StatusResponse updateMajor(@RequestBody Major major, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = majorService.updateMajor(major);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);

        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}
