package com.jiaxufei.framework.service.bean;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午9:27<br/>
 * <p>
 * <p>
 * 解析实体集类,和后台约定好的公共返回参数，随项目修改
 * </p>
 */
public class BaseResponseEntity<T> {

    private int code;
    private String msg;
    private T data;
    private T model;
    private String description;

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

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
