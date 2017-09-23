package info.androidhive.retrofit.adapter.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import info.androidhive.retrofit.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    LinearLayout moviesLayout;
    public TextView movieTitle;
    public TextView data;
    public TextView movieDescription;
    public TextView rating;


    public MovieViewHolder(View v) {
        super(v);
        moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
        movieTitle = (TextView) v.findViewById(R.id.title);
        data = (TextView) v.findViewById(R.id.subtitle);
        movieDescription = (TextView) v.findViewById(R.id.description);
        rating = (TextView) v.findViewById(R.id.rating);
    }
}