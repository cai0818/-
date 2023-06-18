package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName career
 */
@TableName(value ="career")
@Data
public class Career implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "ca_name")
    private String caName;

    /**
     * 
     */
    @TableField(value = "ca_type")
    private String caType;

    /**
     * 
     */
    @TableField(value = "ca_salary")
    private String caSalary;

    /**
     * 
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}