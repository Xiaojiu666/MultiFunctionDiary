package com.sn.mvclibrary.base.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;


public abstract class BaseAppCompatActivity extends AppCompatActivity implements BaseView {


    public Context mContext;
    public boolean loginStatus;
    public Resources mResources;

    private ProgressDialog progDialog;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public abstract int getLayoutId();

    public abstract void initVariables();

    public abstract void initViews();

    public abstract void initOnClick();

    public abstract void initViewBefore();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getBaseContext();
        mResources = getResources();
        int layoutId = getLayoutId();
        initViewBefore();
        setContentView(layoutId);
        //定义变量或读取传递参数
        initVariables();
        //绑定到butterKnife
        ButterKnife.bind(this);
        initViews();
    }

    public SwipeRefreshLayout initSwipeRefersh(SwipeRefreshLayout mSwipeRefreshLayout) {
        this.mSwipeRefreshLayout = mSwipeRefreshLayout;
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light, android.R.color.holo_blue_light);
        return mSwipeRefreshLayout;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPreference();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void initPreference() {

    }

    //设置显示Back按钮
    public void initToobar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置透明导航栏
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void initTrasnStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//版本4.4
            Window window = getWindow(); // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //修改5.0以上状态栏半透明 貌似并没有什么卵用(机型锤子T2 5.0系统)(可能跟厂商定制有关) //
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initOnClick();
    }

    @Override
    public void showProgress() {
        if (progDialog == null) {
            progDialog = new ProgressDialog(this);
            progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDialog.setIndeterminate(false);
            progDialog.setCancelable(true);
            progDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showMsg(String message) {
//        KLog.e(message);
//        ToastUtils.showToast(mContext, message);
    }
}
