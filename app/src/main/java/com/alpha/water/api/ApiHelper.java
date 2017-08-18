package com.alpha.water.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alpha.water.BuildConfig;
import com.alpha.water.models.api.OrderInfo;
import com.alpha.water.models.api.User;
import com.alpha.water.utils.PreferenceHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Pascal dev on 3/03/2017.
 */

public class ApiHelper {
    private static  WaterApi service;

    public static WaterApi getService() {

        if (service == null) {
            Interceptor logInterceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();

            service = retrofit.create(WaterApi.class);
        }

        return service;

    }

    public static Observable<User> logIn(Context context, String email, String password) {
        return ApiHelper.getService().login(email,password)
                .flatMap(user ->
                {
                    if (user != null) {
                        return Observable.just(user);
                    } else {
                        String error = "something went wrong";
                        return Observable.error(new IOException(error));
                    }
                })
                .doOnNext(user ->
                {
                    Log.d("FirstName",user.getFirstName());
                    PreferenceHelper.saveAndroidKey(context,user.getAndroidKey());
                    PreferenceHelper.saveUserMail(context,user.getEmail());

                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable<OrderInfo> getOrders(Context context, String email, String password) {
        return ApiHelper.getService().getOrderInfo(email,password)
                .flatMap(orderInfo ->
                {
                    if (orderInfo != null) {
                        return Observable.just(orderInfo);
                    } else {
                        String error = "something went wrong";
                        return Observable.error(new IOException(error));
                    }
                })
                .doOnNext(orderInfo ->
                {
                    Log.d("customer email",orderInfo.getCustomer().getEmail());


                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}









































/*
by Pa
 */
