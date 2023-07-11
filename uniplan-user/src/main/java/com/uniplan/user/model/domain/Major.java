package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

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
    @TableId
    private String id;

    /**
     * 专业名称
     */
    private String maName;

    /**
     * 专业介绍
     */
    private String maIntroduction;

    /**
     * 专业类型
     */
    private String maType;

    /**
     * 专业编号
     */
    private String maNumber;

    /**
     * 专业层次
     */
    private String maDegreeLevel;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}