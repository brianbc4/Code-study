package putout.thebest.realm.MVP.view.recyclerview.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.realm.RealmResults;
import putout.thebest.realm.MVP.model.Person;
import putout.thebest.realm.MVP.view.recyclerview.holder.UserDetail;
import putout.thebest.realm.R;
import putout.thebest.realm.Realm.adapter.RealmRecyclerViewAdapter;

/**
 * Created by daffer on 2017/10/18.
 */

public class RealmUserAdapter extends RealmRecyclerViewAdapter<Person>{

    Activity activity;
    RealmResults<Person> realmResults;

    public RealmUserAdapter(Context context, RealmResults<Person> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
        this.realmResults = realmResults;
        activity = (Activity) context;
    }

    @Override
    public int getItemCount() {
        return getRealmAdapter().getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return new UserDetail(inflater.inflate(R.layout.holder_userdetail,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((UserDetail)holder).name.setText(realmResults.get(position).getName());
        ((UserDetail)holder).age.setText(realmResults.get(position).getAge()+"");

    }


}
