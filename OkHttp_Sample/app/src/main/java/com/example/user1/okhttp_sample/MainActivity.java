package com.example.user1.okhttp_sample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textview);

        final GetExample example = new GetExample();
        final String[] response = {null};
        final Handler handler = new Handler();

        Thread thread = new Thread(){
            public void run(){
                try {

                    response[0] = example.run("https://openapi.devel.crazymike.tw/?func=prLogin&id=b1168&devicetoken=deviceToken!&deviceType=ios&user=47224017&&pwd=a47224017");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("test", response[0]);
                handler.post(new Runnable() {
                    public void run() {
                        text.setText(response[0]);
                    }
                });
            }
        };
        thread.start();

        }
    }

