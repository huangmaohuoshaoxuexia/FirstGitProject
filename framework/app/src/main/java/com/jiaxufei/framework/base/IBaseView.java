package com.jiaxufei.framework.base;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-18 下午9:29<br/>
 * <p>
 * <p>
 * 视图层的基类
 * </p>
 */
public interface IBaseView<T> {
    //方法作用是在将presenter实例传入view中，其调用时机是presenter实现类的构造函数中
    void setPresenter(T presenter);
    //显示loading
    void showLoading();

    //关闭loading
    void closeLoading();

    //显示吐司
    void showToast(String msg);
}
