package com.jiaxufei.framework.newsDetail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jiaxufei.framework.R;
import com.trello.rxlifecycle2.components.RxActivity;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-18 下午9:46<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public class NewsDetailActivity extends RxActivity implements NewsDetailContract.View {
    private NewsDetailContract.Presenter newsDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new NewsDetailPresenter(this, this));
        newsDetailPresenter.getNewsDetail();
    }

    @Override
    public void setPresenter(NewsDetailContract.Presenter presenter) {
        if (presenter != null) {
            newsDetailPresenter = presenter;
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
    public void showNewsDetail(NewsDetailModel newsDetail) {
        Toast.makeText(this, newsDetail.getAuthor(), Toast.LENGTH_SHORT).show();
        Log.e("JXF", newsDetail.getAuthor());
    }
}