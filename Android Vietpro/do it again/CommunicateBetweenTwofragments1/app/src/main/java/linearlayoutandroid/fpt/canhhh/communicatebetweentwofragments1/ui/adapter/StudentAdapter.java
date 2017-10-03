package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.R;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.model.StudentModel;

/**
 * Created by canhh on 17/07/2017.
 */

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentModel> data;

    public StudentAdapter(Context context, ArrayList<StudentModel> data){
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        ViewHoder viewHoder;
        if (convertView ==null){
            convertView = inflater.inflate(R.layout.custom_item_student,parent,false);
            viewHoder = new ViewHoder(convertView);
            convertView.setTag(viewHoder);
        }else {
            viewHoder =(ViewHoder) convertView.getTag();
        }
        StudentModel st = this.data.get(position);
        viewHoder.txtName.setText(st.getName());
        viewHoder.txtAge.setText(String.valueOf(st.getAge()));
        return convertView;

    }
    public class ViewHoder{
        TextView txtName;
        TextView txtAge;

        public ViewHoder(View view){
            txtAge = (TextView) view.findViewById(R.id.txtAge);
            txtName = (TextView) view.findViewById(R.id.txtName);
        }
    }
}
