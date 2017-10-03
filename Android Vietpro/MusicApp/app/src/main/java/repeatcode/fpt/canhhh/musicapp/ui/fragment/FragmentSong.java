package repeatcode.fpt.canhhh.musicapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import repeatcode.fpt.canhhh.musicapp.R;
import repeatcode.fpt.canhhh.musicapp.model.MusicModel;
import repeatcode.fpt.canhhh.musicapp.ui.adapter.SongAdapter;


public class FragmentSong extends Fragment{
    private SongAdapter adapter;
    private ArrayList<MusicModel> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song,container,false);
    }

    public static FragmentSong newInstance(String Singer,String song){
        FragmentSong fragmentSong = new FragmentSong();
        Bundle args = new Bundle();
        args.putString("Singer",Singer);
        args.putString("Song",song);
        fragmentSong.setArguments(args);
        return  fragmentSong;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvSong = (RecyclerView) view.findViewById(R.id.rvSong) ;
        initDatas();
        adapter = new SongAdapter(getActivity(),this.datas);
        rvSong.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSong.setAdapter(adapter);


    }
    private void initDatas(){
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
        datas.add(new MusicModel("Ghen","Min"));
    }
}
