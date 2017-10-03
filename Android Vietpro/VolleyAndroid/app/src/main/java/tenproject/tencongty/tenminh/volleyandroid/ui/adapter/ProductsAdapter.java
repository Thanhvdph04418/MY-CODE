package tenproject.tencongty.tenminh.volleyandroid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.volleyandroid.R;
import tenproject.tencongty.tenminh.volleyandroid.model.Products;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Products> datas;

    public ProductsAdapter(Context context, ArrayList<Products> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // hàm khởi tạo
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.custom_items_products, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
        // hàm chức năng
        holder.txtNameProduct.setText(this.datas.get(position).getTen_sanpham());
        holder.txtPrice.setText(String.valueOf(this.datas.get(position).getGia_sanpham()));
        Glide.with(this.context)
                .load(this.datas.get(position).getAnh_sanpham())
                .into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNameProduct, txtPrice;
        public ImageView imgProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNameProduct = (TextView) itemView.findViewById(R.id.txtNameProduct);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
        }
    }
}
