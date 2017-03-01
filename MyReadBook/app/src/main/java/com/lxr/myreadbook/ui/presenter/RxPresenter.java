package com.lxr.myreadbook.ui.presenter;

import com.lxr.myreadbook.base.BaseContract;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Admin on 2017/3/1  14:42
 *
 * @desc
 */

public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T>{
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    protected void unSubscribe(){
        if (mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription){
        if (mCompositeSubscription==null){
            mCompositeSubscription=new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void detachView() {
        this.mView=null;
        unSubscribe();
    }
}
