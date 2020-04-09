package com.dev.bond.util;

import com.dev.bond.result.ResultEnum;

public class ErrorException extends RuntimeException {
    private Integer code;

    public ErrorException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
