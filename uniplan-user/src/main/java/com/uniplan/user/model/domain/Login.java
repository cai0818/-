package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 登陆信息表
 * @TableName login
 */
@TableName(value ="login")
@Data
public class Login implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 登录设备
     */
    private String equipment;

    /**
     * 创建时间
     */
    private String loTime;

    /**
     * 更新时间
     */
    private String loUpdateTime;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}