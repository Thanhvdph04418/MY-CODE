package tenproject.tencongty.tenminh.quanlyhethongsinhvien.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.quanlyhethongsinhvien.R;
import tenproject.tencongty.tenminh.quanlyhethongsinhvien.model.Class;


public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{
    private Context context;
    private ArrayList<Class> datas;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_item_listclass,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Class cl = datas.get(position);
        holder.txtTl.setText(cl.getTenlop());
        holder.txtML.setText(cl.getMalop());
        holder.txtsttl.setText(String.valueOf(position +1));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtsttl,txtTl,txtML;
        public ViewHolder(View itemView) {
            super(itemView);
            txtML = (TextView)itemView.findViewById(R.id.txtML);
            txtsttl = (TextView)itemView.findViewById(R.id.txtSTTL);
            txtTl = (TextView)itemView.findViewById(R.id.txtTL);
        }
    }
}
