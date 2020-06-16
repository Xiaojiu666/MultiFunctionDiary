package com.sn.diary.mvp.modul.bean;

import java.util.ArrayList;
import java.util.List;

public class DiaryListBean {
    long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ArrayList<DiaryBean> getDiaryList() {
        return DiaryList;
    }

    public void setDiaryList(ArrayList<DiaryBean> diaryList) {
        DiaryList = diaryList;
    }

    ArrayList<DiaryBean> DiaryList;

    public static class DiaryBean{
        String  message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<String> getMipmap() {
            return mipmap;
        }

        public void setMipmap(List<String> mipmap) {
            this.mipmap = mipmap;
        }

        List<String> mipmap;
    }
}
