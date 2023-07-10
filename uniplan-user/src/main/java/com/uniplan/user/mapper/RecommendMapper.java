package com.uniplan.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uniplan.user.model.domain.Recommend;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 97727
* @description 针对表【recommend(推荐内容)】的数据库操作Mapper
* @createDate 2023-06-11 11:04:24
* @Entity com.uniplan.user.domain.Recommend
*/
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {

}




