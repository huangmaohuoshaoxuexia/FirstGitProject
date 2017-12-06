package com.jiaxufei.framework.user;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jiaxufei.framework.R;
import com.trello.rxlifecycle2.components.RxActivity;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-21 下午2:03<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public class UserLoginActivity extends RxActivity implements UserLoginContract.View {
    private UserLoginContract.Presenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new UserLoginPresenter(this, this));
        userLoginPresenter.login("jxs_liuxin110901", "123456", "0");

    }


    @Override
    public void setPresenter(UserLoginContract.Presenter presenter) {
        if (presenter != null) {
            userLoginPresenter = presenter;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showResult(UserModel userModel) {
        Toast.makeText(this, userModel.getCompanyAreaName(), Toast.LENGTH_SHORT).show();
        Log.e("JXF", userModel.getToken());

    }
}
