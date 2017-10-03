package you.fuck.i.jsonandroid1.model;


public class ProductModer {
    private int id_sanpham,id_danhmuc,gia_sanpham,sanpham_noibat;
    private String ten_sanpham,mota_sanpham,anh_sanpham;

    public ProductModer(int id_sanpham,String ten_sanpham, int id_danhmuc, int gia_sanpham, String mota_sanpham, int sanpham_noibat,  String anh_sanpham) {
        this.id_sanpham = id_sanpham;
        this.id_danhmuc = id_danhmuc;
        this.gia_sanpham = gia_sanpham;
        this.sanpham_noibat = sanpham_noibat;
        this.ten_sanpham = ten_sanpham;
        this.mota_sanpham = mota_sanpham;
        this.anh_sanpham = anh_sanpham;
    }

    public ProductModer() {
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public int getId_danhmuc() {
        return id_danhmuc;
    }

    public int getGia_sanpham() {
        return gia_sanpham;
    }

    public int getSanpham_noibat() {
        return sanpham_noibat;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public String getMota_sanpham() {
        return mota_sanpham;
    }

    public String getAnh_sanpham() {
        return anh_sanpham;
    }
}
