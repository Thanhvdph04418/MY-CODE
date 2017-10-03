package linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.R;

/**
 * Created by canhh on 13/07/2017.
 */

public class Fragment_B  extends Fragment{
    private Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentb,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.myLayout);
                getActivity().getSupportFragmentManager().popBackStack(fragment.getClass().getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
    }
}
