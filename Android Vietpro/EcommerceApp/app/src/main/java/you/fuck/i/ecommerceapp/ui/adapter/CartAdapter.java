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
import you.fuck.i.ecommerceapp.model.ProductModel;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHoder> {
    private Context context;
    private ArrayList<ProductModel> datas;


    public CartAdapter(Context context, ArrayList<ProductModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custom_item_cart,parent,false);
        ViewHoder viewHolder = new ViewHoder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        Glide.with(this.context).load(datas.get(position).getAnh_sanpham()).into(holder.imgCart);
        holder.txtNameCart.setText(datas.get(position).getTen_sanpham());
        holder.txtPriceCart.setText(""+datas.get(position).getGia_sanpham());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        public ImageView imgCart, imgdetete;
        public TextView txtNameCart,txtPriceCart;
        public ViewHoder(View itemView) {
            super(itemView);
            imgCart = (ImageView)itemView.findViewById(R.id.imgCart);
            txtNameCart = (TextView)itemView.findViewById(R.id.txtNameCart);
            txtPriceCart = (TextView)itemView.findViewById(R.id.txtPriceCart);
            imgdetete =(ImageView)itemView.findViewById(R.id.imgdelete);
        }
    }
}
