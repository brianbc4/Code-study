package info.androidhive.retrofit.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import info.androidhive.retrofit.activity.MovieDetailActivity;
import info.androidhive.retrofit.adapter.holder.MovieViewHolder;
import info.androidhive.retrofit.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Activity activity;

    public MoviesAdapter(List<Movie> movies, int rowLayout, Activity activity) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        holder.moviesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetailActivity.startActivity(activity,movies.get(position).getId());
//                Log.v("B_ID",movies.get(position).getId()+"");
            }
        });



    }


}