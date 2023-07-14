package com.uniplan.user.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.UserGeneral;
import com.uniplan.user.model.dto.user.EnterpriseRegisterRequest;
import com.uniplan.user.model.dto.user.UniversityRegisterRequest;
import com.uniplan.user.model.dto.user.UserQueryRequest;
import com.uniplan.user.model.dto.user.UserRegisterRequest;

import javax.servlet.http.HttpSession;

/**
 * @author 97727
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service
 * @createDate 2023-06-11 11:07:35
 */
public interface UserGeneralService extends IService<UserGeneral> {
    String userRegister(UserGeneral user);

    void studentRegister(UserRegisterRequest userRegisterRequest);

    void enterpriseRegister(EnterpriseRegisterRequest enterpriseRegisterRequest);

    void universityRegister(UniversityRegisterRequest universityRegisterRequest);

    String studentLogin(String account, String password, HttpSession session);

    String enterpriseLogin(String account, String password, HttpSession session);

    String universityLogin(String account, String password, HttpSession session);

    QueryWrapper<UserGeneral> getQueryWrapper(UserQueryRequest userQueryRequest);
}
