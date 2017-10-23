package putout.thebest.realm.MVP.presenter;

import android.app.Activity;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import putout.thebest.realm.MVP.model.Person;
import putout.thebest.realm.MVP.model.realmcontroller.UserData;
import putout.thebest.realm.Realm.RealmController;

/**
 * Created by daffer on 2017/10/18.
 */

public class Presenter {

    //DATE
    Realm realm;
    RealmResults<Person> result;
    UserData userData; //Rx

    //View
    Activity activity;

    public Presenter(Activity activity){
        this.activity = activity;
    }

    /**
     * 初始realm
     */
    public void initialRealm() {

//        RealmConfiguration realmConfiguration = new RealmConfiguration
//                                                                .Builder(this)
//                                                                .name(Realm.DEFAULT_REALM_NAME)
//                                                                .schemaVersion(0)
//                                                                .deleteRealmIfMigrationNeeded()
//                                                                .build();
//        Realm.setDefaultConfiguration(realmConfiguration);

        realm = RealmController.with(activity).getRealm();

//Rx
        userData = new UserData(activity);

        userData
                .findAllUser()
                .subscribe(persons -> result = persons);
    }

    /**
     * 新增
     */
    public void insertData() {

        ArrayList<Person> users = new ArrayList<>();
        Person person;

        person = new Person();
        person.setName("Brian");
        person.setAge(9);
        users.add(person);

        person = new Person();
        person.setName("Yuma");
        person.setAge(15);
        users.add(person);

        person = new Person();
        person.setName("Kuma");
        person.setAge(32);
        users.add(person);

        for(Person user: users){
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
        }

//Rx
        userData.addUser("大熊",69).subscribe();
        userData.addUser("阿凱",78).subscribe();
        userData.addUser("小智",31).subscribe();
    }


    public void clearData() {
        result = realm.where(Person.class).findAll();   //找出realm所有Person的類別

        realm.beginTransaction();
//        result.remove(1);                   //刪除指定的順
        realm.clear(Person.class);        //刪除所有Person類別的資料
        realm.commitTransaction();
    }

    public RealmResults<Person> getResult() {
        return result;
    }
}
