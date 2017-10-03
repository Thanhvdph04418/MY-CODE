package tenproject.tencongty.tenminh.sqlite2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CreateDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "QUẢN LÝ SINH VIÊN";
    public static final int VERSION=1;
    public static final String TABLE_NAME = "SINHVIEN";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String AGE ="AGE";

    public CreateDatabase(Context context) {
        super(context,CreateDatabase.DB_NAME,null,VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = " CREATE TABLE "
                + CreateDatabase.TABLE_NAME + "("
                + CreateDatabase.NAME + " TEXT, "
                + CreateDatabase.ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CreateDatabase.AGE + " INTEGER );";
        db.execSQL(statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i!=i1) {
            String statement = " DROP " + CreateDatabase.TABLE_NAME + " IF EXISTS;";
            db.execSQL(statement);
        }

    }
}
