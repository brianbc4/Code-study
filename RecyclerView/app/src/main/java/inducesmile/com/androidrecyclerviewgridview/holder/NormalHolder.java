package inducesmile.com.androidrecyclerviewgridview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import inducesmile.com.androidrecyclerviewgridview.R;

/**
 * Created by daffer on 2017/10/10.
 */

public class NormalHolder extends RecyclerView.ViewHolder {

    public TextView countryName;
    public ImageView countryPhoto;


    public NormalHolder(View itemView) {
        super(itemView);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
        countryName = (TextView) itemView.findViewById(R.id.country_name);


    }
}
