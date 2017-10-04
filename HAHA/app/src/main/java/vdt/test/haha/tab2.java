package vdt.test.haha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class tab2 extends Fragment {
    GridLayoutManager lLayout;
    Adapre ad;
    public static tab2 newInstance(int page){
        tab2 fragmentConten = new tab2();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragmentConten.setArguments(args);
        return  fragmentConten;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final ArrayList<item> data;
        View view=inflater.inflate(R.layout.tab2,container,false);
data=new ArrayList<>();
        data.add(new item("Thanh"));
        data.add(new item("tuan"));
        data.add(new item("dep"));
        data.add(new item("zai"));
        data.add(new item("a"));
        data.add(new item("hi"));
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);
        lLayout = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.setHasFixedSize(true);


        ad = new Adapre(data,getActivity());

        recyclerView.setAdapter(ad);

        return view;
    }


}
