package com.uniplan.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Login;
import com.uniplan.user.mapper.LoginMapper;
import com.uniplan.user.service.LoginService;
import org.springframework.stereotype.Service;
/**
* @author 97727
* @description 针对表【login(登陆信息表)】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login>
    implements LoginService {

}




