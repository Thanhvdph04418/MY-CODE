package poly.kynt284.sqlite.ui.adapter;

//Created by kynt9 on 8/18/2017.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import poly.kynt284.sqlite.R;
import poly.kynt284.sqlite.model.Student;

public class StudentAdapter extends BaseAdapter{
    //khai báo 2 biến là màn hình(Context) và 1 list để lưu dữ liệu (ArrayList);
    private Context context;
    private ArrayList<Student> datas;

    //Alt+insert để tạo ra hàm tạo
    public StudentAdapter(Context context, ArrayList<Student> datas) {
        this.context = context;
        this.datas = datas;
    }

    //đếm tất cả các dữ liệu trong list
    @Override
    public int getCount() {
        return (datas==null) ? 0 : datas.size();
    }

    //lấy dữ liệu ở 1 dòng
    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    //lấy ra id để thực hiện một số nhiệm vụ liên quan đến id duy nhất của 1 đối tượng trong danh sách
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Hàm này là để kết nối giao diện custom_items_listview_students và kiểm tra
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        ViewHolder viewHolder;
        if (view == null){
            view = inflater.inflate(R.layout.custom_items_lisview_students, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtAge.setText(String.valueOf(datas.get(i).getAge()));
        viewHolder.txtName.setText(datas.get(i).getName());
        return view;
    }

    //lớp này có khai báo và ánh xạ bên file giao diện custom_items_listview_students
    class ViewHolder {
        TextView txtAge, txtName;

        private ViewHolder(View v){
            txtAge = (TextView) v.findViewById(R.id.txtAge);
            txtName = (TextView) v.findViewById(R.id.txtName);
        }
    }
}
