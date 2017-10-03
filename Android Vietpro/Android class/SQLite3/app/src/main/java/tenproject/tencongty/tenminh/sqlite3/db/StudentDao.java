package tenproject.tencongty.tenminh.sqlite3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite3.model.Model;

/**
 * Created by canhh on 23/08/2017.
 */

public class StudentDao {
    private CreateDatabase createDatabase;
    private SQLiteDatabase db;

    public StudentDao (Context context){
        createDatabase = new CreateDatabase(context);
    }
    public void open(){
        db = createDatabase.getWritableDatabase();
    }

    public boolean addData(Model md){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.ID, md.getId());
        contentValues.put(CreateDatabase.AGE, md.getAge());
        contentValues.put(CreateDatabase.POIN, md.getPoin());
        long check = db.insert(CreateDatabase.TABLE_NAME,null,contentValues);
        if (check != 0 ) return true;
        else return  false;
    }
    public ArrayList<Model> getData(){
        ArrayList<Model> datas = new ArrayList<>();

        String statement = "SELECT * FROM " + CreateDatabase.TABLE_NAME;
        Cursor cursor = db.rawQuery(statement,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String id = cursor.getString(cursor.getColumnIndex(CreateDatabase.ID));
            int age = cursor.getInt(cursor.getColumnIndex(CreateDatabase.AGE));
            int poin = cursor.getInt(cursor.getColumnIndex(CreateDatabase.POIN));
            Model md = new Model(age,poin,id);
            datas.add(md);
            cursor.moveToNext();
        }
        cursor.close();
        return datas;
    }
    public void delete(int id){
        String statement = " DELETE FROM "
                + CreateDatabase.TABLE_NAME + " WHERE "
                + createDatabase.ID + " = " + id;
        db.execSQL(statement);
    }

}
