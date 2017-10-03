package tenproject.tencongty.tenminh.sqlite3.model;

/**
 * Created by canhh on 23/08/2017.
 */

public class Model {
    private int age, poin;
    private String id;

    public Model(int age, int poin, String id) {
        this.age = age;
        this.poin = poin;
        this.id = id;
    }

    public Model() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
