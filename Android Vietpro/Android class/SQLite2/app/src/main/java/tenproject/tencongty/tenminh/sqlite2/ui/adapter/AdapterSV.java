package tenproject.tencongty.tenminh.sqlite2.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite2.R;
import tenproject.tencongty.tenminh.sqlite2.model.ModelSSV;


public class AdapterSV extends BaseAdapter {
    private Context context;
    private ArrayList<ModelSSV> datas;

    public AdapterSV(Context context, ArrayList<ModelSSV> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return (datas==null) ? 0 : datas.size();
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
        if(convertView ==null){
            convertView = inflater.inflate(R.layout.custom_itemt_listview,parent,false);
            viewHoder = new ViewHoder(convertView);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder)convertView.getTag();
        }
        viewHoder.txtName.setText(datas.get(position).getName());
        viewHoder.txtAge.setText(String.valueOf(datas.get(position).getAge()));
        return convertView;
    }
    class ViewHoder{
        TextView txtName, txtAge;

        private ViewHoder(View v){
            txtName = (TextView)v.findViewById(R.id.txtName);
            txtAge = (TextView)v.findViewById(R.id.txtAge);
        }
    }
}
