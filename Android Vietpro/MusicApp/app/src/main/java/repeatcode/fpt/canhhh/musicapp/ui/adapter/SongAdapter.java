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
import repeatcode.fpt.canhhh.musicapp.model.MusicModel;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHoder>{
    private Context context;
    private ArrayList<MusicModel> datas;



    public SongAdapter(Context context, ArrayList<MusicModel> datas, String[] tagTitles) {
        this.context = context;
        this.datas = datas;
    }

    public SongAdapter(FragmentActivity activity, ArrayList<MusicModel> datas) {
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {// kết nối giao diện
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.fragment_song,parent,false);
        ViewHoder viewHoder = new ViewHoder(v);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {//setText với bắt sự kiện
        holder.txtSinger.setText(this.datas.get(position).getSinger());
        holder.txtSong.setText(this.datas.get(position).getSong());

    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        public TextView txtSong,txtSinger;
        public ViewHoder(View itemView){
            super(itemView);
            txtSinger = (TextView) itemView.findViewById(R.id.txtSinger);
            txtSong = (TextView) itemView.findViewById(R.id.txtSong);
        }
    }
}
