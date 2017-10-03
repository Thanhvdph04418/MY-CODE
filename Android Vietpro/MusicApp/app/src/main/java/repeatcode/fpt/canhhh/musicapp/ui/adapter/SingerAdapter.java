package repeatcode.fpt.canhhh.musicapp.ui.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import repeatcode.fpt.canhhh.musicapp.R;
import repeatcode.fpt.canhhh.musicapp.model.SingerModel;


public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHoder>{
    private Context context;
    private ArrayList<SingerModel> datas;



    public SingerAdapter(Context context, ArrayList<SingerModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    public SingerAdapter(FragmentActivity activity, ArrayList<SingerModel> datas) {
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {// kết nối giao diện
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.fragment_singer,parent,false);
        ViewHoder viewHoder = new ViewHoder(v);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {//setText với bắt sự kiện
        holder.txtSingerList.setText(this.datas.get(position).getTxtSinger());

    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        public TextView txtSingerList;
        public ViewHoder(View itemView){
            super(itemView);
            txtSingerList = (TextView) itemView.findViewById(R.id.txtSingerList);
        }
    }
}
