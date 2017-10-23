package putout.thebest.realm.MVP.model;

import io.realm.RealmObject;

/**
 * Created by daffer on 2017/10/6.
 */

//@Setter
//@Getter
public class Person extends RealmObject
{
//    @PrimaryKey
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
