package com.lxr.myreadbook.base;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lxr.myreadbook.R;
import com.lxr.myreadbook.widget.recylerview.EasyRecyclerView;
import com.lxr.myreadbook.widget.recylerview.adapter.OnLoadMoreListener;
import com.lxr.myreadbook.widget.recylerview.adapter.RecyclerArrayAdapter;
import com.lxr.myreadbook.widget.recylerview.swipe.OnRefreshListener;

/**
 * Created by Admin on 2017/3/1  14:31
 *
 * @desc
 */

public class BaseRVFragment <T1 extends BaseContract.BasePresenter, T2> extends BaseFragment
        implements RecyclerArrayAdapter.OnItemClickListener, OnLoadMoreListener, OnRefreshListener, SwipeRefreshLayout.OnRefreshListener {

    protected  T1 mPresenter;
    protected EasyRecyclerView mRecyclerView;


    protected RecyclerArrayAdapter<T2> mAdapter;
    @Override
    protected void configViews() {

    }

    @Override
    protected void initDatas() {

    }

    protected void initAdapter(boolean refreshable, boolean loadmoreable){
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
            mRecyclerView.setItemDecoration(ContextCompat.getColor(activity, R.color.common_divider_narrow), 1, 0, 0);
            mRecyclerView.setAdapterWithProgress(mAdapter);
        }

        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(this);
            mAdapter.setError(R.layout.common_error_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.resumeMore();

                }
            });
            if (loadmoreable) {
                mAdapter.setMore(R.layout.common_more_view, this);
                mAdapter.setNoMore(R.layout.common_nomore_view);
            }
            if (refreshable && mRecyclerView != null) {
                mRecyclerView.setRefreshListener(this);
            }
        }

    }
    @Override
    protected void attachView() {
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    @Override
    public void onLoadMore() {
    }


    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onRefresh() {

    }
}
