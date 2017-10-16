package putout.thebest.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
/**
 * Created by daffer on 2017/10/6.
 */

public class Users extends RealmObject {
    private RealmList<Person> users;

    public RealmList<Person> getUsers() {
        return users;
    }

    public void setUsers(RealmList<Person> users) {
        this.users = users;
    }


}
