package com.jiaxufei.framework.user;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 上午11:28<br/>
 * <p>
 * <p>
 * 用户实体类
 * </p>
 */
public class UserModel {

    /**
     * success : 0
     * respMsg : 成功
     * sessionId : B34B4961C1CB0A5264D299266AB954C3
     * token : 2f301b71eb894725aef0760b3471b6ad
     * userId : c674e1587e6e4afa8095b60970cad8cc
     * authorition : ["PRIVILEGE_ADMIN_V2","PRIVILEGE_STAFF_V2"]
     * userAccount : jxs_liuxin110901
     * salesManName : 管理员
     * position :
     * companyAreaName : 丹露-研发中心-测试区
     * companyName : 刘欣测试经销商2017110901
     * companyId : 9a7e5ac6398e4c8bbef81769bfee37f6
     * email : null
     * tel : 15920043987
     * telStatus : 1
     * handPassword : 4ebe7c58bc215459085a6bb82be271c0
     */

    private String success;
    private String respMsg;
    private String sessionId;
    private String token;
    private String userId;
    private String userAccount;
    private String companyAreaName;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getCompanyAreaName() {
        return companyAreaName;
    }

    public void setCompanyAreaName(String companyAreaName) {
        this.companyAreaName = companyAreaName;

    }
}
