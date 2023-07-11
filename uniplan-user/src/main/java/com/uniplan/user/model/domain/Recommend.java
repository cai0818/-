package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 推荐内容
 * @TableName recommend
 */
@TableName(value ="recommend")
@Data
public class Recommend implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 推荐高校
     */
    private String recommendedUniversity;

    /**
     * 推荐专业
     */
    private String recommendMajor;

    /**
     * 推荐企业
     */
    private String recommendEnterprise;

    /**
     * 推荐岗位
     */
    private String recommendCareer;

    /**
     * 删除状态
     */
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}