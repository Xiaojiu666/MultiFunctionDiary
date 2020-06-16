package com.sn.diary.mvp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements BaseView {
    protected View mFragmentView;
    private final static String TAG = "BaseFragment";
    public Resources resources;
    public Context mContext;
    private ProgressDialog progDialog;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public void showProgress() {
        if (progDialog == null) {
            progDialog = new ProgressDialog(getActivity());
            progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDialog.setIndeterminate(false);
            progDialog.setCancelable(true);
            progDialog.show();
        }
    }

    public SwipeRefreshLayout initSwipeRefersh(SwipeRefreshLayout mSwipeRefreshLayout) {
        this.mSwipeRefreshLayout = mSwipeRefreshLayout;
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light, android.R.color.holo_blue_light);
        return mSwipeRefreshLayout;
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

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        resources = getResources();
        mContext = getActivity();
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return mFragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        onRefersh();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    public abstract int getLayoutId();

    public abstract void initViews(View mFragmentView);

    protected abstract void initData();

    protected abstract void onRefersh();

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mFragmentView = null;
    }

}
