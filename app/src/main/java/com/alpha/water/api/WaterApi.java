package com.alpha.water.api;

import com.alpha.water.models.api.OrderInfo;
import com.alpha.water.models.api.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Pascal dev on 3/03/2017.
 */

public interface WaterApi {

    @FormUrlEncoded
    @POST("authenticate")
    Observable<User> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("orders")
    Observable<OrderInfo> getOrderInfo(@Header("email") String email, @Header("password") String password);


}
