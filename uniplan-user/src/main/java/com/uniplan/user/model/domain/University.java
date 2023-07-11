package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 高校信息表
 * @TableName university
 */
@TableName(value ="university")
@Data
public class University implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 高校账户
     */
    private String userId;

    /**
     * 高校名称
     */
    private String unName;

    /**
     * 热门专业
     */
    private String unPopularMajors;

    /**
     * 高校简介
     */
    private String unIntroduction;

    /**
     * 高校标签
     */
    private String unTag;

    /**
     * 调剂方法
     */
    private String unAdjust;

    /**
     * 网报公告
     */
    private String unNotice;

    /**
     * 招生简章
     */
    private String unProspectus;

    /**
     * 省
     */
    private String unProvince;

    /**
     * 市
     */
    private String unTown;

    /**
     * 区
     */
    private String unArea;

    /**
     * 详细地址
     */
    private String unLocation;

    /**
     * 高校编号
     */
    private Integer unNumber;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}