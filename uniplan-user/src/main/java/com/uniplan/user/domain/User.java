package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 账号
     */
    private String useraccount;

    /**
     * 密码
     */
    private String userpassword;

    /**
     * 角色，0管理员，1学生，2高校，3企业
     */
    private Integer role;

    /**
     * 注册时间
     */
    private Date time;

    /**
     * 逻辑删除，0未删除，1已删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}