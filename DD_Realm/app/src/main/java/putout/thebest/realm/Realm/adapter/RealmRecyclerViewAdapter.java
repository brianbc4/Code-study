package putout.thebest.realm.Realm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {


    public RealmRecyclerViewAdapter(Context context, RealmResults<T> realmResults,boolean automaticUpdate){
        setRealmAdapter(new RealmModelAdapter<T>(context,realmResults,automaticUpdate));
    }

    private RealmBaseAdapter<T> realmBaseAdapter;

    public T getItem(int position) {

        return realmBaseAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmAdapter() {

        return realmBaseAdapter;
    }

    public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {

        realmBaseAdapter = realmAdapter;
    }
}
