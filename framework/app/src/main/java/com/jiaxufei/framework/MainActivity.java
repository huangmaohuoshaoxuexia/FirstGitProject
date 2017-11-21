package com.jiaxufei.framework;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jiaxufei.framework.api.NewsApi;
import com.jiaxufei.framework.newsDetail.NewsDetailActivity;
import com.jiaxufei.framework.newsDetail.NewsDetailModel;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.HttpConfig;
import com.jiaxufei.framework.service.network.BaseObserver;
import com.jiaxufei.framework.service.network.RetrofitFactory;
import com.jiaxufei.framework.service.utils.RetrofitUtil;
import com.jiaxufei.framework.user.UserLoginActivity;
import com.trello.rxlifecycle2.components.RxActivity;

public class MainActivity extends RxActivity implements View.OnClickListener {
    private Button btnGet;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //getData1();
    }

    private void initView() {
        btnGet = (Button) findViewById(R.id.btn_get);
        btnPost = (Button) findViewById(R.id.btn_post);
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
    }

    public void getData1() {
        RetrofitFactory.getInstance()
                .getNetworkClient(HttpConfig.BASE_URL)
                .createApi(NewsApi.class)
                .getNewsDetail("111")
                .compose(RetrofitUtil.<BaseResponseEntity<NewsDetailModel>>setThread(this))
                .subscribe(new BaseObserver<NewsDetailModel>() {
                    @Override
                    protected void onSuccess(BaseResponseEntity<NewsDetailModel> baseResponseEntity) throws Exception {
                        Log.i("JXF", baseResponseEntity.getData().getDescript());
                    }
                });
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btn_get:
                startActivity(new Intent(this, NewsDetailActivity.class));
                break;
            case R.id.btn_post:
                startActivity(new Intent(this, UserLoginActivity.class));
                break;
        }
    }
}
