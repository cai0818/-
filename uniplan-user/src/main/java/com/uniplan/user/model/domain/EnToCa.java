package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 企业岗位对应信息表
 * @TableName en_to_ca
 */
@TableName(value ="en_to_ca")
@Data
public class EnToCa implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 企业id
     */
    private String enId;

    /**
     * 岗位id
     */
    private String caId;

    /**
     * 删除状态
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}