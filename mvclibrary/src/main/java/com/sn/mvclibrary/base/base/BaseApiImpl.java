package com.sn.mvclibrary.base.base;

import android.content.Context;


public abstract class BaseApiImpl implements BaseApi {

    public String userID;

    public String userToken;
    public String userPhone;


    @Override
    public void onDestroy() {

    }
}
