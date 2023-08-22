package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.common.ErrorCode;
import com.uniplan.user.exception.BusinessException;
import com.uniplan.user.exception.ThrowUtils;
import com.uniplan.user.mapper.EnterpriseMapper;
import com.uniplan.user.mapper.StudentInfoMapper;
import com.uniplan.user.mapper.UniversityMapper;
import com.uniplan.user.mapper.UserGeneralMapper;
import com.uniplan.user.model.domain.Enterprise;
import com.uniplan.user.model.domain.StudentInfo;
import com.uniplan.user.model.domain.University;
import com.uniplan.user.model.domain.UserGeneral;
import com.uniplan.user.model.dto.user.EnterpriseRegisterRequest;
import com.uniplan.user.model.dto.user.UniversityRegisterRequest;
import com.uniplan.user.model.dto.user.UserQueryRequest;
import com.uniplan.user.model.dto.user.UserRegisterRequest;
import com.uniplan.user.service.UserGeneralService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.uniplan.user.constant.UserConstant.USER_LOGIN_STATE;
import static com.uniplan.user.model.enums.UserRoleEnum.*;

/**
 * @author 97727
 * @description 针对表【user_genneral("用户通用信息表")】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
@CacheConfig(cacheNames = "UserGeneralServiceImpl")
public class UserGeneralServiceImpl extends ServiceImpl<UserGeneralMapper, UserGeneral> implements UserGeneralService {
    @Resource
    StudentInfoMapper studentInfoMapper;
    @Resource
    EnterpriseMapper enterpriseMapper;
    @Autowired
    UserGeneralService userGeneralService;
    @Resource
    UserGeneralMapper userGeneralMapper;
    @Resource
    UniversityMapper universityMapper;

    @Override
    @CacheEvict(allEntries = true)
    public String userRegister(UserGeneral userGeneral) {

        //ID，注册时间（生成当前时间），逻辑删除（默认0）
        String id = UUID.randomUUID().toString().replace("-", "");
        userGeneral.setId(id);
        //修改个字段，日期全部改为字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        //获取日期
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(now);
        userGeneral.setTime(date);
        userGeneralMapper.insert(userGeneral);
        return id;
    }


    @Override
    @CacheEvict(allEntries = true)
    public void studentRegister(UserRegisterRequest userRegisterRequest) {

        //长度格式校验

        UserGeneral user = new UserGeneral();
        //校验两次输入的密码是否一致
        boolean result = userRegisterRequest.getPassword().equals(userRegisterRequest.getConfirmPassword());
        //抛出异常
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);

        //校验账号密码

        QueryWrapper<UserGeneral> queryWrapper = new QueryWrapper<>();
        //如果是邮箱或者电话号码注册，判断是否存在

        //对密码进行加密，或者其他信息加密，存入数据库

        //设置用户的信息
        user.setAccount(userRegisterRequest.getAccount());
        user.setPassword(userRegisterRequest.getPassword());
        user.setRole(STUDENT.getValue());

        //返回用户id
        String userId = userGeneralService.userRegister(user);
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
    @CacheEvict(allEntries = true)
    public void enterpriseRegister(EnterpriseRegisterRequest enterpriseRegisterRequest) {

        //长度格式校验

        UserGeneral user = new UserGeneral();
        //校验两次输入的密码是否一致
        boolean result = enterpriseRegisterRequest.getPassword().equals(enterpriseRegisterRequest.getConfirmPassword());
        //抛出异常
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);

        //校验账号密码

        QueryWrapper<UserGeneral> queryWrapper = new QueryWrapper<>();
        //如果是邮箱或者电话号码注册，判断是否存在

        //对密码进行加密，或者其他信息加密，存入数据库

        //设置用户的信息
        user.setAccount(enterpriseRegisterRequest.getAccount());
        user.setPassword(enterpriseRegisterRequest.getPassword());
        user.setRole(ENTERPRISE.getValue());

        //返回用户id
        String userId = userGeneralService.userRegister(user);
        ThrowUtils.throwIf(userId == null || userId.equals(""), ErrorCode.SYSTEM_ERROR);

        //设置学生用户的信息
        Enterprise enterprise = new Enterprise();
        String id = UUID.randomUUID().toString().replace("-", "");
        enterprise.setId(id);
        enterprise.setUserId(userId);
        int i = enterpriseMapper.insert(enterprise);
        //用户添加失败，抛异常
        ThrowUtils.throwIf(i <= 0, ErrorCode.SYSTEM_ERROR);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void universityRegister(UniversityRegisterRequest universityRegisterRequest) {

        //长度格式校验

        UserGeneral user = new UserGeneral();
        //校验两次输入的密码是否一致
        boolean result = universityRegisterRequest.getPassword().equals(universityRegisterRequest.getConfirmPassword());
        //抛出异常
        ThrowUtils.throwIf(!result, ErrorCode.PARAMS_ERROR);

        //校验账号密码

        QueryWrapper<UserGeneral> queryWrapper = new QueryWrapper<>();
        //如果是邮箱或者电话号码注册，判断是否存在

        //对密码进行加密，或者其他信息加密，存入数据库

        //设置用户的信息
        user.setAccount(universityRegisterRequest.getAccount());
        user.setPassword(universityRegisterRequest.getPassword());
        user.setRole(UNIVERSITY.getValue());

        //返回用户id
        String userId = userGeneralService.userRegister(user);
        ThrowUtils.throwIf(userId == null || userId.equals(""), ErrorCode.SYSTEM_ERROR);

        //设置学生用户的信息
        University university = new University();
        String id = UUID.randomUUID().toString().replace("-", "");
        university.setId(id);
        university.setUserId(userId);
        int i = universityMapper.insert(university);
        //用户添加失败，抛异常
        ThrowUtils.throwIf(i <= 0, ErrorCode.SYSTEM_ERROR);
    }

    @Override
    @Cacheable
    public String studentLogin(String account, String password, HttpSession session) {
        QueryWrapper<UserGeneral> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("account", account);
        UserGeneral userGeneral = userGeneralMapper.selectOne(studentQueryWrapper);
        ThrowUtils.throwIf(userGeneral == null, ErrorCode.NOT_FOUND_ERROR);

        //将对象存入session
        session.setAttribute("login", userGeneral);

        //返回脱敏后的用户数据
        return userGeneral.toString();
    }

    @Override
    @Cacheable
    public UserGeneral studentLogin(String account, String password) {
        QueryWrapper<UserGeneral> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("account", account);
        UserGeneral userGeneral = userGeneralMapper.selectOne(studentQueryWrapper);
        ThrowUtils.throwIf(userGeneral == null, ErrorCode.NOT_FOUND_ERROR);


        //返回脱敏后的用户数据
        return userGeneral;
    }
    @Override
    @Cacheable
    public String enterpriseLogin(String account, String password, HttpSession session) {
        QueryWrapper<UserGeneral> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("account", account);
        UserGeneral userGeneral = userGeneralMapper.selectOne(studentQueryWrapper);
        ThrowUtils.throwIf(userGeneral == null, ErrorCode.NOT_FOUND_ERROR);

        //将对象存入session
        session.setAttribute("login", userGeneral);

        //返回脱敏后的用户数据
        return userGeneral.toString();
    }

    @Override
    @Cacheable
    public String universityLogin(String account, String password, HttpSession session) {
        QueryWrapper<UserGeneral> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("account", account);
        UserGeneral userGeneral = userGeneralMapper.selectOne(studentQueryWrapper);
        ThrowUtils.throwIf(userGeneral == null, ErrorCode.NOT_FOUND_ERROR);

        //将对象存入session
        session.setAttribute("login", userGeneral);

        //返回脱敏后的用户数据
        return userGeneral.toString();
    }

    @Override
    @Cacheable
    public UserGeneral getLoginUser(HttpServletRequest request) {
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        UserGeneral currentUser = (UserGeneral) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 从数据库查询（追求性能的话可以注释，直接走缓存）
        String userId = currentUser.getId();
        currentUser = this.getById(userId);
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    }

    @Override
    @Cacheable
    public QueryWrapper<UserGeneral> getQueryWrapper(UserQueryRequest userQueryRequest) {
        if (userQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        String id = userQueryRequest.getId();
        String account = userQueryRequest.getAccount();
        String role = userQueryRequest.getRole();
        String sortField = userQueryRequest.getSortField();
        String sortOrder = userQueryRequest.getSortOrder();
        QueryWrapper<UserGeneral> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.like(StringUtils.isNotBlank(account), "account", account);
        return queryWrapper;
    }
    @Override
    @Cacheable
    public UserGeneral getUserById(String id) {
        UserGeneral user = userGeneralMapper.selectById(id);
        return user;
    }

}