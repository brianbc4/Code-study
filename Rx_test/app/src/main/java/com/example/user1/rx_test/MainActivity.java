package com.example.user1.rx_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//====================================Observer====================================
/*1*/
//        Observable<String> myObservable = Observable.create(
//                new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> sub) {
//                        sub.onNext("Hello, world!");
//                        sub.onCompleted();
//                    }
//                }
//        );

/*2*/
        Observable<String> myObservable =  Observable.just("Hello, world!");

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d("Rx",s);
            }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

        myObservable.subscribe(mySubscriber);


//        Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("Rx",s);
//            }
//        };

//        myObservable.subscribe(onNextAction);   // Outputs "Hello, world!"


//===================================================================================

/*3*/
//        Observable.just("Hello, world!")
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("Rx",s);
//                    }
//                });

/*lambda*/
//        Observable.just("lambdas")
//                .subscribe(s -> Log.d("Rx",s));

/*4*/
//        Observable.just("Hello, world!")
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return s + " -Hao";
//                    }
//                })
//                .subscribe(s -> Log.d("Rx",s));

/*lambda*/
//        Observable.just("Hello, world!")
//                .map(s -> s + " -Dan")
//                .subscribe(s -> Log.d("Rx",s));

    }
}
