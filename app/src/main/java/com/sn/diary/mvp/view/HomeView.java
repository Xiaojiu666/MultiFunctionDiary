package com.sn.diary.mvp.view;

import com.sn.diary.mvp.base.BaseView;
import com.sn.diary.mvp.modul.bean.DiaryListBean;

import java.util.List;

public interface HomeView extends BaseView {

    void getData(List<DiaryListBean> diaryListBean);
}
