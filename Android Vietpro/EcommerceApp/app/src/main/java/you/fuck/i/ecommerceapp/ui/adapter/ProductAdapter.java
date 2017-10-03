package you.fuck.i.ecommerceapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.common.Onclick;
import you.fuck.i.ecommerceapp.model.ProductModel;
import you.fuck.i.ecommerceapp.ui.activity.MainActivity;
import you.fuck.i.ecommerceapp.ui.fragment.DetailProductFragment;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ProductModel> datas;
    private Onclick onclick;

    public ProductAdapter(Context context, ArrayList<ProductModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_item_products, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(this.datas.get(position).getTen_sanpham());
        holder.txtPrice.setText(String.valueOf(this.datas.get(position).getGia_sanpham()));
        Glide.with(this.context).load(this.datas.get(position).getAnh_sanpham()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgProduct;
        public TextView txtName;
        public TextView txtPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            imgProduct =(ImageView)itemView.findViewById(R.id.imgProduct);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtPrice = (TextView)itemView.findViewById(R.id.txtPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String anh_sanpham = datas.get(position).getAnh_sanpham();
            String ten_sanpham = datas.get(position).getTen_sanpham();
            int gia_sanpham = datas.get(position).getGia_sanpham();
            String mota_sanpham = datas.get(position).getMota_sanpham();
            ((MainActivity) context).nextFragment(R.id.mylayout, DetailProductFragment.newInstants(anh_sanpham, ten_sanpham, gia_sanpham, mota_sanpham));
        }
    }
}
