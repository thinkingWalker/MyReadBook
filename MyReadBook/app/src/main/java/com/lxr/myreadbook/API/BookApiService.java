package com.lxr.myreadbook.API;

import com.lxr.myreadbook.model.bean.Recommend;

import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Admin on 2017/3/1  15:34
 *
 * @desc
 */

public interface BookApiService {

    @GET("/book/recommend")
    Observable<Recommend> getRecomend(@Query("gender") String gender);
}
