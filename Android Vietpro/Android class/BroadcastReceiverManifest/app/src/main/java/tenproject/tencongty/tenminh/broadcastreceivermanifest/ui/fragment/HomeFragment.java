package tenproject.tencongty.tenminh.broadcastreceivermanifest.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tenproject.tencongty.tenminh.broadcastreceivermanifest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public static HomeFragment newInstance(String content){
        HomeFragment homeFragment = new HomeFragment();
        Bundle bd = new Bundle();
        bd.putString("content",content);
        homeFragment.setArguments(bd);
        return homeFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt = (TextView)view.findViewById(R.id.txt);
        Bundle bd =getArguments();
        if (bd != null){
            String content = bd.getString("content","");
            txt.setText(content);
        }
    }
}
