package com.example.drcrunch.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        /*Picture*/
        Glide.with(this).load("http://goo.gl/gEgYUd")
                .error(R.mipmap.loading_img)//load失敗的Drawable
//                .placeholder(R.mipmap.loading_img)//loading時候的Drawable
//                .animate()//設置load完的動畫
//                .centerCrop()//中心切圖, 會填滿
//                .fitCenter()//中心fit, 以原本圖片的長寬為主
                .into(imageView);

        /*GIF*/
//        Glide.with(this).load("http://dv.azureedge.net/Content/ueditor/net/upload1//6361688293219650163426247.gif")
//                .asGif()
//                .placeholder(R.mipmap.loading_img)
//                .into(imageView);

    }
}
