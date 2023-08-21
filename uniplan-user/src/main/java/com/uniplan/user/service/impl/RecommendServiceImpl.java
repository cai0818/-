package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Recommend;
import com.uniplan.user.mapper.RecommendMapper;
import com.uniplan.user.service.RecommendService;
import org.springframework.stereotype.Service;

/**
* @description 针对表【recommend(推荐内容)】的数据库操作Service实现
*/
@Service
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend>
    implements RecommendService {

}




