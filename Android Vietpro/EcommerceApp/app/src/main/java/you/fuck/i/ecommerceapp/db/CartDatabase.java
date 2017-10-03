package you.fuck.i.ecommerceapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import you.fuck.i.ecommerceapp.common.Contants;



public class CartDatabase extends SQLiteOpenHelper {

    public CartDatabase(Context context) {
        super(context, Contants.DB_NAME,null,Contants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statements = "CREATE TABLE CART("
                + Contants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Contants.NAME + " TEXT,"
                + Contants.PRICE + " INTEGER); ";
        db.execSQL(statements);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            String statements = "DROP TABLE" + Contants.TABLE_NAME +" IF EXISTS";
            db.execSQL(statements);
        }
    }
}
