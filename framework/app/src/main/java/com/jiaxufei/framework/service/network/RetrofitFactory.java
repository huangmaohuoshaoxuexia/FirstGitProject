package com.jiaxufei.framework.service.network;

import com.jiaxufei.framework.api.OrderApi;
import com.jiaxufei.framework.service.config.HttpConfig;
import com.jiaxufei.framework.service.utils.InterceptorUtil;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午8:54<br/>
 * <p>
 * <p>
 * Retrofit 和 APIFunction关联
 * </p>
 */
public class RetrofitFactory {
    private static final int DEFAULT_TIMEOUT=10;
    private static RetrofitFactory retrofitFactory;
    private static OrderApi apiFunction;
    private HashMap<String,HttpClient> httpClientRepository;

    private RetrofitFactory() {
        httpClientRepository=new HashMap<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(okHttpClient)
                .build();
        apiFunction = retrofit.create(OrderApi.class);

    }
    public static RetrofitFactory getInstance() {
        if (retrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitFactory == null) {
                    retrofitFactory = new RetrofitFactory();
                }
            }
        }
        return retrofitFactory;
    }

    public HttpClient getNetworkClient(String host) {
        HttpClient client = null;
        if (httpClientRepository.containsKey(host)) {
            client = httpClientRepository.get(host);
        }
        if (client == null) {
            client = new HttpClient(host);
            httpClientRepository.put(host, client);
        }
        return client;
    }

    public OrderApi API() {
        return apiFunction;
    }

}
