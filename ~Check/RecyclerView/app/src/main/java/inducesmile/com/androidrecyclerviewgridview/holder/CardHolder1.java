package inducesmile.com.androidrecyclerviewgridview.holder;

/**
 * Created by daffer on 2017/9/20.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import inducesmile.com.androidrecyclerviewgridview.R;


public class CardHolder1 extends RecyclerView.ViewHolder
{

    public TextView countryName;
    public ImageView countryPhoto;

    public CardHolder1(View itemView) {
        super(itemView);
        countryName = (TextView)itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

    }

}