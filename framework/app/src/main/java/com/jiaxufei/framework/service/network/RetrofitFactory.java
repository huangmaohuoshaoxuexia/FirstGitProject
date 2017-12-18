package com.jiaxufei.framework.service.network;

import com.jiaxufei.framework.api.NewsApi;

import java.util.HashMap;

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
    private static RetrofitFactory retrofitFactory;
    private HashMap<String, HttpClient> httpClientRepository;

    private RetrofitFactory() {
        httpClientRepository = new HashMap<>();
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


}
