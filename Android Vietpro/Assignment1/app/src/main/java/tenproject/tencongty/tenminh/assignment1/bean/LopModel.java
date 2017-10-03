package tenproject.tencongty.tenminh.assignment1.bean;

// Created by X on 8/10/2017.

public class LopModel {
    private String key;
    private String maLop;
    private String tenLop;

    public LopModel(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public LopModel(String key, String maLop, String tenLop) {
        this.key = key;
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LopModel() {
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }
}
