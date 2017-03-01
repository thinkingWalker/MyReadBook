package com.lxr.myreadbook.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.lxr.myreadbook.R;
import com.lxr.myreadbook.utils.StatusBarCompat;

import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/3/1  12:50
 *
 * @desc
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    protected Toolbar mCommonToolbar;
    private Context mContext;
    private View toolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        if (statusBarColor == 0) {
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimary));

        } else if (statusBarColor != -1) {
            statusBarView = StatusBarCompat.compat(this, statusBarColor);
        }
        transparent19and20();

        mContext = this;
        ButterKnife.bind(this);
        mCommonToolbar = ButterKnife.findById(this, R.id.common_toolbar);
        if (mCommonToolbar != null) {
            initToolBar();
            setSupportActionBar(mCommonToolbar);
        }
        initDatas();
        configViews();
    }

    protected abstract void configViews();

    protected abstract void initDatas();

    protected abstract void initToolBar();


    protected void transparent19and20() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected abstract int getLayoutId();
}
