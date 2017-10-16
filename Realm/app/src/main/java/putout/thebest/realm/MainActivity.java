package putout.thebest.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RealmResults<Person> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//====================初始realm======================

//        RealmConfiguration realmConfiguration = new RealmConfiguration
//                                                        .Builder(this)
////                                                        .name("brian_db")
//                                                        .build();
//         realm = Realm.getInstance(realmConfiguration);

         realm = RealmController.with(this).getRealm();


//===============刪除======================
        result = realm.where(Person.class).findAll();   //找出realm所有Person的類別

        realm.beginTransaction();
//        result.remove(1);                   //刪除指定的順位
        realm.clear(Person.class);        //刪除所有Person類別的資料
        realm.commitTransaction();


//=============新增=====================
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

//===============查詢====================
          result = realm.where(Person.class)
//                  .lessThan("age",10)  //查詢小於10歲
//                  .greaterThan("age",30).or().lessThan("age",10)  //查詢大於30歲 或 小於10歲
                  .contains("name","K")
                  .findAll();

//        Log.d("B_test",result.get(1).getName());  //印出指定順位

        for(Person user : result){        //印出全部
            Log.d("B_test",user.getName());
        }







    }
}
