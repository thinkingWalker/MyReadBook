package com.lxr.myreadbook.ui.activity;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import com.lxr.myreadbook.R;
import com.lxr.myreadbook.base.BaseActivity;
import com.lxr.myreadbook.ui.fragment.CommunityFragment;
import com.lxr.myreadbook.ui.fragment.FindFragment;
import com.lxr.myreadbook.ui.fragment.RecommendFragment;
import com.lxr.myreadbook.widget.GenderPopupWindow;
import com.lxr.myreadbook.widget.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.indicator)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    private List<String> mDatas;
    private ArrayList<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private GenderPopupWindow genderPopupWindow;



    @Override
    protected void configViews() {
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mIndicator.setViewPager(mViewPager, 0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showChooseSexPopupWindow();
            }
        }, 500);
    }

    private void showChooseSexPopupWindow() {
        if (genderPopupWindow == null) {
            genderPopupWindow = new GenderPopupWindow(MainActivity.this);
        }
        if (!genderPopupWindow.isShowing()){
            genderPopupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER,0,0);
        }
    }

    @Override
    protected void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        mTabContents = new ArrayList<>();

        mTabContents.add(new RecommendFragment());
        mTabContents.add(new CommunityFragment());
        mTabContents.add(new FindFragment());
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };

    }

    @Override
    protected void initToolBar() {
        mCommonToolbar.setLogo(R.mipmap.logo);
        setTitle("");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
