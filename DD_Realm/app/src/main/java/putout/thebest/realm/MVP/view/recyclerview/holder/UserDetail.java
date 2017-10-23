package putout.thebest.realm.MVP.view.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import putout.thebest.realm.R;

/**
 * Created by daffer on 2017/10/18.
 */

public class UserDetail extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView age;

    public UserDetail(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        age = itemView.findViewById(R.id.age);
    }
}
