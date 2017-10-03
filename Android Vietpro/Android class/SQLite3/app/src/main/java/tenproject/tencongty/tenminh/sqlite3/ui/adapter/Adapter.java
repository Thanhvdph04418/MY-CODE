package tenproject.tencongty.tenminh.sqlite3.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite3.R;
import tenproject.tencongty.tenminh.sqlite3.model.Model;

/**
 * Created by canhh on 23/08/2017.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Model> data;

    public Adapter(Context context, ArrayList<Model> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        ViewHoder viewHoder;
        if (view ==null){
            view = inflater.inflate(R.layout.custom_itemt_listview,viewGroup,false);
            viewHoder= new ViewHoder(view);
            view.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder)view.getTag();
        }
        viewHoder.txtPoin.setText(String.valueOf(data.get(i).getPoin()));
        viewHoder.txtAge.setText(String.valueOf(data.get(i).getPoin()));
        viewHoder.txtID.setText(data.get(i).getId());
        return view;
    }
    class ViewHoder{
        TextView txtAge,txtID,txtPoin;

        public ViewHoder(View v){
            txtID = (TextView)v.findViewById(R.id.txtID);
            txtAge= (TextView)v.findViewById(R.id.txtAge);
            txtPoin= (TextView)v.findViewById(R.id.txtDiem);
        }
    }
}
