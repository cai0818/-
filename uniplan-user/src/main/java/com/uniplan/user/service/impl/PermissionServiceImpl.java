package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Permission;
import com.uniplan.user.mapper.PermissionMapper;
import com.uniplan.user.service.PermissionService;
import org.springframework.stereotype.Service;

/**
* @author 97727
* @description 针对表【permission】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService {

}




