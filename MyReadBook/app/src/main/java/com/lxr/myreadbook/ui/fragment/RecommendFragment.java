package com.lxr.myreadbook.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxr.myreadbook.R;
import com.lxr.myreadbook.base.BaseRVFragment;
import com.lxr.myreadbook.model.bean.Recommend;
import com.lxr.myreadbook.ui.contract.RecommendContract;
import com.lxr.myreadbook.ui.easyadapter.RecommendAdapter;
import com.lxr.myreadbook.ui.presenter.RecommendPresenter;

import java.util.List;

/**
 * Created by Admin on 2017/3/1  13:12
 *
 * @desc
 */
public class RecommendFragment extends BaseRVFragment<RecommendPresenter,Recommend.RecommendBooks>
    implements RecommendContract.View{
    protected RecyclerArrayAdapter<T2> mAdapter;


    @Override
    protected void configViews() {
        initAdapter(RecommendAdapter.class, true, false);
    }

    protected void initAdapter(Class<? extends RecyclerArrayAdapter<T2>> clazz, boolean refreshable, boolean loadmoreable) {
        mAdapter = (RecyclerArrayAdapter<T2>) createInstance(clazz);
        initAdapter(refreshable, loadmoreable);
    }

    @Override
    public void showRecommendList(List list) {
        mAdapter.clear();
        mAdapter.addAll(list);
    }

    @Override
    public void showBookToc(String bookId, List list) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recommend;

    }
}
