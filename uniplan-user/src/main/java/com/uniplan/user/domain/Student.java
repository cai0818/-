package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String sName;

    /**
     * 学历
     */
    private Integer sDegree;

    /**
     * 学校
     */
    private String sSchool;

    /**
     * 专业
     */
    private String sMajor;

    /**
     * 学号
     */
    private String sNumber;

    /**
     * 逻辑删除，0未删除，1已删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}