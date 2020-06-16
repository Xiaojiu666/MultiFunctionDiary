package com.sn.diary.mvp.presenter;

import com.sn.diary.mvp.base.BasePresenter;
import com.sn.diary.mvp.base.BasePresenterImpl;
import com.sn.diary.mvp.base.RequestCallBack;
import com.sn.diary.mvp.modul.HomeModul;
import com.sn.diary.mvp.modul.bean.DiaryListBean;
import com.sn.diary.mvp.view.HomeView;

import java.util.List;

public class HomePresenter extends BasePresenterImpl<HomeView, HomeModul, List<DiaryListBean>> implements HomePresenterApi {
    public HomePresenter(HomeView rootView, HomeModul model) {
        super(rootView, model);
    }

    @Override
    public void getDiaryList() {
        mApi.getDiaryList(this);
    }

    @Override
    public void success(List<DiaryListBean> data) {
        mView.getData(data);
        super.success(data);
    }
}
