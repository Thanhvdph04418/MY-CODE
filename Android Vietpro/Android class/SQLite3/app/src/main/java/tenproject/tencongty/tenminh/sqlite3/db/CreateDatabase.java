package tenproject.tencongty.tenminh.sqlite3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by canhh on 23/08/2017.
 */

public class CreateDatabase  extends SQLiteOpenHelper{
    public static final String DB_NAME =" QUANLYSINHVIEN ";
    public static final int VERSION = 1;
    public static final String TABLE_NAME =" SINHVIEN ";
    public static final String ID = "ID ";
    public static final String AGE = " AGE ";
    public static final String POIN = " POIN ";

    public CreateDatabase(Context context) {
        super(context,CreateDatabase.DB_NAME,null,CreateDatabase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statements = " CREATE TABLE "
                + CreateDatabase.TABLE_NAME +"("
                + CreateDatabase.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CreateDatabase.AGE + " INTEGER,"
                + CreateDatabase.POIN + " INTEGER );";
        db.execSQL(statements);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            String statement =" DROP " + CreateDatabase.TABLE_NAME + " IF EXISTS;";
            db.execSQL(statement);
        }

    }
}
