package vdt.test.haha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class tab1 extends android.support.v4.app.Fragment {

    public static tab1 newInstance(int page){
        tab1 fragmentConten = new tab1();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragmentConten.setArguments(args);
        return  fragmentConten;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final PullRefreshLayout layout;
        View view=inflater.inflate(R.layout.tab1,container,false);
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "string " + i;
        }
        final ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new android.widget.ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array));

        layout = (PullRefreshLayout)view. findViewById(R.id.swipeRefreshLayout);
        layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
        layout.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);

        return view;
    }
}
