package com.jiaxufei.framework.service.Exception;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-15 下午1:04<br/>
 * <p>
 * <p>
 * 自定义异常类
 * </p>
 */
public class ResponseErrorCodeException extends RuntimeException {
    private int code;
    private String msg;

    public ResponseErrorCodeException(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
