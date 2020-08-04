package com.song.api.config;

import lombok.Data;

/**
 * Result
 *
 * @author Chensong
 * @date 2018/9/28
 */
@Data
public class Result<T> {

    public Result() {
    }

    public Result(ResultStatus resultStatus) {
        this(resultStatus, null);
    }

    public Result(ResultStatus resultStatus, T data) {
        this(resultStatus.getStatus(), resultStatus.getMessage(), data);
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private int status;
    private String message;
    private T data;
}
