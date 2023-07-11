package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

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
    @TableId
    private String id;

    /**
     * 
     */
    private String photo1;

    /**
     * 
     */
    private String photo2;

    /**
     * 
     */
    private String photo3;

    /**
     * 
     */
    private String photo4;

    /**
     * 
     */
    private String photo5;

    /**
     * 
     */
    private String ownerId;

    /**
     * 
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}