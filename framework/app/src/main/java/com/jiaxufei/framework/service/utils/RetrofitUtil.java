package com.jiaxufei.framework.service.utils;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-15 下午4:14<br/>
 * <p>
 * <p>
 * 网络处理工厂工具类
 * </p>
 */
public class RetrofitUtil {
    /**
     * 为Android系统的观察者添加线程处理逻辑，以保证UI线程不被网络调用阻塞。如果观察者受Andorid生命周期影响，再为观察者添加一个生命周期的处理方法，以保证内存不会泄露。
     *
     * @param provider LifecycleProvider参数，来自于RxJava
     * @param <T>      泛型
     * @return 添加了处理逻辑之后的观察者
     */
    public static <T> ObservableTransformer<T, T> setThread(final LifecycleProvider provider) {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                if (provider != null) {
                    observable.compose(provider.bindToLifecycle());
                }
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<T, T> setThread() {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
