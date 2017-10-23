package putout.thebest.realm.Realm;

/**
 * Created by daffer on 2017/10/7.
 */

import android.content.Context;

import io.realm.Realm;


public class RealmController
{

    private static RealmController instance;
    private final Realm realm;
    public final Context context;

    private RealmController(Context context) {

        this.context = context;
        realm = Realm.getInstance(context);
    }

    public static RealmController with(Context context) {

        if (instance == null) {
            instance = new RealmController(context);
        }
        return instance;
    }


    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }


}
