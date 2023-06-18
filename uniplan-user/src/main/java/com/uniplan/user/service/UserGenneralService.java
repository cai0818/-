package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.VO.StudentVO;
import com.uniplan.user.domain.UserGenneral;

/**
 * @author 97727
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service
 * @createDate 2023-06-11 11:07:35
 */
public interface UserGenneralService extends IService<UserGenneral> {
    String userRegister(UserGenneral user);

    void studentRegister(StudentVO studentVO);

    String studentLogin(StudentVO studentVo);
}
