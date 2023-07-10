package com.uniplan.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uniplan.user.model.domain.Album;
import com.uniplan.user.mapper.AlbumMapper;
import com.uniplan.user.service.AlbumService;
import org.springframework.stereotype.Service;

/**
* @author 97727
* @description 针对表【album】的数据库操作Service实现
* @createDate 2023-06-11 11:07:35
*/
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album>
    implements AlbumService {

}




