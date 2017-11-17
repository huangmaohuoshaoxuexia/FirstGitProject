package com.jiaxufei.framework;


import android.os.Bundle;
import android.util.Log;

import com.jiaxufei.framework.service.network.RetrofitFactory;
import com.jiaxufei.framework.service.utils.RetrofitUtil;
import com.jiaxufei.framework.service.network.BaseObserver;
import com.jiaxufei.framework.service.bean.NewsDetail;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.HttpConfig;
import com.jiaxufei.framework.service.config.URLConfig;
import com.trello.rxlifecycle2.components.RxActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData1();
    }

    public void getData1() {
        RetrofitFactory.getInstance()
                .getNetworkClient(HttpConfig.BASE_URL)
                .createApi(AppService.class)
                .getNewsDetail("111")
                .compose(RetrofitUtil.<BaseResponseEntity<NewsDetail>>setThread(this))
                .subscribe(new BaseObserver<NewsDetail>() {
                    @Override
                    protected void onSuccess(BaseResponseEntity<NewsDetail> baseResponseEntity) throws Exception {
                        Log.i("JXF", baseResponseEntity.getData().getDescript());
                    }
                });
    }
}
