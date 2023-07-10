package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(value = "id")
    private String id;

    /**
     * 登录设备
     */
    @TableField(value = "equipemnt")
    private String equipemnt;

    /**
     * 创建时间
     */
    @TableField(value = "lo_time")
    private String loTime;

    /**
     * 更新时间
     */
    @TableField(value = "lo_updatetime")
    private String loUpdatetime;

    /**
     * 用户id
     */
    @TableLogic(value = "user_id")
    private String userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}