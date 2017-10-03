package tenproject.tencongty.tenminh.quanlyhethongsinhvien.model;

/**
 * Created by canhh on 11/08/2017.
 */

public class Student {
    private String name;
    private String birthday;
    private String id;

    public Student(String name, String birthday, String id) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
    }

    public Student(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
