package com.example.user1.tablayout_viewpager.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user1.tablayout_viewpager.R;

/**
 * Created by daffer on 2017/10/21.
 */

public class Holder extends RecyclerView.ViewHolder {

    public TextView text;

    public Holder(View itemView) {
        super(itemView);

        text = (TextView) itemView.findViewById(R.id.text);
    }
}
