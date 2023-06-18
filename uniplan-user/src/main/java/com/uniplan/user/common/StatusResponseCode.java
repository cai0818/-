package com.uniplan.user.common;

public enum StatusResponseCode {
    SUCCESS("1", "成功"),
    ERROR("0", "失败"),
    CODE_NOT_FOUND("404", "没有找到"),
    CODE_NOT_LOGIN("401", "未登录");
    /**
     * 异常状态码.正常情况下没有值
     */
    private String code;

    /**
     * 异常状态下地异常描述.正常情况下没有值
     */
    private String msg;

    StatusResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}