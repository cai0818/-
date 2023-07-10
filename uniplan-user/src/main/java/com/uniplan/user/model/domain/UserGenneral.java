package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * "用户通用信息表"
 * @TableName user_genneral
 */
@TableName(value ="user_genneral")
@Data
public class UserGenneral implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * "账号"
     */
    @TableField(value = "account")
    private String account;

    /**
     * "用户密码"
     */
    @TableField(value = "password")
    private String password;

    /**
     * "角色"
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * "注册时间"
     */
    @TableField(value = "time")
    private Date time;

    /**
     * "绑定电话"
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * "绑定邮箱"
     */
    @TableField(value = "mailbox")
    private String mailbox;

    /**
     * "标签"
     */
    @TableField(value = "tag")
    private String tag;

    /**
     * "删除状态"
     */
    @TableLogic(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}