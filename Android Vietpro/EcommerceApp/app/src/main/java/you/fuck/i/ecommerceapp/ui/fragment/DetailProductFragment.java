package you.fuck.i.ecommerceapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.db.CartDAO;
import you.fuck.i.ecommerceapp.model.ProductModel;


public class DetailProductFragment extends Fragment {
    private CartDAO dao;
    private TextView txtNameProductDetail, txtPriceDetail,txtContent;
    private ImageView imgProductDetail;
    private Button btnProducDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }
    public static DetailProductFragment newInstants(String anh_sanpham, String ten_sanpham, int gia_sanpham, String mota_sanpham){
        DetailProductFragment detailProductFragment = new DetailProductFragment();
        Bundle args = new Bundle();
        args.putString("anh_sanpham", anh_sanpham);
        args.putString("ten_sanpham", ten_sanpham);
        args.putInt("gia_sanpham",gia_sanpham );
        args.putString("mota_sanpham", mota_sanpham);
        detailProductFragment.setArguments(args);
        return  detailProductFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String anh_sanpham = getArguments().getString("anh_sanpham");
        final String ten_sanpham= getArguments().getString("ten_sanpham");
        final int gia_sanpham= getArguments().getInt("gia_sanpham");
        String mota_sanpham = getArguments().getString("mota_sanpham");

        txtNameProductDetail = (TextView)view.findViewById(R.id.txtNameProducDetail);
        txtPriceDetail = (TextView)view.findViewById(R.id.txtPriceDetail);
        imgProductDetail = (ImageView)view.findViewById(R.id.imgProducDetail);
        btnProducDetail = (Button)view.findViewById(R.id.btnAddtocart);
        txtContent = (TextView)view.findViewById(R.id.txtConten);

        Glide.with(getActivity()).load(anh_sanpham).into(imgProductDetail);
        txtContent.setText(mota_sanpham);
        txtPriceDetail.setText(String.valueOf(gia_sanpham));
        txtNameProductDetail.setText(ten_sanpham);
        dao = new CartDAO(getActivity());
        dao.open();

        btnProducDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dao.addData(new ProductModel(ten_sanpham, gia_sanpham)))
                    Toast.makeText(getActivity(), "them thanh cong", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "them that bai", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dao.close();
    }
}
