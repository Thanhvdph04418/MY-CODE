package you.fuck.i.ecommerceapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import you.fuck.i.ecommerceapp.common.Contants;
import you.fuck.i.ecommerceapp.model.ProductModel;


public class CartDAO  {
     private CartDatabase cartDatabase;
    private SQLiteDatabase database;

    public CartDAO(Context context){
        cartDatabase = new CartDatabase(context);
    }

    public void open(){
        database = cartDatabase.getWritableDatabase();
    }

    public boolean addData(ProductModel st) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contants.NAME,st.getTen_sanpham());
        contentValues.put(Contants.PRICE, st.getGia_sanpham());
        long check = database.insert(Contants.TABLE_NAME, null, contentValues);
        if (check != 0) return true;
        return false;
    }
    public  void  close(){ database.close();}

    public ArrayList<ProductModel> getProductModels(){
        ArrayList<ProductModel> data = new ArrayList<>();
        String statements = "SELECT * FROM " + Contants.TABLE_NAME;
        Cursor cursor = database.rawQuery(statements, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex(Contants.ID));
            String name = cursor.getString(cursor.getColumnIndex(Contants.NAME));
            int price = cursor.getInt(cursor.getColumnIndex(Contants.PRICE));
            ProductModel st = new ProductModel(id,name,price);
            data.add(st);
            cursor.moveToNext();
        }
        cursor.close();

        return data;
    }

}
