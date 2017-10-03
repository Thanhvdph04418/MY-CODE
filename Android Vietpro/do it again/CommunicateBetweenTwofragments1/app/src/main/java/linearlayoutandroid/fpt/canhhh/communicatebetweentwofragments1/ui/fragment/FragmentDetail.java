package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.R;

/**
 * Created by canhh on 17/07/2017.
 */

public class FragmentDetail extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtNameConten = (TextView)view.findViewById(R.id.)
    }
}
