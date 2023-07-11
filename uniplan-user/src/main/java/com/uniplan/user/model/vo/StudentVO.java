package com.uniplan.user.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentVO {
    /**
     * "账号"
     */
    private String account;

    /**
     * "用户密码"
     */
    private String password;

    /**
     * "角色"
     */
    private Integer role;

    /**
     * "注册时间"
     */
    private Date time;

    /**
     * "绑定电话"
     */
    private String phone;

    /**
     * "绑定邮箱"
     */
    private String email;

    /**
     * "标签"
     */
    private String tag;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 学历
     */
    private Integer degree;

    /**
     * 学校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 学号
     */
    private String sNumber;

    /**
     * 删除状态
     */
    private Integer isDelete;

}
