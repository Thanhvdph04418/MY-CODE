package linearlayoutandroid.fpt.canhhh.studentmanager1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by canhh on 10/07/2017.
 */

public class CreateDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "student_db";
    public static final String TABLE_NAME = "STUDENT";
    public static final int DB_VERSION= 1;
    public static final String ID= "ID";
    public static final String AGE= "AGE";
    public static final String NAME= "NAME";

    public CreateDatabase(Context context) {
        super(context,DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statements = "CREATE TABLE "
                +TABLE_NAME+"("
                +ID+"INTERGER PRIMARY KEY AUTOINCREMENT, "
                +NAME+" TEXT, "
                +AGE+" INTERGER);";
        db.execSQL(statements);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            String statements ="DROP TABLE "+TABLE_NAME+" IF EXISTS";
            db.execSQL(statements);
        }

    }
}
