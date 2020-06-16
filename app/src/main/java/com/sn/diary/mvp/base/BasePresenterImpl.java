package com.sn.diary.mvp.base;


/**
 */
public class BasePresenterImpl<V extends BaseView, M extends BaseApi, T> implements BasePresenter, RequestCallBack<T> {

    protected V mView;
    protected M mApi;


    public BasePresenterImpl(V rootView, M model) {
        mView = rootView;
        mApi = model;
    }

    @Override
    public void onCreate() {
        //mApi.initToken();
    }

    @Override
    public void onDestroy() {
        if (mApi != null) {
            mApi.onDestroy();
            this.mApi = null;
        }
        this.mView = null;
    }


    @Override
    public void beforeRequest() {
        if (mView != null) {
            mView.showProgress();
        }
    }

    @Override
    public void success(T data) {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void onError(String errorMsg) {
        if (mView != null) {
            mView.hideProgress();
            mView.showMsg(errorMsg);
        }
    }

    @Override
    public void onError(int errorCode) {

    }

}
