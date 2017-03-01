package com.lxr.myreadbook.ui.contract;

import com.lxr.myreadbook.base.BaseContract;

import java.util.List;

/**
 * Created by Admin on 2017/3/1  14:48
 *
 * @desc
 */

public interface RecommendContract  {

    interface View extends BaseContract.BaseView{

        void showRecommendList(List list);

        void showBookToc(String bookId,List list);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{

        void getRecommendList();
    }
}
