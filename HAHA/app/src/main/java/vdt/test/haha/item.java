package vdt.test.haha;

import java.io.Serializable;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class item implements Serializable {

    String ten;

    public item(String ten) {
        this.ten = ten;
    }

    public item() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
