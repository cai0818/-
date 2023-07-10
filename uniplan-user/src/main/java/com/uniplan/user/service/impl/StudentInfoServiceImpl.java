package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.StudentInfo;
import com.uniplan.user.mapper.StudentInfoMapper;
import com.uniplan.user.service.StudentInfoService;
import org.springframework.stereotype.Service;

/**
 * @author 97727
 * @description 针对表【student_info(学生用户信息表)】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {

}




