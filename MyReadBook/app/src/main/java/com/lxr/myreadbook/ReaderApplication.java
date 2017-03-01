package com.lxr.myreadbook;

import android.app.Application;

import com.lxr.myreadbook.utils.AppUtils;

/**
 * Created by Admin on 2017/3/1  15:46
 *
 * @desc
 */

public class ReaderApplication extends Application {
    private static ReaderApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        AppUtils.init(this);

    }

    public static ReaderApplication getsInstance() {
        return sInstance;
    }

}
