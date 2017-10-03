package repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.R;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.model.StudentModel;

public class StudentAdapter extends BaseAdapter {
    Context context;
    ArrayList<StudentModel> data;
    public StudentAdapter(Context context,ArrayList<StudentModel> data){
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
        LayoutInflater inflater =LayoutInflater.from(this.context);
        ViewHoder viewHoder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.custom_itemt_student,parent,false);
            viewHoder = new ViewHoder();
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        StudentModel st = this.data.get(position);
        viewHoder.txtName.setText(st.getName());
        viewHoder.txtAge.setText(String.valueOf(st.getAge()));
        return convertView;
    }

    public class ViewHoder {
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtAge)
        TextView txtAge;
    }
}
