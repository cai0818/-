package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Enterprise;
import com.uniplan.user.mapper.EnterpriseMapper;
import com.uniplan.user.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 97727
* @description 针对表【enterprise(企业信息表)】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise>
    implements EnterpriseService {
    @Autowired
   EnterpriseMapper enterpriseMapper;

    @Override
    public Boolean addEnterprise(Enterprise enterprise) {
        return enterpriseMapper.insert(enterprise) > 0;
    }

    @Override
    public List<Enterprise> selectEnterprise() {
        QueryWrapper<Enterprise> EnterpriseQueryWrapper = new QueryWrapper<>();
        return enterpriseMapper.selectList(EnterpriseQueryWrapper);
    }

    @Override
    public Boolean updateEnterprise(Enterprise enterprise) {
        return enterpriseMapper.updateById(enterprise) > 0;
    }

    @Override
    public Boolean deleteEnterprise(String id) {
        return enterpriseMapper.deleteById(id) > 0;
    }

}




