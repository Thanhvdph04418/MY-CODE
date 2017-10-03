package linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.R;
import linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.ui.activity.MainActivity;

/**
 * Created by canhh on 13/07/2017.
 */

public class Fragment_A extends Fragment {
    private Button btnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmenta,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).nextFragment(new Fragment_B(),R.id.myLayout);
            }
        });
    }
}
