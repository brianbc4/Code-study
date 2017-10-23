package com.example.user1.tablayout_viewpager.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user1.tablayout_viewpager.R;
import com.example.user1.tablayout_viewpager.recyclerview.holder.Holder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by daffer on 2017/10/21.
 */

public  class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private final Context context;

    private List<String> items = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<String> items) {
        this.context = context;
        this.items.addAll(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                return new Holder(inflater.inflate(R.layout.holder, null));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ((Holder)holder).text.setText("Position: "+position);
        }

    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(items,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }
}

