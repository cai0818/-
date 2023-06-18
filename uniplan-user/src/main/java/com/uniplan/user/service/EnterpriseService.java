package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.domain.Enterprise;

import java.util.List;

/**
* @author 97727
* @description 针对表【enterprise(企业信息表)】的数据库操作Service
* @createDate 2023-06-11 11:07:35
*/
public interface EnterpriseService extends IService<Enterprise> {

    Boolean addEnterprise(com.uniplan.user.domain.Enterprise enterprise);

    List<Enterprise> selectEnterprise();

    Boolean updateEnterprise(com.uniplan.user.domain.Enterprise enterprise);

    Boolean deleteEnterprise(String id);
}
