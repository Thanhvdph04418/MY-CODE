package linearlayoutandroid.fpt.canhhh.studentmanager1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.studentmanager1.model.StudentModel;

/**
 * Created by canhh on 11/07/2017.
 */

public class StudentDao {
    private SQLiteDatabase db;
    private CreateDatabase createDatabase;

    public StudentDao(Context context) {
        createDatabase = new CreateDatabase(context);
    }

    public void open() {
        db = createDatabase.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean addData(StudentModel st) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.NAME, st.getName());
        contentValues.put(CreateDatabase.AGE, st.getAge());
        long check = db.insert(CreateDatabase.TABLE_NAME, null, contentValues);
        if (check != 0) return true;
        return false;
    }

    public ArrayList<StudentModel> getData() {
        ArrayList<StudentModel> data = new ArrayList<>();
        String statements = "SELECT * FROM " + createDatabase.TABLE_NAME;
        Cursor cursor = db.rawQuery(statements, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            int id = cursor.getInt(cursor.getColumnIndex(CreateDatabase.ID));
            String name = cursor.getString(cursor.getColumnIndex(CreateDatabase.NAME));
            int age = cursor.getInt(cursor.getColumnIndex(CreateDatabase.AGE));
            StudentModel st = new StudentModel(id, age, name);
            data.add(st);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    public void deleteData(int id) {
        String staments = "DELETE FROM " + CreateDatabase.TABLE_NAME +"WHERE " + CreateDatabase.ID + " = " +id;
        db.execSQL(staments);
    }

    public void updateData(StudentModel st){
        String statements = "UPDATE "
                + createDatabase.TABLE_NAME +" SET "
                + createDatabase.NAME + " = ' ' " + st.getName() + "', "
                + createDatabase.AGE + " = " + st.getAge() + "WHERE "
                + createDatabase.ID + " = " + st.getId();
        db.execSQL(statements);
    }
}


