package co.paulburke.android.itemtouchhelperdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.paulburke.android.itemtouchhelperdemo.R;

/**
 * Created by daffer on 2017/10/13.
 */

public class CardViewHolder  extends RecyclerView.ViewHolder {

    public final TextView textView;

    public CardViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
    }

}
