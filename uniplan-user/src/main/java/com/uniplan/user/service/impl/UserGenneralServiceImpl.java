package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.common.ErrorCode;
import com.uniplan.user.exception.ThrowUtils;
import com.uniplan.user.mapper.StudentInfoMapper;
import com.uniplan.user.mapper.UserGenneralMapper;
import com.uniplan.user.model.domain.StudentInfo;
import com.uniplan.user.model.domain.UserGenneral;
import com.uniplan.user.model.dto.UserLoginRequest;
import com.uniplan.user.model.dto.UserRegisterRequest;
import com.uniplan.user.model.vo.StudentVO;
import com.uniplan.user.service.UserGenneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/**
 * @author 97727
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
public class UserGenneralServiceImpl extends ServiceImpl<UserGenneralMapper, UserGenneral> implements UserGenneralService {
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    UserGenneralService userGenneralService;
    @Autowired
    UserGenneralMapper userGenneralMapper;

    @Override
    public String userRegister(UserGenneral userGenneral) {

        //ID，注册时间（生成当前时间），逻辑删除（默认0）
        String id = UUID.randomUUID().toString().replace("-", "");
        Date date = new Date();
        userGenneral.setId(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        userGenneral.setTime(date);
        userGenneralMapper.insert(userGenneral);
        return id;
    }


    @Override
    public void studentRegister(UserRegisterRequest userRegisterRequest) {

        QueryWrapper<UserGenneral> queryWrapper = new QueryWrapper<>();
        //如果是邮箱或者电话号码注册，判断是否存在

        UserGenneral user = new UserGenneral();
        //校验账号密码，确认密码
        boolean result = userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword());
        //抛出异常
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);

        //设置用户的信息
        user.setAccount(userRegisterRequest.getAccount());
        user.setPassword(userRegisterRequest.getPassword());
        user.setRole(0);

        //返回用户id
        String userId = userGenneralService.userRegister(user);
        ThrowUtils.throwIf(userId == null || userId.equals(""), ErrorCode.SYSTEM_ERROR);

        //设置学生用户的信息
        StudentInfo student = new StudentInfo();
        String id = UUID.randomUUID().toString().replace("-", "");
        student.setId(id);
        student.setUserId(userId);
//        student.setName(userRegisterRequest.getName());
//        student.setSchool(userRegisterRequest.getSchool());
//        student.setMajor(userRegisterRequest.getMajor());
//        student.setDegree(userRegisterRequest.getDegree());
//        student.setSNumber(userRegisterRequest.getSNumber());
        int i = studentInfoMapper.insert(student);
        //用户添加失败，抛异常
        ThrowUtils.throwIf(i <= 0, ErrorCode.SYSTEM_ERROR);
    }

    @Override
    public String studentLogin(UserLoginRequest userLoginRequest) {
        String account = userLoginRequest.getAccount();
        QueryWrapper<UserGenneral> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("account", account);
        List<UserGenneral> list = userGenneralMapper.selectList(studentQueryWrapper);
        ThrowUtils.throwIf(list == null, ErrorCode.NOT_FOUND_ERROR);
        //获取学生的id,生成token
        return "token:" + userLoginRequest;
    }
}




