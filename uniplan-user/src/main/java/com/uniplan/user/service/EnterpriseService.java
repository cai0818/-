package com.uniplan.user.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.Enterprise;
import com.uniplan.user.model.dto.enterprise.EnterpriseQueryRequest;

import java.util.List;

/**
* @description 针对表【enterprise(企业信息表)】的数据库操作Service
*/
public interface EnterpriseService extends IService<Enterprise> {

    Boolean addEnterprise(Enterprise enterprise);

    List<Enterprise> selectEnterprise();

    Boolean updateEnterprise(Enterprise enterprise);

    Boolean deleteEnterprise(String id);

    QueryWrapper<Enterprise> getQueryWrapper(EnterpriseQueryRequest enterpriseQueryRequestQueryRequest);
}
