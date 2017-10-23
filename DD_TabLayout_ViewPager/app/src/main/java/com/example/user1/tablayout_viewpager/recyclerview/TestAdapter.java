package com.example.user1.tablayout_viewpager.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user1.tablayout_viewpager.R;
import com.example.user1.tablayout_viewpager.ItemTouchHelper.ItemTouchRecyclerViewAdapter;
import com.example.user1.tablayout_viewpager.recyclerview.holder.Holder;

import java.util.List;

/**
 * Created by daffer on 2017/10/23.
 */

public class TestAdapter extends ItemTouchRecyclerViewAdapter<String> {


    public TestAdapter(Context context, List<String> items) {
        super(context, items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new Holder(inflater.inflate(R.layout.holder, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).text.setText("Position: "+position);
    }
}
