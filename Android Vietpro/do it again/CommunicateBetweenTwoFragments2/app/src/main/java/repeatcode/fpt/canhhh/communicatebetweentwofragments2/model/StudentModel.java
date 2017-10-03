package repeatcode.fpt.canhhh.communicatebetweentwofragments2.model;

/**
 * Created by canhh on 18/07/2017.
 */

public class StudentModel {

    private String name;
    private int age;

    public StudentModel() {
    }

    public StudentModel(String name, int age) {
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
