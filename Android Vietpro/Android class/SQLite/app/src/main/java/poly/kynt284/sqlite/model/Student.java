package poly.kynt284.sqlite.model;

//Cái này thằng nào không biết nữa thì thôi khỏi cần thi luôn hihihi
public class Student {
    private String  name;
    private int id, age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
