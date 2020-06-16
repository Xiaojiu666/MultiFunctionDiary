package com.sn.diary.mvp.base;


public abstract class BaseApiImpl implements BaseApi {

    public String userID;

    public String userToken;
    public String userPhone;


    @Override
    public void onDestroy() {

    }
}
