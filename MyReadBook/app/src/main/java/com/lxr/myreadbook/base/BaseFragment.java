package com.lxr.myreadbook.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/3/1  14:27
 *
 * @desc
 */

public abstract class BaseFragment extends Fragment {

    protected View parentView;
    protected FragmentActivity activity;
    protected Context mContext;
    protected LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        attachView();
        initDatas();
        configViews();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity= (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    protected abstract void configViews();

    protected abstract void initDatas();

    protected abstract void attachView();

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }
    protected abstract int getLayoutResId();
}
