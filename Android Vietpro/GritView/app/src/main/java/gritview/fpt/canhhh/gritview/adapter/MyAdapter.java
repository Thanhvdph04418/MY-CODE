package gritview.fpt.canhhh.gritview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gritview.fpt.canhhh.gritview.R;
import gritview.fpt.canhhh.gritview.model.MyModel;

/**
 * Created by canhh on 6/27/2017.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<MyModel> data;

    public MyAdapter(Context context, ArrayList<MyModel> data) {
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
        ViewHolder holder = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.androi_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtName.setText(this.data.get(position).getName());
        holder.imgCountry.setImageResource(this.data.get(position).getIdImage());
        return convertView;
    }
    public class ViewHolder{
        public ImageView imgCountry;
        public TextView txtName;
        public ViewHolder(View view){
            txtName = (TextView) view.findViewById(R.id.tv);
            imgCountry = (ImageView) view.findViewById(R.id.im);
        }
    }
}
