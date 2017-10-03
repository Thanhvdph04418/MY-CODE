package repeatcode.fpt.canhhh.musicapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import repeatcode.fpt.canhhh.musicapp.R;
import repeatcode.fpt.canhhh.musicapp.model.AlbumModel;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHoder>{
    private Context context;
    private ArrayList<AlbumModel> datas;

    public AlbumAdapter(Context context, ArrayList<AlbumModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {// kết nối giao diện
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.fragment_album,parent,false);
        ViewHoder viewHoder = new ViewHoder(v);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {//setText với bắt sự kiện


    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        public TextView txtAlbum;
        public ViewHoder(View itemView){
            super(itemView);
            txtAlbum = (TextView) itemView.findViewById(R.id.txtAlbum);
        }
    }
}
