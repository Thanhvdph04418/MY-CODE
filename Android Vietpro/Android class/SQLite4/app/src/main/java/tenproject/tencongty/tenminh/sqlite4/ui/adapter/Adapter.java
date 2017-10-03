package tenproject.tencongty.tenminh.sqlite4.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite4.Model.Model;
import tenproject.tencongty.tenminh.sqlite4.R;


public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Model> datas;

    public Adapter(Context context, ArrayList<Model> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
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
            convertView = inflater.inflate(R.layout.custom_item_listview,parent,false);
            viewHoder = new ViewHoder(convertView);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder)convertView.getTag();
        }
        viewHoder.age.setText(String.valueOf(datas.get(position).getAge()));
        viewHoder.id.setText(String.valueOf(datas.get(position).getId()));
        viewHoder.poin.setText(String.valueOf(datas.get(position).getPoin()));
        return convertView;
    }
    class ViewHoder{
        TextView id,age,poin;

        public ViewHoder(View v){
            id = (TextView)v.findViewById(R.id.txtID);
            age = (TextView)v.findViewById(R.id.txtAge);
            poin = (TextView)v.findViewById(R.id.txtPoin);
        }

    }
}

