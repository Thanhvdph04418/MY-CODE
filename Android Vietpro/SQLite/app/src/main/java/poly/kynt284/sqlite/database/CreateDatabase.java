package poly.kynt284.sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Created by kynt9 on 8/18/2017.

//Lớp CreateDatabase() có chức năng tạo ra database và kiểm tra sự thay đổi của database;
public class CreateDatabase extends SQLiteOpenHelper {
//Khi extends SQLiteOpenHelper sẽ bị báo đỏ chỉ cần trỏ chuột vào phần đỏ rồi ấn Alt+Enter;
//bấm khi nào hết đỏ thì thôi; nó sẽ tạo ra cho mình 3 hàm là
    //1. public CreatDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){}
    //2. public void onCreate(SQLiteDatabase sqLiteDatabase) {}
    //3. public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}


    //6 dòng dưới tạo ra để dùng chung cho các lớp khác khi gọi sang tránh viết trực tiếp các chuỗi(bớt nguy cơ viết sai);
    //Để gọi ra được ta gọi tênlớp.teenphuongthức (VD: CreateDatabase.DB_NAME);
    public static final String DB_NAME = "QUANLYSINHVIEN";
    public static final int VERSION = 1;
    public static final String TABLE_NAME = "SINHVIEN";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";


    //public CreatDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    //    super(context, name, factory, version);
    //}

    //hãy để ý 3 dòng comment ở trên thực chất khi ấn Alt+Enter sẽ ra hàm bên trên nhưng hãy xóa đi 3 tham số cuối;
    public CreateDatabase(Context context) {
        super(context, CreateDatabase.DB_NAME, null, CreateDatabase.VERSION);
    }

    //Viết câu truy vấn tạo 1 bảng mới ở đây (có nhiều bảng thì viết nhiều lần);
    //Tạo 1 biến có kiểu là String tên là statments(câu lệnh truy vấn) tên có thể đổi thành tên khác;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //VD: String statements = "CREATE TÊN_BẢNG(TÊN_CỘT_1  KIỂU_DỮ_LIỆU  KHÓA_CHÍNH  TỰ_ĐỘNG_TĂNG, TÊN_CỘT_2  KIỂU_DỮ_LIỆU, TÊN_CỘT_N  KIỂU_DỮ_LIỆU_N,...);";
        //sau đó thay các từ tên bảng, tên cột, kiểu dữ liệu giống như bên dưới;
        String statements = " CREATE TABLE "
                + CreateDatabase.TABLE_NAME + "("
                + CreateDatabase.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CreateDatabase.NAME + " TEXT, "
                + CreateDatabase.AGE + " INTEGER );";
        //Thực thi câu lệnh bằng hàm execSQL();
        sqLiteDatabase.execSQL(statements);
    }

    //Hàm onUpgrade() có chức năng kiểm tra nếu version cũ khác version mới thì sẽ xóa câu truy vấn version cũ
    //cũng tạo 1 biến có kiểu là String;
    //DROP TÊN_BẢNG IF EXISTS;
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            String statements = "DROP " + CreateDatabase.TABLE_NAME + " IF EXISTS;";
            sqLiteDatabase.execSQL(statements);
        }
    }
}
