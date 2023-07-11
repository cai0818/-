package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * '
 * @TableName un_to_major
 */
@TableName(value ="un_to_major")
@Data
public class UnToMajor implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 专业id
     */
    private String majorId;

    /**
     * 高校id
     */
    private String unId;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}