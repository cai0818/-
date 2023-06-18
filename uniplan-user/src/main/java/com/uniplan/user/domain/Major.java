package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 专业信息表
 * @TableName major
 */
@TableName(value ="major")
@Data
public class Major implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 专业名称
     */
    @TableField(value = "ma_name")
    private String maName;

    /**
     * 专业介绍
     */
    @TableField(value = "ma_introduction")
    private String maIntroduction;

    /**
     * 专业类型
     */
    @TableField(value = "ma_type")
    private String maType;

    /**
     * 专业编号
     */
    @TableField(value = "ma_number")
    private String maNumber;

    /**
     * 专业层次
     */
    @TableField(value = "ma_degree_level")
    private String maDegreeLevel;

    /**
     * 删除状态
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}