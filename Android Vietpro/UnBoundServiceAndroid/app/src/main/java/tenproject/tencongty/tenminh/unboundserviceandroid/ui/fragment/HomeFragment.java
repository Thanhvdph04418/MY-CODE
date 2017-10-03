package tenproject.tencongty.tenminh.unboundserviceandroid.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tenproject.tencongty.tenminh.unboundserviceandroid.R;
import tenproject.tencongty.tenminh.unboundserviceandroid.ui.activity.MainActivity;
import tenproject.tencongty.tenminh.unboundserviceandroid.ui.bean.MyMediaPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSlay = view.findViewById(R.id.btnPlay);
        Button btnStop  = view.findViewById(R.id.btnPlay);
        btnSlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlay:
                ((MainActivity) getActivity()).playSong();
                break;
            case R.id.btnStop:
                ((MainActivity) getActivity()).stopSong();
                break;
        }
    }
}
