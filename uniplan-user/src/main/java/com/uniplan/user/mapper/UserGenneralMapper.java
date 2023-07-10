package com.uniplan.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uniplan.user.model.domain.UserGenneral;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 97727
* @description 针对表【user_genneral("用户通用信息表")】的数据库操作Mapper
* @createDate 2023-06-11 11:04:24
* @Entity com.uniplan.user.domain.UserGenneral
*/
@Mapper
public interface UserGenneralMapper extends BaseMapper<UserGenneral> {

}




