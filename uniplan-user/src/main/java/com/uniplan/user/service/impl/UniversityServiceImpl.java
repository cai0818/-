package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.common.ErrorCode;
import com.uniplan.user.exception.BusinessException;
import com.uniplan.user.mapper.UniversityMapper;
import com.uniplan.user.model.domain.University;
import com.uniplan.user.model.dto.university.UniversityQueryRequest;
import com.uniplan.user.service.UniversityService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 97727
 * @description 针对表【university(高校信息表)】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
@CacheConfig(cacheNames="UniversityServiceImpl")
public class UniversityServiceImpl extends ServiceImpl<UniversityMapper, University>
        implements UniversityService {
    @Resource
    UniversityMapper universityMapper;

    @Override
    @CachePut(key = "#university.id") // 添加University，并更新缓存
    public Boolean addUniversity(University university) {
        return universityMapper.insert(university) > 0;
    }

    @Override
    @Cacheable
    public List<University> selectUniversity() {
        QueryWrapper<University> UniversityQueryWrapper = new QueryWrapper<>();
        return universityMapper.selectList(UniversityQueryWrapper);
    }

    @Override
    @CachePut(key = "#university.id") // 更新University信息，并更新缓存
    public Boolean updateUniversity(University university) {
        return universityMapper.updateById(university) > 0;
    }

    @Override
    @CacheEvict(key = "#id") // 删除University，并清除缓存
    public Boolean deleteUniversity(String id) {
        return universityMapper.deleteById(id) > 0;
    }

    @Override
    public QueryWrapper<University> getQueryWrapper(UniversityQueryRequest universityQueryRequest) {
        if (universityQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        String id = universityQueryRequest.getId();
        String sortField = universityQueryRequest.getSortField();
        String sortOrder = universityQueryRequest.getSortOrder();
        QueryWrapper<University> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        return queryWrapper;
    }
}




