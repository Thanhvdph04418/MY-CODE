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
import repeatcode.fpt.canhhh.musicapp.model.SingerModel;
import repeatcode.fpt.canhhh.musicapp.ui.adapter.SingerAdapter;

public class FragmentSinger extends Fragment {
    private SingerAdapter adapter;
    private ArrayList<SingerModel> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singer,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvSinger = (RecyclerView) view.findViewById(R.id.rvSinger);
        initDatas();
        adapter  = new SingerAdapter(getActivity(),this.datas);
        rvSinger.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSinger.setAdapter(adapter);
    }
    public void initDatas(){
        this.datas = new ArrayList<>();
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
        this.datas.add(new SingerModel("Hoàng Thùy Linh"));
    }
}
