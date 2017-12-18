package com.jiaxufei.framework.pay;

import android.os.Bundle;
import android.widget.TextView;

import com.jiaxufei.framework.R;
import com.jiaxufei.framework.user.UserLoginContract;
import com.jiaxufei.framework.user.UserLoginPresenter;
import com.trello.rxlifecycle2.components.RxActivity;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-12-06 下午4:44<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public class UserLoginActivity extends RxActivity {
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        tvShow = (TextView) findViewById(R.id.tv_show);
        String title = getIntent().getStringExtra("title");
        tvShow.setBackgroundResource(R.color.color_red);
        tvShow.setText(title+"11111");
    }
}
