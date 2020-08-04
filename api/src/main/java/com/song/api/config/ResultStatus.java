package com.song.api.config;

import lombok.Getter;

/**
 * ResultStatus
 *
 * @author Chensong
 * @date 2018/10/10
 */
@Getter
public enum ResultStatus {
    /**
     * 状态码
     */
    SUCCESS(0, "操作成功"),
    ERROR_ARGS(1000, "参数错误"),
    ERROR_SERVICE(999, "业务异常"),
    TOKEN_CHECK(-2, "登录校验"),
    FAILURE(-1, "系统异常");

    private int status;
    private String message;

    ResultStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
