package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

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
    @TableId
    private String id;

    /**
     * 角色
     */
    private String role;

    /**
     * 权限
     */
    private String permission;

    /**
     * 删除状态
     */
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}