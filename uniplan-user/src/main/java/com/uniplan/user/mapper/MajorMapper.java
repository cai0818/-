package com.uniplan.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uniplan.user.model.domain.Major;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 97727
* @description 针对表【major(专业信息表)】的数据库操作Mapper
* @createDate 2023-06-11 11:04:24
* @Entity com.uniplan.user.domain.Major
*/
@Mapper
public interface MajorMapper extends BaseMapper<Major> {

}




