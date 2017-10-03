package tenproject.tencongty.tenminh.sqlite2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite2.model.ModelSSV;

public class StudentDao {
    private CreateDatabase createDatabase;
    private SQLiteDatabase db;

    public StudentDao(Context context){
        createDatabase = new CreateDatabase(context);
    }

    public void open() {
            db = createDatabase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }
    // hàm thêm dữ liệu
    public boolean addData(ModelSSV md){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.NAME, md.getName());
        contentValues.put(CreateDatabase.AGE, md.getAge());
        long check = db.insert(CreateDatabase.TABLE_NAME,null, contentValues);
        if (check!=0) return true;
        else return false;
    }

    // hàm lấy dữ liệu
    public ArrayList<ModelSSV> getData(){
        ArrayList<ModelSSV> data = new ArrayList<>();

        String statement = "SELECT * FROM " + CreateDatabase.TABLE_NAME;
        Cursor cursor = db.rawQuery(statement,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int id =cursor.getInt(cursor.getColumnIndex(CreateDatabase.ID));
            String name = cursor.getString(cursor.getColumnIndex(CreateDatabase.NAME));
            int age = cursor.getInt(cursor.getColumnIndex(CreateDatabase.AGE));
            ModelSSV md = new ModelSSV(id,name,age);
            data.add(md);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public void delete(int id){
        String statement = " DELETE FROM "
                + CreateDatabase.TABLE_NAME + " WHERE "
                + CreateDatabase.ID + " = " + id ;
        db.execSQL(statement);
    }

}
