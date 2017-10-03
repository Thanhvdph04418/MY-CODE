package linearlayoutandroid.fpt.canhhh.creatingandusingfragmant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import linearlayoutandroid.fpt.canhhh.creatingandusingfragmant.R;

/**
 * Created by canhh on 11/07/2017.
 */

public class MainFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container,false);
    }
}
