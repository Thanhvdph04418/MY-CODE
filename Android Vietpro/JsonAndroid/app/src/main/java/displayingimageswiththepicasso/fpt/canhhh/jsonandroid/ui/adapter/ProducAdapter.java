package displayingimageswiththepicasso.fpt.canhhh.jsonandroid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.R;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.model.Product;


public class ProducAdapter extends RecyclerView.Adapter<ProducAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> datas;

    public ProducAdapter(Context context, ArrayList<Product> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ProducAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // hàm khởi tạo
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_items_products,parent,false);
        ViewHolder viewHoder = new ViewHolder(v);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ProducAdapter.ViewHolder holder, int position) {
        // hàm chức năng
        Product pr = datas.get(position);
        holder.txtNameProduc.setText(pr.getTen_sanpham());
        holder.txtGia.setText(String.valueOf(pr.getGia_sanpham()));
        Glide.with(context)
                .load(datas.get(position).getAnh_sanpham())
                .into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        public TextView txtNameProduc;
        public TextView txtGia;
        public ViewHolder(View itemView) {
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.img);
            txtGia = (TextView) itemView.findViewById(R.id.txtGia);
            txtNameProduc = (TextView) itemView.findViewById(R.id.txtNameProduct);
        }
    }
}
