package com.uniplan.user.model.dto.enterprise;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.uniplan.user.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业查询请求
 */
@Data
public class EnterpriseQueryRequest extends PageRequest {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 企业id
     */
    private String userId;

    /**
     * 企业官网
     */
    private String officialWebsite;

    /**
     * 企业名称
     */
    private String enName;

    /**
     * 企业简介
     */
    private String enIntroduction;

    /**
     * 详细位置
     */
    private String enLocation;

    /**
     * 在招岗位
     */
    private String enCareer;

    /**
     * 企业类型
     */
    private String enType;

    /**
     * 法人代表
     */
    private String enLegalPersonality;

    /**
     * 经营范围
     */
    private Integer enBusinessStatus;

    /**
     * 注册资本
     */
    private Integer enRegisteredCapital;

    /**
     * 成立时间
     */
    private Date enDateOfEstablishment;

    /**
     * 注册地址
     */
    private String enRegisteredAddress;

    /**
     * 统一社会信用代码
     */
    private String enSocialCreditCode;

    /**
     * 经营范围
     */
    private String enBusinessScope;

    /**
     * 省
     */
    private String enProvince;

    /**
     * 市
     */
    private String enTown;

    /**
     * 区
     */
    private String enArea;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}