package linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.R;

/**
 * Created by canhh on 13/07/2017.
 */

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentc, container, false);
    }

    public static FragmentC newInstance(String title){
        FragmentC fragmentC = new FragmentC();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragmentC.setArguments(args);
        return fragmentC;
    }
}
