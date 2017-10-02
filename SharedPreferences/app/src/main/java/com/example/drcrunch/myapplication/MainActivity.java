package com.example.drcrunch.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;

/*將資料儲存起來  */


public class MainActivity extends AppCompatActivity {

    private static SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preference = getSharedPreferences("Token", Context.MODE_PRIVATE);


        String Date = String.valueOf(DateTime.now().toDateTime());               //2017-09-11T11:57:56.987Z
//        String Date = String.valueOf(DateTime.now().toDateTime()).split("T")[0]; //2017-09-11

        Log.d("Btest",Date);

        if(!preference.getString("Date", "").equals(Date)){    //假如存取的日期不是今天...
            preference.edit().putString("Date", Date).apply();   //存取日期
            new DailyNotification(this).show();                //跳出訊息窗
        }

    }
}
