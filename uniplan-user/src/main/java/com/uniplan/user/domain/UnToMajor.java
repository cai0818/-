package com.uniplan.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(value = "id")
    private String id;

    /**
     * 专业id
     */
    @TableField(value = "major_id")
    private String majorId;

    /**
     * 高校id
     */
    @TableField(value = "un_id")
    private String unId;

    /**
     * 删除状态
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}