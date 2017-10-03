package gritview.fpt.canhhh.gritview.model;

/**
 * Created by canhh on 6/27/2017.
 */

public class MyModel {
    private int  idImage;
    private String name;

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyModel() {

    }

    public MyModel(int idImage, String name) {

        this.idImage = idImage;
        this.name = name;
    }
}
