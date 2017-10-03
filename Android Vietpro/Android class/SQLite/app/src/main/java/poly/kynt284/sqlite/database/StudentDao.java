package poly.kynt284.sqlite.database;

//Created by kynt9 on 8/18/2017.

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import poly.kynt284.sqlite.model.Student;

//Lớp StudentDao() có chức năng thêm, lấy, sửa, xóa sinh viên;
public class StudentDao{
    //ta phải khai báo 2 dòng dưới để giúp ta thực thi các câu truy vấn
    private SQLiteDatabase db;
    private CreateDatabase creatDatabase;

    public StudentDao(Context context){
        creatDatabase = new CreateDatabase(context);
    }

    //hàm này để mở database
    public void open(){
        db = creatDatabase.getWritableDatabase();
    }

    //hàm này để đóng database
    public void close(){
        db.close();
    }

    //Hàm này là hàm thêm dữ liệu
    public boolean addData(Student st){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.NAME, st.getName());
        contentValues.put(CreateDatabase.AGE, st.getAge());
        long check = db.insert(CreateDatabase.TABLE_NAME, null, contentValues);
        if (check!=0) return true;
        else return false;
    }

    //Hàm này là hàm lấy dữ liệu
    public ArrayList<Student> getData(){
        //tạo ra 1 list để có thể lấy dữ liệu ra từ list đó
        ArrayList<Student> data = new ArrayList<>();
        //câu truy vấn lấy ra thông tin ở trong bảng
        //SELECT * FROM TÊN_BẢNG
        String statements = "SELECT * FROM " + CreateDatabase.TABLE_NAME;
        //Cursor là con trỏ, tạo mới 1 con trỏ
        Cursor cursor = db.rawQuery(statements, null);
        //Nó sẽ trỏ vào dòng đầu tiên của bảng
        cursor.moveToFirst();
        //Đọc hết dòng đầu tiên sẽ chuyển đến dòng tiếp theo đến khi nào đọc hết dòng cuối thì k đọc nữa
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(cursor.getColumnIndex(CreateDatabase.ID));
            String name = cursor.getString(cursor.getColumnIndex(CreateDatabase.NAME));
            int age = cursor.getInt(cursor.getColumnIndex(CreateDatabase.AGE));
            //Khi đọc xong thì add vào lớp Student
            Student st = new Student(id, name, age);
            data.add(st);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    //Hàm này là hàm sửa dữ liệu theo ID
    //UPDATE TÊN_BẢNG SET TÊN_CỘT_1 = (người dùng muốn sửa), TÊN_CỘT_2 = (người dùng muốn sửa) WHERE ID
    public void updateData(Student st) {
        String statements = "UPDATE "
                + CreateDatabase.TABLE_NAME + " SET "
                + CreateDatabase.NAME + " = '" + st.getName() + "', "
                + CreateDatabase.AGE + " = " + st.getAge() + " WHERE "
                + CreateDatabase.ID + " = " + st.getId();
        db.execSQL(statements);
    }

    //Hàm này là hàm xóa dữ liệu theo ID
    //DELETE FROM TÊN_BẢNG WHERE ID = Số người dùng nhập vào
    public void deleteData(int id) {
        String statements = " DELETE FROM "
                + CreateDatabase.TABLE_NAME + " WHERE "
                + CreateDatabase.ID + " = " + id;
        db.execSQL(statements);
    }


}
