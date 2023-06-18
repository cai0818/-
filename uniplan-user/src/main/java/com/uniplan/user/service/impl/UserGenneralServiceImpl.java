package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.VO.StudentVO;
import com.uniplan.user.common.ErrorCode;
import com.uniplan.user.domain.StudentInfo;
import com.uniplan.user.domain.UserGenneral;
import com.uniplan.user.exception.ThrowUtils;
import com.uniplan.user.mapper.StudentInfoMapper;
import com.uniplan.user.mapper.UserGenneralMapper;
import com.uniplan.user.service.UserGenneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* @author 97727
* @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class UserGenneralServiceImpl extends ServiceImpl<UserGenneralMapper, UserGenneral>
    implements UserGenneralService {
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    UserGenneralService userGenneralService;
    @Autowired
    UserGenneralMapper userGenneralMapper;

    @Override
    public String userRegister(UserGenneral user) {

        //ID，注册时间（生成当前时间），逻辑删除（默认0）
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        user.setTime(new Date());
        userGenneralMapper.insert(user);
        //抛出异常
        if(id == null){
            //抛出异常

        }
        return id;
    }



    @Override
    public void studentRegister(StudentVO studentVO) {

        //todo 查询账号，手机号是否存在
        QueryWrapper<UserGenneral> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("acount", studentVO.getAccount());
        Long n = userGenneralMapper.selectCount(queryWrapper);
        //抛出异常
        ThrowUtils.throwIf(!(n == 0), ErrorCode.NOT_FOUND_ERROR);
        UserGenneral user = new UserGenneral();
        boolean result = !studentVO.getPassword().equals(studentVO.getConfirmPassword());
        //抛出异常
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);
        user.setAcount(studentVO.getAccount());
        user.setPassword(studentVO.getPassword());

        //返回用户id
        String userId = userGenneralService.userRegister(user);
        ThrowUtils.throwIf(userId == null, ErrorCode.SYSTEM_ERROR);
        StudentInfo student = new StudentInfo();
        String id = UUID.randomUUID().toString().replace("-", "");
        student.setId(id);
        student.setUserId(userId);
        student.setName(studentVO.getName());
        student.setSchool(studentVO.getSchool());
        student.setMajor(studentVO.getMajor());
        student.setDegree(studentVO.getDegree());
        student.setSNumber(studentVO.getSNumber());
        studentInfoMapper.insert(student);

        //失败，抛异常
    }

    @Override
    public String studentLogin(StudentVO studentVo) {
        String account = studentVo.getAccount();
        QueryWrapper<UserGenneral> studentQueryWrapper = new QueryWrapper<UserGenneral>();
        studentQueryWrapper.eq("acount", account);
        List<UserGenneral> list = userGenneralMapper.selectList(studentQueryWrapper);
        ThrowUtils.throwIf(list == null, ErrorCode.NOT_FOUND_ERROR);
        //获取学生的id,生成token
        return "token:" + studentVo;
    }
}




