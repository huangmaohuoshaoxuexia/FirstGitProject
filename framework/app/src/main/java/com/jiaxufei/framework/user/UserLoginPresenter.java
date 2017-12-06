package com.jiaxufei.framework.user;

import com.jiaxufei.framework.LoginRequest;
import com.jiaxufei.framework.api.UserApi;
import com.jiaxufei.framework.newsDetail.NewsDetailActivity;
import com.jiaxufei.framework.newsDetail.NewsDetailContract;
import com.jiaxufei.framework.service.bean.BaseResponseEntity;
import com.jiaxufei.framework.service.config.HttpConfig;
import com.jiaxufei.framework.service.network.BaseObserver;
import com.jiaxufei.framework.service.network.RetrofitFactory;
import com.jiaxufei.framework.service.utils.LogUtils;
import com.jiaxufei.framework.service.utils.RetrofitUtil;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 下午2:01<br/>
 * <p>
 * <p>
 * 用户登录presenter
 * </p>
 */
public class UserLoginPresenter implements UserLoginContract.Presenter {
    public UserLoginContract.View userLoginView;
    public UserLoginActivity userLoginActivity;

    public UserLoginPresenter(UserLoginContract.View view, UserLoginActivity activity) {
        this.userLoginView = view;
        this.userLoginActivity = activity;
    }

    @Override
    public void login(String username, String password, String loginType) {
        LoginRequest loginRequest = new LoginRequest(username, password, loginType);
        RetrofitFactory.getInstance()
                .getNetworkClient(HttpConfig.BASE_URL)
                .createApi(UserApi.class)
                .login(loginRequest)
                .compose(RetrofitUtil.<BaseResponseEntity<UserModel>>setThread(userLoginActivity))
                .subscribe(new BaseObserver<UserModel>(userLoginActivity) {
                    @Override
                    protected void onSuccess(BaseResponseEntity<UserModel> baseResponseEntity) throws Exception {
                        userLoginView.showResult(baseResponseEntity.getModel());
                    }
                });
    }
}
