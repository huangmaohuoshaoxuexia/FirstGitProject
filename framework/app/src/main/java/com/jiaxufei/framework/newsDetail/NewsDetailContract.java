package com.jiaxufei.framework.newsDetail;

import com.jiaxufei.framework.base.BasePresenter;
import com.jiaxufei.framework.base.IBaseView;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-18 下午9:36<br/>
 * <p>
 * <p>
 * 契约类来统一管理view与presenter的所有的接口，这种方式使得view与presenter中有哪些功能，一目了然，维护起来也方便
 * </p>
 */
public interface NewsDetailContract {
    interface Presenter extends BasePresenter {
        void getNewsDetail();
    }

    interface View extends IBaseView<Presenter> {
        //显示结果
        void showNewsDetail(NewsDetail newsDetail);
    }
}