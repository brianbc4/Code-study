package com.example.user1.ritrofit_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);
    CompositeSubscription mCompositeSubscription;
    TextView text;
    String cityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        cityId = "101190201";

//        addSubscription(
//                apiStores.loadDataByRetrofitRxjava(cityId),     //Observable
//                new Subscriber<MainModel>() {                   //Subscriber
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//                    @Override
//                    public void onNext(MainModel model) {
//                        dataSuccess(model);
//                    }
//                    @Override
//                    public void onCompleted() {
//                    }
//                });

        AppClient.test(text, cityId);

    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
                observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    private void dataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData =
                  "城市: " + weatherinfo.getCity()
                + "風向: " + weatherinfo.getWD()
                + "風級: " + weatherinfo.getWS()
                + "發布時間: " + weatherinfo.getTime();
        text.setText(showData);
    }
}
