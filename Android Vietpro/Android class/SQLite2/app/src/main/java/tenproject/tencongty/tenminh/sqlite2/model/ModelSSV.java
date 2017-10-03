package tenproject.tencongty.tenminh.sqlite2.model;


public class ModelSSV {
    private String name;
    private int age,id;

    public ModelSSV(int id,String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public ModelSSV(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
