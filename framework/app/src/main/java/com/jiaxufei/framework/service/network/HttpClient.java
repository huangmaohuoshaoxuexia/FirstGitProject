package com.jiaxufei.framework.service.network;

import com.jiaxufei.framework.service.Exception.MissRetrofitException;
import com.jiaxufei.framework.service.utils.InterceptorUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-17 下午5:22<br/>
 * <p>
 * <p>
 * 自定义OkHttpClient 网络请求处理器
 * </p>
 */
public class HttpClient {
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;

    HttpClient(String host) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(createOkHttpsClient());
        this.retrofit = retrofitBuilder.build();
    }

    /**
     * 创建网络请求
     *
     * @param service 网络请求
     * @param <T>     网络请求泛型
     * @return 网络请求类
     */
    public <T> T createApi(Class<T> service) {
        if (retrofit == null) {
            throw new MissRetrofitException();
        }
        return retrofit.create(service);
    }

    private OkHttpClient createOkHttpsClient() {
        OkHttpClient.Builder clientBuilder = getDefaultOkHttpClientBuilder();
        return clientBuilder.build();
    }

    private OkHttpClient.Builder getDefaultOkHttpClientBuilder() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor());//添加日志拦截器
        return clientBuilder;
    }
}
