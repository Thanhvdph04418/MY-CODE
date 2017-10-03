package tenproject.tencongty.tenminh.sqlite4.Model;

/**
 * Created by canhh on 25/08/2017.
 */

public class Model {
    private int id,age,poin;

    public Model(int id, int age, int poin) {
        this.id = id;
        this.age = age;
        this.poin = poin;

    }

    public Model(int age, int poin) {
        this.age = age;
        this.poin = poin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
