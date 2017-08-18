package com.example.drcrunch.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dr.Crunch on 2017/3/16.
 */

public class DailyNotification extends AlertDialog implements View.OnClickListener{

    private Context mContext;
    private View view;
    Button conferm;
    protected DailyNotification(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView(){
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_daily_notice, null);
        conferm = (Button) view.findViewById(R.id.get_it);
        setView(view);
        conferm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
    dismiss();
    }
}
