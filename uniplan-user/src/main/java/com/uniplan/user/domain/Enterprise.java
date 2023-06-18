package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业信息表
 * @TableName enterprise
 */
@TableName(value ="enterprise")
@Data
public class Enterprise implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 企业id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 企业官网
     */
    @TableField(value = "official_website")
    private String officialWebsite;

    /**
     * 企业名称
     */
    @TableField(value = "en_name")
    private String enName;

    /**
     * 企业简介
     */
    @TableField(value = "en_introduction")
    private String enIntroduction;

    /**
     * 详细位置
     */
    @TableField(value = "en_location")
    private String enLocation;

    /**
     * 在招岗位
     */
    @TableField(value = "en_career")
    private String enCareer;

    /**
     * 企业类型
     */
    @TableField(value = "en_type")
    private String enType;

    /**
     * 法人代表
     */
    @TableField(value = "en_legal_personality")
    private String enLegalPersonality;

    /**
     * 经营范围
     */
    @TableField(value = "en_business_status")
    private Integer enBusinessStatus;

    /**
     * 注册资本
     */
    @TableField(value = "en_registered_capital")
    private Integer enRegisteredCapital;

    /**
     * 成立时间
     */
    @TableField(value = "en_date_of_establishment")
    private Date enDateOfEstablishment;

    /**
     * 注册地址
     */
    @TableField(value = "en_registered_address")
    private String enRegisteredAddress;

    /**
     * 统一社会信用代码
     */
    @TableField(value = "en_social_credit_code")
    private String enSocialCreditCode;

    /**
     * 经营范围
     */
    @TableField(value = "en_business_scope")
    private String enBusinessScope;

    /**
     * 省
     */
    @TableField(value = "en_province")
    private String enProvince;

    /**
     * 市
     */
    @TableField(value = "en_town")
    private String enTown;

    /**
     * 区
     */
    @TableField(value = "en_area")
    private String enArea;

    /**
     * 删除状态
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}