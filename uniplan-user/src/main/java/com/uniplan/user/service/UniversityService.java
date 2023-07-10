package com.uniplan.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.uniplan.user.model.domain.University;

import java.util.List;

/**
* @author 97727
* @description 针对表【university(高校信息表)】的数据库操作Service
* @createDate 2023-06-11 11:07:35
*/
public interface UniversityService extends IService<University> {

    Boolean addUniversity(University university);

    List<University> selectUniversity();

    Boolean updateUniversity(University university);

    Boolean deleteUniversity(String id);
}
