package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.domain.University;
import com.uniplan.user.mapper.UniversityMapper;
import com.uniplan.user.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 97727
* @description 针对表【university(高校信息表)】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class UniversityServiceImpl extends ServiceImpl<UniversityMapper, University>
    implements UniversityService {
    @Autowired
    UniversityMapper universityMapper;


    @Override
    public Boolean addUniversity(com.uniplan.user.domain.University university) {
        return universityMapper.insert(university) > 0;
    }

    @Override
    public List<University> selectUniversity() {
        QueryWrapper<com.uniplan.user.domain.University> UniversityQueryWrapper = new QueryWrapper<>();
        return universityMapper.selectList(UniversityQueryWrapper);
    }

    @Override
    public Boolean updateUniversity(com.uniplan.user.domain.University university) {
        return universityMapper.updateById(university) > 0;
    }

    @Override
    public Boolean deleteUniversity(String id) {
        return universityMapper.deleteById(id) > 0;
    }
}




