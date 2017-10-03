package tenproject.tencongty.tenminh.demoquanlysinhvien.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.demoquanlysinhvien.R;
import tenproject.tencongty.tenminh.demoquanlysinhvien.model.LopModel;

/**
 * Created by canhh on 13/08/2017.
 */

public class AdapterDSL extends RecyclerView.Adapter<AdapterDSL.ViewHordel> {
    private ArrayList<LopModel> datas;
    private Context context;

    public AdapterDSL(ArrayList<LopModel> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHordel onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHordel(LayoutInflater.from(this.context).inflate(R.layout.custom_xdsl,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHordel holder, int position) {
        holder.txtSTT.setText(String.valueOf(position + 1));
        holder.txtML.setText(datas.get(position).getMaLop());
        holder.txtTL.setText(datas.get(position).getTenLop());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHordel extends RecyclerView.ViewHolder {
        public TextView txtSTT,txtTL,txtML;
        public ViewHordel(View itemView) {
            super(itemView);
            txtML=(TextView)itemView.findViewById(R.id.txtML1);
            txtTL=(TextView)itemView.findViewById(R.id.txtTL1);
            txtSTT = (TextView)itemView.findViewById(R.id.txtSttL);

        }
    }
}
