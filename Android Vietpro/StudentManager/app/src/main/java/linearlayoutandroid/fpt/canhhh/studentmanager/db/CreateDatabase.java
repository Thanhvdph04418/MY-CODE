package linearlayoutandroid.fpt.canhhh.studentmanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CreateDatabase extends SQLiteOpenHelper {
    public static final  String DB_NAME = "student_db";//static là để dùng chung ; final tạo ra hằng số
    public static final  String TABLE_NAME = "STUDENT";
    public static final int DB_VERSION = 1;
    public static final String ID ="ID";
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public CreateDatabase(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//hàm này để truy vấn
        String statements = "CREATE TABLE  "
                +TABLE_NAME+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT, "
                +AGE+" INTEGER);";
        db.execSQL(statements);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            String statements = "DROP TABLE "+TABLE_NAME+" IF EXISTS";//tạo câu truy vấn xóa
            db.execSQL(statements);
        }
    }
}
