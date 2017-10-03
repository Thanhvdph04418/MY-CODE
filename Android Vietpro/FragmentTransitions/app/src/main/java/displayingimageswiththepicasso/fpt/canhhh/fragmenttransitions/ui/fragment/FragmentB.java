package displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.R;

/**
 * Created by canhh on 25/07/2017.
 */

public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }
}
