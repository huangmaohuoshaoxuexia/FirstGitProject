package com.jiaxufei.framework;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 下午1:47<br/>
 * <p>
 * <p>
 * 登录请求实体类
 * </p>
 */
public class LoginRequest {
    private String username;
    private String password;
    private String loginType;

    public LoginRequest(String username, String password, String loginType) {
        this.username = username;
        this.password = password;
        this.loginType = loginType;

    }
}
