package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.Major;

import java.util.List;

/**
* @author 97727
* @description 针对表【major(专业信息表)】的数据库操作Service
* @createDate 2023-06-11 11:07:35
*/
public interface MajorService extends IService<Major> {

    Boolean addMajor(Major major);

    List<Major> selectMajor();

    Boolean updateMajor(Major major);

    Boolean deleteMajor(String id);
}
