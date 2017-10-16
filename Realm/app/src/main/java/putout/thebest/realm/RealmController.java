package putout.thebest.realm;

/**
 * Created by daffer on 2017/10/7.
 */

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;

import io.realm.Realm;


public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    private RealmController(){
        realm = Realm.getDefaultInstance();
    }

    private RealmController(Context context) {
        realm = Realm.getInstance(context);
    }

    public static RealmController with(){
        if(instance == null){
            instance = new RealmController();
        }
        return instance;
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
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
