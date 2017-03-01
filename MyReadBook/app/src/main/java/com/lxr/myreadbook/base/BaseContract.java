package com.lxr.myreadbook.base;

/**
 * Created by Admin on 2017/3/1  14:32
 *
 * @desc
 */

public interface BaseContract {

    interface BaseView{
        void showError();
        void complete();
    }

    interface BasePresenter<T>{
        void attachView(T view);
        void detachView();
    }

}
