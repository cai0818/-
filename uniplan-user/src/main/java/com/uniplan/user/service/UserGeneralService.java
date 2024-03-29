package com.uniplan.user.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.UserGeneral;
import com.uniplan.user.model.dto.user.EnterpriseRegisterRequest;
import com.uniplan.user.model.dto.user.UniversityRegisterRequest;
import com.uniplan.user.model.dto.user.UserQueryRequest;
import com.uniplan.user.model.dto.user.UserRegisterRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service
 */
public interface UserGeneralService extends IService<UserGeneral> {
    String userRegister(UserGeneral user);

    void studentRegister(UserRegisterRequest userRegisterRequest);

    void enterpriseRegister(EnterpriseRegisterRequest enterpriseRegisterRequest);

    void universityRegister(UniversityRegisterRequest universityRegisterRequest);

    String studentLogin(String account, String password, HttpSession session);

    UserGeneral studentLogin(String account, String password);

    String enterpriseLogin(String account, String password, HttpSession session);

    String universityLogin(String account, String password, HttpSession session);

    UserGeneral getLoginUser(HttpServletRequest request);

    QueryWrapper<UserGeneral> getQueryWrapper(UserQueryRequest userQueryRequest);

    UserGeneral getUserById(String userid);
}
