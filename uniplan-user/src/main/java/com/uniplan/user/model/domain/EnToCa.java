package com.uniplan.user.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
    @TableId(value = "id")
    private String id;

    /**
     * 企业id
     */
    @TableField(value = "en_id")
    private String enId;

    /**
     * 岗位id
     */
    @TableField(value = "ca_id")
    private String caId;

    /**
     * 删除状态
     */
    @TableLogic(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}