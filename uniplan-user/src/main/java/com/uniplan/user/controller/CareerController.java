//package com.uniplan.user.controller;
//
//import com.uniplan.user.common.StatusResponse;
//import com.uniplan.user.common.StatusResponseCode;
//import com.uniplan.user.domain.Career;
//import com.uniplan.user.service.CareerService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@RestController
//@RequestMapping("/career")
//public class CareerController {
//    @Resource
//    CareerService careerService;
//
//    @PostMapping("/add")
//    public StatusResponse addCareer(@RequestBody Career career, HttpSession session) {
//        StatusResponse statusResponse = new StatusResponse();
//        boolean result = careerService.addCareer(career);
//        if (result) {
//            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
//        } else {
//            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
//        }
//        return statusResponse;
//    }
//
//    @GetMapping("/select")
//    public StatusResponse selectCareer(HttpSession session) {
//        StatusResponse statusResponse = new StatusResponse();
//        List<Career> careers = careerService.selectCareer();
//        if (careers != null) {
//            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
//            statusResponse.setData(careers);
//        } else {
//            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
//        }
//        return statusResponse;
//    }
//
//
//    @PostMapping("/delete")
//    public StatusResponse deleteCareer(@RequestBody Career career, HttpSession session) {
//        StatusResponse statusResponse = new StatusResponse();
//        boolean result = careerService.deleteCareer(career.getId());
//        if (result) {
//            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
//        } else {
//            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
//        }
//        return statusResponse;
//    }
//
//    @PostMapping("/update")
//    public StatusResponse updateCareer(@RequestBody Career career, HttpSession session) {
//        StatusResponse statusResponse = new StatusResponse();
//        boolean result = careerService.updateCareer(career);
//        if (result) {
//            statusResponse.setMsgAndCode(StatusResponseCode.SUCCESS);
//
//        } else {
//            statusResponse.setMsgAndCode(StatusResponseCode.ERROR);
//        }
//        return statusResponse;
//    }
//
//}
