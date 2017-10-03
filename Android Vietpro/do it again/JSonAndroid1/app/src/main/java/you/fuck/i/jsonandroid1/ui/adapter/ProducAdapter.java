package you.fuck.i.jsonandroid1.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import you.fuck.i.jsonandroid1.R;
import you.fuck.i.jsonandroid1.model.ProductModer;


public class ProducAdapter extends RecyclerView.Adapter<ProducAdapter.ViewHoder> {
    private ArrayList<ProductModer> datas;
    private Context context;

    public ProducAdapter(ArrayList<ProductModer> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        // hàm khởi tạo
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_items_product,parent,false);
        ViewHoder viewHoder = new ViewHoder(v);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        // hàm chức năng
        ProductModer pr = datas.get(position);
        holder.txtPriceProduct.setText(pr.getTen_sanpham());
        holder.txtNameProduct.setText(pr.getGia_sanpham());
        Glide.with(context) .load(datas.get(position).getAnh_sanpham())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtNameProduct, txtPriceProduct;
        public ViewHoder(View itemView) {
            super(itemView);
            img =(ImageView) itemView.findViewById(R.id.img);
            txtNameProduct = (TextView)itemView.findViewById(R.id.txtNameProduct);
            txtPriceProduct= (TextView)itemView.findViewById(R.id.txtPriceProduct);
        }
    }
}
