package tenproject.tencongty.tenminh.quanlyhethongsinhvien.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tenproject.tencongty.tenminh.quanlyhethongsinhvien.R;
import tenproject.tencongty.tenminh.quanlyhethongsinhvien.ui.adapter.AdapterClass;


public class FragmentClass extends Fragment{
    RecyclerView rvClass;
    AdapterClass adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_class,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvClass = (RecyclerView)view.findViewById(R.id.rvClass);
    }
}
