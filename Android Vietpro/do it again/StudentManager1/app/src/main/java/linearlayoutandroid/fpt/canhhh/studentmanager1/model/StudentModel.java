package linearlayoutandroid.fpt.canhhh.studentmanager1.model;

/**
 * Created by canhh on 10/07/2017.
 */

public class StudentModel {
    private  int id,age;
    private String name;

    public StudentModel(int age, String name) {
        this.age = age;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentModel(int id, int age, String name) {

        this.id = id;
        this.age = age;
        this.name = name;
    }
}
