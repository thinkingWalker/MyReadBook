package com.lxr.myreadbook.ui.presenter;

import android.content.Context;

import com.lxr.myreadbook.API.BookApi;
import com.lxr.myreadbook.manager.SettingManager;
import com.lxr.myreadbook.model.bean.Recommend;
import com.lxr.myreadbook.ui.contract.RecommendContract;
import com.lxr.myreadbook.utils.RxUtil;
import com.lxr.myreadbook.utils.StringUtils;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Admin on 2017/3/1  14:40
 *
 * @desc
 */

public class RecommendPresenter extends RxPresenter<RecommendContract.View> implements RecommendContract.Presenter<RecommendContract.View> {

    private Context mContext;
    private BookApi bookApi;

    public RecommendPresenter(Context mContext, BookApi bookApi) {
        this.mContext = mContext;
        this.bookApi = bookApi;
    }

    @Override
    public void getRecommendList() {
        String key = StringUtils.creatAcacheKey("recommend-list", SettingManager.getInstance().getUserChooseSex());
        Observable<Recommend> fromNetWork = bookApi.getRecommend
                (SettingManager.getInstance().getUserChooseSex()).compose(RxUtil.<Recommend>rxCacheListHelper(key));
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, Recommend.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recommend>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(Recommend recommend) {
                        if (recommend != null) {
                            List<Recommend.RecommendBooks> list = recommend.books;
                            if (list != null && !list.isEmpty() && mView != null) {
                                mView.showRecommendList(list);
                            }
                        }
                    }


                });
        addSubscribe(rxSubscription);

    }
}
