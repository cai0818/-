package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(value = "id")
    private String id;

    /**
     * 高校账户
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 高校名称
     */
    @TableField(value = "un_name")
    private String unName;

    /**
     * 热门专业
     */
    @TableField(value = "un_popular_majors")
    private String unPopularMajors;

    /**
     * 高校简介
     */
    @TableField(value = "un_introduction")
    private String unIntroduction;

    /**
     * 高校标签
     */
    @TableField(value = "un_tag")
    private String unTag;

    /**
     * 调剂方法
     */
    @TableField(value = "un_removeway")
    private String unRemoveway;

    /**
     * 网报公告
     */
    @TableField(value = "un_annoucement")
    private String unAnnoucement;

    /**
     * 招生简章
     */
    @TableField(value = "un_prospectus")
    private String unProspectus;

    /**
     * 省
     */
    @TableField(value = "un_province")
    private String unProvince;

    /**
     * 市
     */
    @TableField(value = "un_town")
    private String unTown;

    /**
     * 区
     */
    @TableField(value = "un_area")
    private String unArea;

    /**
     * 详细地址
     */
    @TableField(value = "un_location")
    private String unLocation;

    /**
     * 高校编号
     */
    @TableField(value = "un_number")
    private Integer unNumber;

    /**
     * 删除状态
     */
    @TableLogic(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}