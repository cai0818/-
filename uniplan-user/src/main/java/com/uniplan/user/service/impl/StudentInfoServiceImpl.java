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
import com.uniplan.user.service.StudentInfoService;
import com.uniplan.user.service.UserGenneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 97727
 * @description 针对表【student_info(学生用户信息表)】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {

}




