package com.jiaxufei.framework.service.bean;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午9:27<br/>
 * <p>
 * <p>
 * 解析实体集类
 * </p>
 */
public class BaseResponseEntity<T> {

    private static int SUCCESS_CODE=42440;//成功的code
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess(){
        return getCode()==SUCCESS_CODE;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
