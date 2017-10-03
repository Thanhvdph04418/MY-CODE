package tenproject.tencongty.tenminh.serviceandroid.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tenproject.tencongty.tenminh.serviceandroid.R;
import tenproject.tencongty.tenminh.serviceandroid.services.MyService;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }

    private Intent i = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnStar = (Button)view.findViewById(R.id.btnstart);
        Button btnStop = (Button)view.findViewById(R.id.btnstop);
        btnStar.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnstart:
                i = new Intent(getActivity(), MyService.class);
                getActivity().startService(i);
                break;
            case R.id.btnstop:
                getActivity().stopService(i);
                break;
        }
    }
}
