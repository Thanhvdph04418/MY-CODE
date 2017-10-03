package tenproject.tencongty.tenminh.quanlyhethongsinhvien.model;

/**
 * Created by canhh on 11/08/2017.
 */

public class Class {

    private String tenlop,malop;
    private int stt;

    public Class(String tenlop, String malop, int stt) {
        this.tenlop = tenlop;
        this.malop = malop;
        this.stt = stt;
    }

    public Class() {
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
}
