package com.uniplan.user.controller;

import com.uniplan.user.common.StatusResponse;
import com.uniplan.user.common.StatusResponseCode;
import com.uniplan.user.domain.Enterprise;
import com.uniplan.user.service.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    EnterpriseService enterpriseService;

    @PostMapping("/add")
    public StatusResponse addEnterprise(@RequestBody Enterprise enterprise, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = enterpriseService.addEnterprise(enterprise);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @GetMapping("/select")
    public StatusResponse selectEnterprise(HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        List<Enterprise> enterprises = enterpriseService.selectEnterprise();
        if (enterprises != null) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
            statusResponse.setData(enterprises);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/delete")
    public StatusResponse deleteEnterprise(@RequestBody Enterprise enterprise, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = enterpriseService.deleteEnterprise(enterprise.getId());
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }

    @PostMapping("/update")
    public StatusResponse updateEnterprise(@RequestBody Enterprise enterprise, HttpSession session) {
        StatusResponse statusResponse = new StatusResponse();
        boolean result = enterpriseService.updateEnterprise(enterprise);
        if (result) {
            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);

        } else {
            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
        }
        return statusResponse;
    }
}

