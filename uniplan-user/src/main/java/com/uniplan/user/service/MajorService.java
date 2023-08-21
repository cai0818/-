package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.Major;

import java.util.List;

/**
* @description 针对表【major(专业信息表)】的数据库操作Service
*/
public interface MajorService extends IService<Major> {

    Boolean addMajor(Major major);

    List<Major> selectMajor();

    Boolean updateMajor(Major major);

    Boolean deleteMajor(String id);
}
