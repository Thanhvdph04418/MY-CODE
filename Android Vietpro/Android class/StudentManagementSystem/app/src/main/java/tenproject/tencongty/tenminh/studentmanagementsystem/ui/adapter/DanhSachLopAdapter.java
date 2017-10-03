package tenproject.tencongty.tenminh.studentmanagementsystem.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.studentmanagementsystem.R;
import tenproject.tencongty.tenminh.studentmanagementsystem.model.LopModel;
import tenproject.tencongty.tenminh.studentmanagementsystem.ui.fragment.XemDanhSachLopFragment;

//Created by X on 8/10/2017.

public class DanhSachLopAdapter extends RecyclerView.Adapter<DanhSachLopAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LopModel> danhSach;
    private XemDanhSachLopFragment xemDanhSachLopFragment;

    public DanhSachLopAdapter(Context context, ArrayList<LopModel> danhSach, XemDanhSachLopFragment xemDanhSachLopFragment) {
        this.context = context;
        this.danhSach = danhSach;
        this.xemDanhSachLopFragment = xemDanhSachLopFragment;
    }

    @Override
    public DanhSachLopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        return new ViewHolder(inflater.inflate(R.layout.custom_item_danh_sach_lop, parent, false));
    }

    @Override
    public void onBindViewHolder(DanhSachLopAdapter.ViewHolder holder, int position) {
        holder.txtSttLop.setText(String.valueOf(position + 1));
        holder.txtNoidungMaLop.setText(danhSach.get(position).getMaLop());
        holder.txtNoidungTenLop.setText(danhSach.get(position).getTenLop());
    }

    @Override
    public int getItemCount() {
        return danhSach.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtSttLop, txtNoidungMaLop, txtNoidungTenLop;

        public ViewHolder(View itemView) {
            super(itemView);
            txtSttLop = (TextView) itemView.findViewById(R.id.txtSttLop);
            txtNoidungMaLop = (TextView) itemView.findViewById(R.id.txtNoiDungMaLop);
            txtNoidungTenLop = (TextView) itemView.findViewById(R.id.txtNoiDungTenLop);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            hienThongBao(position);
        }

        private void hienThongBao(final int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Xóa");
            builder.setMessage("Bạn có muốn xóa [ " + danhSach.get(position).getMaLop() + " - " + danhSach.get(position).getTenLop() + " ] không ?");
            builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    xemDanhSachLopFragment.xoaPhanTu(position);
                }
            });
            builder.create().show();
        }
    }

}
