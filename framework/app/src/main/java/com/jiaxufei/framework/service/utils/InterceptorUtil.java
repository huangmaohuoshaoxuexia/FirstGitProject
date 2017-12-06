package com.jiaxufei.framework.service.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午8:44<br/>
 * <p>
 * <p>
 * 拦截器工具类
 * </p>
 */
public class InterceptorUtil {
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//显示请求体和响应体
        return interceptor;
    }

    public static Interceptor HeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //在这里做想做的事情，比如：token失效时，重新获取token
                return chain.proceed(request);
            }
        };
    }
}
