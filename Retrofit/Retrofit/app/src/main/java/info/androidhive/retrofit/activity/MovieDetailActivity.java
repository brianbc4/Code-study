package info.androidhive.retrofit.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.model.Movie;
import info.androidhive.retrofit.rest.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private static String ID="ID";

    TextView detail;

    public static void startActivity(Context context, int id){
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(ID,id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        detail = (TextView) findViewById(R.id.detail);

        ApiClient.getApiService().getMovieDetails(getIntent().getIntExtra(ID,0),MainActivity.API_KEY)
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        detail.setText(response.body().getOverview());
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                    }
                });


    }
}
