package recycleview.fpt.canhhh.recycleview.model;

/**
 * Created by canhh on 6/29/2017.
 */

public class Student {

    private String name;
    private int age;
    public Student(String s, int i) {
    }

    public Student(int idImag, String name, int age) {
        this.name = name;
        this.age = age;
    }

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
