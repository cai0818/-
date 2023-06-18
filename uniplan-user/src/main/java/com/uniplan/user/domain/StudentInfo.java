package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生用户信息表
 * @TableName student_info
 */
@TableName(value ="student_info")
@Data
public class StudentInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 学历
     */
    @TableField(value = "degree")
    private Integer degree;

    /**
     * 学校
     */
    @TableField(value = "school")
    private String school;

    /**
     * 专业
     */
    @TableField(value = "major")
    private String major;

    /**
     * 学号
     */
    @TableField(value = "s_number")
    private String sNumber;

    /**
     * 删除状态
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}