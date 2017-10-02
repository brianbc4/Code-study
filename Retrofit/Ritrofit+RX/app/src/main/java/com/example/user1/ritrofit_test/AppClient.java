package com.example.user1.ritrofit_test;

import android.view.View;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by user1 on 2017/1/5.
 */

public class AppClient {

    public static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            if (BuildConfig.DEBUG) {
                //Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            OkHttpClient okHttpClient = builder.build();
            mRetrofit =
                    new Retrofit.Builder()
                    .baseUrl(ApiStores.API_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }


    public static void test(final View view, String id){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(ApiStores.API_SERVER_URL)
                        .client(okHttpClient)
                        .build();

        ApiStores apiStores = retrofit.create(ApiStores.class);


        apiStores.loadDataByRetrofitRxjava(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MainModel>() {
                    @Override
                    public void call(MainModel mainModel) {

                        MainModel.WeatherinfoBean weatherinfo = mainModel.getWeatherinfo();

                        String showData =
                                "城市: " + weatherinfo.getCity()
                                        + "風向: " + weatherinfo.getWD()
                                        + "風級: " + weatherinfo.getWS()
                                        + "發布時間: " + weatherinfo.getTime();

                        ((TextView)view).setText(showData);
                    }
                });
    }


}

