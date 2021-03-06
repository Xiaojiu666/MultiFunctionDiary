package com.sn.diary.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sn.diary.mvp.modul.bean.DiaryListBean;
import com.sn.sndiary.R;

import java.util.List;

public class HomeDetialAdapter extends RecyclerView.Adapter<HomeDetialAdapter.MyHolder> {

    private List<DiaryListBean.DiaryBean> mList;//数据源
    private  Context mContext;
    public HomeDetialAdapter(Context context, List<DiaryListBean.DiaryBean> list) {
        mList = list;
        mContext=context;
    }

    //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_homedetial, parent, false);
        //将view传递给我们自定义的ViewHolder
        MyHolder holder = new MyHolder(view);
        //返回这个MyHolder实体
        return holder;
    }

    //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.textView.setText(mList.get(position).getMessage());
    }

    //获取数据源总的条数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 自定义的ViewHolder
     */
    class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView iv_detial;
        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_content);
            iv_detial = itemView.findViewById(R.id.iv_detial);
        }
    }
}
