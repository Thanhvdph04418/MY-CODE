package repeatcode.fpt.canhhh.musicapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import repeatcode.fpt.canhhh.musicapp.R;
import repeatcode.fpt.canhhh.musicapp.model.AlbumModel;
import repeatcode.fpt.canhhh.musicapp.ui.adapter.AlbumAdapter;

/**
 * Created by canhh on 19/07/2017.
 */

public class FragmentAlbum extends Fragment {
    private AlbumAdapter adapter;
    private ArrayList<AlbumModel> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvAlbum = (RecyclerView) view.findViewById(R.id.rvAlbum);
        initDatas();
        adapter  = new AlbumAdapter(getActivity(),this.datas);
        rvAlbum.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rvAlbum.setAdapter(adapter);
    }
    private void initDatas(){
        this.datas = new ArrayList<>();
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
        this.datas.add(new AlbumModel("nhaccuatui.com"));
    }
}
