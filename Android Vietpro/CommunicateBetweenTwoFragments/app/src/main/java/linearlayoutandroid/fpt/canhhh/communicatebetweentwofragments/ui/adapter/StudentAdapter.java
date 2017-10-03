package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.R;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.model.StudentModel;


class lStudentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentModel> data;
    public  lStudentAdapter(Context context, ArrayList<StudentModel> data){
        this.context = context;
        this.data=data;
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
        ViewHolder viewHolder;
        if (convertView== null){
            convertView = inflater.inflate(R.layout.custum_item_student,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        StudentModel st = this.data.get(position);
        viewHolder.txtName.setText(st.getName());
        viewHolder.txtAge.setText(String.valueOf(st.getAge()));
        return convertView;
    }


    public class ViewHolder{
        TextView txtName;
        TextView txtAge;

        public ViewHolder(View view){
            txtAge =(TextView)view.findViewById(R.id.txtAge);
            txtName =(TextView)view.findViewById(R.id.txtName);
        }
    }
}
