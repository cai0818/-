package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.dto.UserLoginRequest;
import com.uniplan.user.model.dto.UserRegisterRequest;
import com.uniplan.user.model.vo.StudentVO;
import com.uniplan.user.model.domain.UserGenneral;

/**
 * @author 97727
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service
 * @createDate 2023-06-11 11:07:35
 */
public interface UserGenneralService extends IService<UserGenneral> {
    String userRegister(UserGenneral user);

    void studentRegister(UserRegisterRequest userRegisterRequest);

    String studentLogin(UserLoginRequest userLoginRequest);
}
