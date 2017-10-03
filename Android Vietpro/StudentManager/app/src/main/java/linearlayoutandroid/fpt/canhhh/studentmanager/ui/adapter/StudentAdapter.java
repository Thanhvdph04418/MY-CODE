package linearlayoutandroid.fpt.canhhh.studentmanager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.studentmanager.R;
import linearlayoutandroid.fpt.canhhh.studentmanager.model.StudentModel;

/**
 * Created by canhh on 06/07/2017.
 */

public class StudentAdapter extends BaseAdapter {
    private Context context ;

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
        ViewHoder viewHoder =null;
        if (convertView== null){
            convertView = inflater.inflate(R.layout.custon_listview,parent,false);
            viewHoder =new ViewHoder(convertView);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        viewHoder.txtName.setText(this.data.get(position).getName());
        viewHoder.txtAge.setText(this.data.get(position).getAge()+"");
        return convertView;

    }
    public class ViewHoder{
        TextView txtName,txtAge;
        public  ViewHoder(View view){
            txtName = (TextView)view.findViewById(R.id.txtName1);
            txtAge = (TextView)view.findViewById(R.id.txtAge1);
        }
    }
}
