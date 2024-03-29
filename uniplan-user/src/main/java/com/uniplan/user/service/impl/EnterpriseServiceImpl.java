package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.common.ErrorCode;
import com.uniplan.user.exception.BusinessException;
import com.uniplan.user.mapper.EnterpriseMapper;
import com.uniplan.user.model.domain.Enterprise;
import com.uniplan.user.model.dto.enterprise.EnterpriseQueryRequest;
import com.uniplan.user.service.EnterpriseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 97727
* @description 针对表【enterprise(企业信息表)】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
@CacheConfig(cacheNames = "enterpriseCache")
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise>
    implements EnterpriseService {
    @Resource
   EnterpriseMapper enterpriseMapper;

    @Override
    @CacheEvict(allEntries = true) // 清空缓存，当有新增、更新、删除操作时
    public Boolean addEnterprise(Enterprise enterprise) {
        return enterpriseMapper.insert(enterprise) > 0;
    }

    @Override
    @Cacheable
    public List<Enterprise> selectEnterprise() {
        QueryWrapper<Enterprise> EnterpriseQueryWrapper = new QueryWrapper<>();
        return enterpriseMapper.selectList(EnterpriseQueryWrapper);
    }

    @Override
    @CachePut(key = "#enterprise.id") // 更新缓存，当有更新操作时
    public Boolean updateEnterprise(Enterprise enterprise) {
        return enterpriseMapper.updateById(enterprise) > 0;
    }

    @Override
    @CacheEvict(key = "#id") // 清除缓存，当有删除操作时
    public Boolean deleteEnterprise(String id) {
        return enterpriseMapper.deleteById(id) > 0;
    }

    @Override
    public QueryWrapper<Enterprise> getQueryWrapper(EnterpriseQueryRequest enterpriseQueryRequestQueryRequest) {
        if (enterpriseQueryRequestQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        String id = enterpriseQueryRequestQueryRequest.getId();
        String sortField = enterpriseQueryRequestQueryRequest.getSortField();
        String sortOrder = enterpriseQueryRequestQueryRequest.getSortOrder();
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        return queryWrapper;
    }
}




