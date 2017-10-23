package putout.thebest.realm.MVP.model.realmcontroller;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmResults;
import putout.thebest.realm.Realm.RealmController;
import putout.thebest.realm.Realm.Rx.RealmObservable;
import putout.thebest.realm.MVP.model.Person;
import rx.Observable;

/**
 * Created by daffer on 2017/10/18.
 */

public class UserData {

    Realm realm;
    public final Context context;

    public UserData(Context context){
        this.context = context;
        realm = RealmController.with(context).getRealm();
    }

    public Observable<Person> addUser(String name, int age) {
        Person user= new Person();
        user.setName(name);
        user.setAge(age);
        return RealmObservable.object(context, realm1 -> realm1.copyToRealm(user));
    }

    public Observable<RealmResults<Person>> findAllUser() {
        return RealmObservable.results(context,realm1 -> realm1.where(Person.class).findAll());
    }








}
