package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName album
 */
@TableName(value ="album")
@Data
public class Album implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "photo1")
    private String photo1;

    /**
     * 
     */
    @TableField(value = "photo2")
    private String photo2;

    /**
     * 
     */
    @TableField(value = "photo3")
    private String photo3;

    /**
     * 
     */
    @TableField(value = "photo4")
    private String photo4;

    /**
     * 
     */
    @TableField(value = "photo5")
    private String photo5;

    /**
     * 
     */
    @TableField(value = "owner_id")
    private String ownerId;

    /**
     * 
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}