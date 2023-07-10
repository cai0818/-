package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(value = "id")
    private String id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 推荐高校
     */
    @TableField(value = "recommended_university")
    private String recommendedUniversity;

    /**
     * 推荐专业
     */
    @TableField(value = "recommend_major")
    private String recommendMajor;

    /**
     * 推荐企业
     */
    @TableField(value = "recommend_enterprise")
    private String recommendEnterprise;

    /**
     * 推荐岗位
     */
    @TableField(value = "recommend_career")
    private String recommendCareer;

    /**
     * 删除状态
     */
    @TableLogic(value = "is_delete")
    private String isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}