package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * "用户通用信息表"
 * @TableName user_general
 */
@TableName(value ="user_general")
@Data
public class UserGeneral implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * "账号"
     */
    private String account;

    /**
     * "用户密码"
     */
    private String password;

    /**
     * "角色"
     */
    private Integer role;

    /**
     * "注册时间"
     */
    private String time;

    /**
     * "绑定电话"
     */
    private String phone;

    /**
     * "绑定邮箱"
     */
    private String email;

    /**
     * "删除状态"
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}