package com.jiaxufei.framework.user;

import com.jiaxufei.framework.base.BasePresenter;
import com.jiaxufei.framework.base.IBaseView;


/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 下午1:56<br/>
 * <p>
 * <p>
 * 契约类来统一管理view与presenter的所有的接口
 * </p>
 */
public interface UserLoginContract {
    interface Presenter extends BasePresenter{
        void login(String username, String password, String loginType);
    }
    interface View extends IBaseView<Presenter> {
        //显示结果
        void showResult(UserModel userModel);
    }
}
