package tenproject.tencongty.tenminh.sqlite4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CreatDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "QUANLYSINHVIEN";
    public static final int VERSION = 1;
    public static final String TABLE_NAME = "SINHVIEN";
    public static final String ID = "ID";
    public static final String AGE = "AGE";
    public static final String POIN = "POIN";

    public CreatDatabase(Context context) {
        super(context,CreatDatabase.DB_NAME,null,CreatDatabase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = " CREATE TABLE "
                + CreatDatabase.TABLE_NAME +"("
                + CreatDatabase.ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CreatDatabase.AGE + " INTEGER, "
                + CreatDatabase.POIN + " INTEGER ); ";
        db.execSQL(statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion!=newVersion){
            String statement = " DROP "+ CreatDatabase.TABLE_NAME + " IF EXISTS;";
            db.execSQL(statement);
        }

    }
}
