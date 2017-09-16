package com.example.drcrunch.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        /*Picture*/
//        Glide.with(this).load("http://goo.gl/gEgYUd")
//                .error(R.mipmap.loading_img)//load失敗的Drawable
////                .placeholder(R.mipmap.loading_img)//loading時候的Drawable
////                .animate()//設置load完的動畫
////                .centerCrop()//中心切圖, 會填滿
////                .fitCenter()//中心fit, 以原本圖片的長寬為主
//                .into(imageView);

        /*GIF*/
        Glide.with(this)
                .load("https://media.giphy.com/media/l0MYDGA3Du1hBR4xG/giphy.gif")
                .asGif()
                .placeholder(R.mipmap.ic_launcher)
                .listener(new RequestListener<String, GifDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                        imageView.setImageResource(R.mipmap.fail);
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);

    }

}
