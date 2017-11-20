package com.jiaxufei.framework.api;

import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.newsDetail.NewsDetail;
import com.jiaxufei.framework.service.config.URLConfig;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午8:53<br/>
 * <p>
 * <p>
 * 订单相关API接口
 * </p>
 */
public interface NewsApi {
    @GET(URLConfig.news_detail_url)
    Observable<BaseResponseEntity<NewsDetail>> getNewsDetail(@Query("id") String title);
    @GET("basil2style")
    Call<ResponseBody>getString();
}
