package com.jiaxufei.framework.api;

import com.jiaxufei.framework.LoginRequest;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.URLConfig;
import com.jiaxufei.framework.user.UserModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 上午11:14<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public interface UserApi {
    @POST(URLConfig.login)
    Observable<BaseResponseEntity<UserModel>> login(@Body LoginRequest request);
}
