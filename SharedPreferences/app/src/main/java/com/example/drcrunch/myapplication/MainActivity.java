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

public class MainActivity extends AppCompatActivity {

    private static SharedPreferences preference;
    private String today="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Date = String.valueOf(DateTime.now().toDateTime());

        preference = getSharedPreferences("Token", Context.MODE_PRIVATE);
        preference.edit().putString("Date", Date.split("T")[0]).apply();

        Log.d("Btest",today);

        if(!today.equals( preference.getString("Date","").toString())){
            today = preference.getString("Date","").toString();
            Log.d("Btest",today);
            new DailyNotification(this).show();
        }

    }
}
