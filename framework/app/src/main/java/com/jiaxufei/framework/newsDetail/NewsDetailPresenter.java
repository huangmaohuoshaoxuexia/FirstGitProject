package com.jiaxufei.framework.newsDetail;

import android.util.Log;

import com.jiaxufei.framework.api.NewsApi;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.HttpConfig;
import com.jiaxufei.framework.service.network.BaseObserver;
import com.jiaxufei.framework.service.network.RetrofitFactory;
import com.jiaxufei.framework.service.utils.RetrofitUtil;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-18 下午9:41<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public class NewsDetailPresenter implements NewsDetailContract.Presenter {
    public NewsDetailContract.View newsDetailView;
    public NewsDetailActivity newsDetailActivity;

    public NewsDetailPresenter(NewsDetailContract.View view, NewsDetailActivity activity) {
        this.newsDetailView = view;
        this.newsDetailActivity = activity;
    }

    @Override
    public void getNewsDetail() {
        RetrofitFactory.getInstance()
                .getNetworkClient(HttpConfig.BASE_URL)
                .createApi(NewsApi.class)
                .getNewsDetail("111")
                .compose(RetrofitUtil.<BaseResponseEntity<NewsDetailModel>>setThread(newsDetailActivity))
                .subscribe(new BaseObserver<NewsDetailModel>(newsDetailActivity) {
                    @Override
                    protected void onSuccess(BaseResponseEntity<NewsDetailModel> baseResponseEntity) throws Exception {
                        newsDetailView.showNewsDetail(baseResponseEntity.getData());
                        Log.i("JXF", baseResponseEntity.getData().getDescript());
                    }
                });

    }

}
