package com.sn.diary.mvp.modul;

import android.content.Context;

import com.sn.diary.mvp.base.BaseApiImpl;
import com.sn.diary.mvp.base.RequestCallBack;
import com.sn.diary.mvp.modul.bean.DiaryListBean;

import java.util.ArrayList;
import java.util.List;

public class HomeModul  extends BaseApiImpl implements HomeApi{

    private Context mContext;

    public HomeModul(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public void getDiaryList(final RequestCallBack<List<DiaryListBean>> requestCallBack) {
        List<DiaryListBean> list=new ArrayList<>();
        ArrayList<DiaryListBean.DiaryBean> diaryListBeans=new ArrayList<>();
        DiaryListBean diaryListBean=new DiaryListBean();
        DiaryListBean.DiaryBean diaryBean=new DiaryListBean.DiaryBean();
        diaryListBean.setTime(20200616);
        diaryBean.setMessage("hahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahha" +
                "hahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahha" +
                "hahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahha" +
                "hahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahha" +
                "hahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahhahahahahahha");
        diaryListBeans.add(diaryBean);
        diaryListBeans.add(diaryBean);
        diaryListBeans.add(diaryBean);
        diaryListBeans.add(diaryBean);
        diaryListBeans.add(diaryBean);
        diaryListBean.setDiaryList(diaryListBeans);
        list.add(diaryListBean);
        ArrayList<DiaryListBean.DiaryBean> diaryListBeans2=new ArrayList<>();
        DiaryListBean diaryListBean2=new DiaryListBean();
        DiaryListBean.DiaryBean diaryBean2=new DiaryListBean.DiaryBean();
        diaryListBean2.setTime(20200615);
        diaryBean2.setMessage("噗噗噗噗噗噗噗" +
                "噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗" +
                "噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗" +
                "噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗噗");
        diaryListBeans2.add(diaryBean2);
        diaryListBeans2.add(diaryBean2);
        diaryListBean2.setDiaryList(diaryListBeans2);
        list.add(diaryListBean2);

        ArrayList<DiaryListBean.DiaryBean> diaryListBeans3=new ArrayList<>();
        DiaryListBean diaryListBean3=new DiaryListBean();
        DiaryListBean.DiaryBean diaryBean3=new DiaryListBean.DiaryBean();
        diaryListBean3.setTime(20200610);
        diaryBean3.setMessage("啦啦啦啦阿拉蕾啦啦啦啦啦啦啦啦拉拉阿拉啦啦啦啦啦啦");
        diaryListBeans3.add(diaryBean3);
        diaryListBeans3.add(diaryBean3);
        diaryListBeans3.add(diaryBean3);
        diaryListBean3.setDiaryList(diaryListBeans3);
        list.add(diaryListBean3);
            requestCallBack.success(list);
    }
}
