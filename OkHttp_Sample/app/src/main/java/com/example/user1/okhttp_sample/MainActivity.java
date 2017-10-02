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

        final GetExample get = new GetExample();
        final String[] response = {null};
        final Handler handler = new Handler();

        Thread thread = new Thread(){
            public void run(){
                try {

                    response[0] = get.run("http://appapi2.crazymike.tw/index.php/getVersion?callfrom=app");

                } catch (IOException e) {
                    e.printStackTrace();
                }

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

