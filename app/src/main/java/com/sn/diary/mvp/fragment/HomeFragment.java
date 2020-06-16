package com.sn.diary.mvp.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sn.diary.adapter.HomeRecycleViewAdapter;
import com.sn.diary.mvp.base.BaseFragment;
import com.sn.diary.mvp.modul.HomeModul;
import com.sn.diary.mvp.modul.bean.DiaryListBean;
import com.sn.diary.mvp.presenter.HomePresenter;
import com.sn.diary.mvp.view.HomeView;
import com.sn.sndiary.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment implements HomeView {
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    Unbinder unbinder;
    private HomePresenter homePresenter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<DiaryListBean> diaryListBeanList;
    private HomeRecycleViewAdapter homeAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews(View mFragmentView) {
        diaryListBeanList=new ArrayList<>();
        homePresenter = new HomePresenter(this, new HomeModul(mContext));
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        homeAdapter=new HomeRecycleViewAdapter(getContext(),diaryListBeanList);
        rvMain.setLayoutManager(mLinearLayoutManager);
        rvMain.setAdapter(homeAdapter);
    }

    @Override
    protected void initData() {
        homePresenter.getDiaryList();
    }

    @Override
    protected void onRefersh() {

    }

    @Override
    public void getData(List<DiaryListBean> diaryListBean) {
        diaryListBeanList.clear();
        diaryListBeanList.addAll(diaryListBean);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
