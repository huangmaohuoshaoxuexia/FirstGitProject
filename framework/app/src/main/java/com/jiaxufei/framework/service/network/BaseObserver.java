package com.jiaxufei.framework.service.network;


import android.content.Context;
import android.util.Log;

import com.jiaxufei.framework.service.Exception.ApiException;
import com.jiaxufei.framework.service.Exception.ExceptionEngine;
import com.jiaxufei.framework.service.Exception.ServerException;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.HttpCode;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-13 下午9:41<br/>
 * <p>
 * <p>
 * 观察者的封装
 * </p>
 */
public abstract class BaseObserver<T> implements Observer<BaseResponseEntity<T>> {
    protected Context context;
    private Disposable disposable;

    public BaseObserver(Context ctx) {
        this.context = ctx;

    }

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        //解除订阅
        disposable = d;
    }

    @Override
    public void onNext(BaseResponseEntity<T> baseResponseEntity) {
        //发射数据
        if (baseResponseEntity != null) {
            int code = baseResponseEntity.getCode();
            if (code != HttpCode.SUCCESS) {
                onError(new ServerException(code, baseResponseEntity.getMsg()));
                return;
            }
            try {
                onSuccess(baseResponseEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            onError(new NullPointerException());
        }
    }


    @Override
    public void onError(Throwable throwable) {
        //通知
        ApiException exception= ExceptionEngine.handleException(throwable);
        Log.e("JXF",exception.getMsg());
    }

    @Override
    public void onComplete() {
        //通知

    }

    /**
     * 返回成功
     *
     * @param baseResponseEntity
     * @throws Exception
     */
    protected abstract void onSuccess(BaseResponseEntity<T> baseResponseEntity) throws Exception;

}
