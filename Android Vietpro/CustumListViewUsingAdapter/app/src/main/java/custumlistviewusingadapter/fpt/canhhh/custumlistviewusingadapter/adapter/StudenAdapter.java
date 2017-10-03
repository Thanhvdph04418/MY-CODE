package custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.R;
import custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.model.Studen;



public class StudenAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Studen> data;
    public StudenAdapter(Context context, ArrayList<Studen> data){
        this.context = context;
        this.data =data;
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
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView =inflater.inflate(R.layout.custum_item_studen,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(this.data.get(position).getName());
        viewHolder.txtAge.setText(this.data.get(position).getAge()+"");
        return convertView;
    }
    public class ViewHolder{
        TextView txtName;
        TextView txtAge;
        public ViewHolder(View view){
            txtName = (TextView)view.findViewById(R.id.txtName);
            txtAge = (TextView)view.findViewById(R.id.txtage);
        }
    }
}
