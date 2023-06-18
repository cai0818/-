package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName un_to_ma
 */
@TableName(value ="un_to_ma")
@Data
public class UnToMa implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 专业id
     */
    private String majorId;

    /**
     * 学校id
     */
    private String unId;

    /**
     * 逻辑删除，0未删除，1已删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}