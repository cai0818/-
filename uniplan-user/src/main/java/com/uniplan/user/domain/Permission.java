package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName permission
 */
@TableName(value ="permission")
@Data
public class Permission implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 角色
     */
    @TableField(value = "role")
    private String role;

    /**
     * 权限
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 删除状态
     */
    @TableField(value = "is_delete")
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}