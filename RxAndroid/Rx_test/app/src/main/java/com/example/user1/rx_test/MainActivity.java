package com.example.user1.rx_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Subscriber<? super Integer> subscribeNumber;
    TextView rxIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxIcon = (TextView) findViewById(R.id.textView);

//====================================create====================================
/*Anonymous*/
        Observable<String> myCreateObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("myCreateObservable");
                        sub.onCompleted();
                    }
                }
        );

/*lambda*/
//        Observable<String> myCreateObservable =Observable.create(
//                subscriber -> {
//                    subscriber.onNext("myCreateObservable");
//                    subscriber.onCompleted();
//                }
//        );

//================================just========================================
/*Anonymous*/
    /*1*/
//        Observable.just("myJustObservable")
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d("Rx",s);
//                    }
//                });

    /*2*/
        Observable<String> myJustObservable =  Observable.just("myJustObservable");


/*lambda*/
//        Observable.just("myJustObservable->lambdas")
//                .subscribe(s -> Log.d("Rx",s));



//======================================Subscriber===================================
/*Anonymous*/
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d("Rx","mySubscriber: "+s);
            }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

//======================================Action===================================
/*Anonymous*/
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("Rx","onNextAction: "+s);
            }
        };

/*Lambda*/
//        Action1<String> onNextAction = s -> Log.d("Rx","onNextAction: "+s);

//======================================subscribe===================================

/*Anonymous*/
//        myCreateObservable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onNext(String s) {
//                Log.d("Rx","Anonymous: "+s);
//            }
//
//            @Override
//            public void onCompleted() { }
//
//            @Override
//            public void onError(Throwable e) { }
//        });


/*Lambda*/
//        myCreateObservable.subscribe(s ->{
//            Log.d("Rx", "Lambda:" +s );
//        });

        myCreateObservable.subscribe(mySubscriber);      //mySubscriber: myCreateObservable

        myJustObservable.subscribe(mySubscriber);      //mySubscriber: myJustObservable

        myJustObservable.subscribe(onNextAction);      //onNextAction: myJustObservable




//===================================map==============================================
//修改資料

//        Observable.just("Hello, world!")
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return s + " + map";
//                    }})
//                .subscribe(
//                        new Action1<String>() {
//                            @Override
//                            public void call(String s) {
//                             Log.d("Rx",s);
//                            }
//                        }
//                );


/*lambda*/
//        Observable.just("Hello, world!")
//                .map(s -> s + " -Dan")
//                .subscribe(s -> Log.d("Rx",s));

        /*
        Hello, world! -Dan
        */

//===================================filter=============================================
// 判斷,過濾資料

//        Observable.just("Hello")
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
////                        return (s.startsWith("H"));
//                        return(s.contains("Hello"));
//                    }
//                })
//                .subscribe(
//                        new Action1<String>() {
//                            @Override
//                            public void call(String s) {
//                                Log.d("Rx",s);
//                            }
//                        }
//                );

/*lambda*/
//        Observable.just("Hello")
//                .filter(s -> s.contains("Hello"))
//                .subscribe(s -> Log.d("Rx",s));


//=============================在更新後發佈最新狀態============================================

        rxIcon.setOnClickListener(view -> {
            subscribeNumber.onNext(7);     //更新給訂閱者的參數
        });

        Observable.create(
                (Observable.OnSubscribe<Integer>) subscriber -> {
                    subscribeNumber = subscriber;       //subscriber初始化,之後狀態有變化會通知observable
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(integer -> integer+6)   //傳進來的值先做處理
                .filter(integer -> integer.equals(13))   //判斷值的內容
                .subscribe(number -> {
                    rxIcon.setText("Complete!");
                    this.valueChange(number);
                }, Throwable::printStackTrace);

    }


    void valueChange(Integer number){
        Log.d("Rx","valueChange :"+number);
    }

}
