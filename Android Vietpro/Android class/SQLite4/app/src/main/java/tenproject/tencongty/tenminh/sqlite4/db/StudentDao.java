package tenproject.tencongty.tenminh.sqlite4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite4.Model.Model;


public class StudentDao {
    private CreatDatabase creatDatabase;
    private SQLiteDatabase db;

    public StudentDao(Context context){
        creatDatabase = new CreatDatabase(context);
    }

    public void open(){
        db = creatDatabase.getWritableDatabase();
    }

    public boolean addData(Model md) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreatDatabase.ID,md.getId());
        contentValues.put(CreatDatabase.AGE,md.getAge());
        contentValues.put(CreatDatabase.POIN,md.getPoin());
        long check = db.insert(CreatDatabase.TABLE_NAME, null, contentValues);
        if (check!=0) return true;
        else return false;
    }
    public ArrayList<Model> getData(){
        ArrayList<Model> data = new ArrayList<>();

        String statement = "SELECT * FROM " + CreatDatabase.TABLE_NAME;
        Cursor cursor = db.rawQuery(statement,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int id = cursor.getInt(cursor.getColumnIndex(CreatDatabase.ID));
            int age = cursor.getInt(cursor.getColumnIndex(CreatDatabase.AGE));
            int poin = cursor.getInt(cursor.getColumnIndex(CreatDatabase.POIN));
            Model md = new Model(id,age,poin);
            data.add(md);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }
    public void delete(int id) {
        String statement = " DELETE FROM "
                + CreatDatabase.TABLE_NAME + " WHERE "
                + CreatDatabase.ID + " = " + id;
        db.execSQL(statement);
    }
}
