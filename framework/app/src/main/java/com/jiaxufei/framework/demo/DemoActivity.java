package com.jiaxufei.framework.demo;


import android.os.Bundle;
import android.util.Log;

import com.jiaxufei.framework.R;
import com.jiaxufei.framework.api.NewsApi;

import com.jiaxufei.framework.service.config.URLConfig;
import com.trello.rxlifecycle2.components.RxActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class DemoActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConfig.URL_BASE)
                .build();
        NewsApi apiFunction = retrofit.create(NewsApi.class);
        Call<ResponseBody> call = apiFunction.getString();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.i("JXF", response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("JXF", "访问失败");
            }
        });
    }
}
