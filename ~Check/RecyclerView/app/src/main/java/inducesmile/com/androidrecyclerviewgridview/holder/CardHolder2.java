package inducesmile.com.androidrecyclerviewgridview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import inducesmile.com.androidrecyclerviewgridview.R;

/**
 * Created by daffer on 2017/9/22.
 */

public class CardHolder2 extends RecyclerView.ViewHolder{
    public TextView badge;
    public TextView countryName;
    public ImageView countryPhoto;

    public CardHolder2(View itemView) {
        super(itemView);
        badge = (TextView) itemView.findViewById(R.id.badge);
        countryName = (TextView)itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

    }
}
