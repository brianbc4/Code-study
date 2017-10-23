package putout.thebest.realm.Retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daffer on 2017/10/22.
 */

public class SimpleRetrofit {

    private static SimpleRetrofit instance;

    public static SimpleRetrofit getInstance(){
        if(instance == null) instance = new SimpleRetrofit();
        return instance;
    }

    public Retrofit build(String baseUrl){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(baseUrl)
                        .client(okHttpClient)
                        .build();

        return retrofit;
    }



}
