package com.sn.diary.mvp.modul;

import com.sn.diary.mvp.base.RequestCallBack;
import com.sn.diary.mvp.modul.bean.DiaryListBean;

import java.util.List;

public interface HomeApi {
    void getDiaryList(final RequestCallBack<List<DiaryListBean>> requestCallBack);
}
