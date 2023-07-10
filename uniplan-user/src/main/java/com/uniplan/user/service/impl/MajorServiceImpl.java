package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Major;
import com.uniplan.user.mapper.MajorMapper;
import com.uniplan.user.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 97727
 * @description 针对表【major(专业信息表)】的数据库操作Service实现
 * @createDate 2023-06-11 11:07:35
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
        implements MajorService {
    @Autowired
    MajorMapper majorMapper;

    @Override
    public Boolean addMajor(Major major) {
        return majorMapper.insert(major) > 0;
    }

    @Override
    public List<Major> selectMajor() {
        QueryWrapper<Major> MajorQueryWrapper = new QueryWrapper<>();
        return majorMapper.selectList(MajorQueryWrapper);
    }

    @Override
    public Boolean updateMajor(Major major) {
        return majorMapper.updateById(major) > 0;
    }

    @Override
    public Boolean deleteMajor(String id) {
        return majorMapper.deleteById(id) > 0;

    }
}




