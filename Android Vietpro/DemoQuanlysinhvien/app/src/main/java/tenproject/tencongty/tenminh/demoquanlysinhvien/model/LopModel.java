package tenproject.tencongty.tenminh.demoquanlysinhvien.model;

import java.io.Serializable;

/**
 * Created by canhh on 13/08/2017.
 */

public class LopModel implements Serializable{
    private String maLop;
    private String tenLop;

    public LopModel(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
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
