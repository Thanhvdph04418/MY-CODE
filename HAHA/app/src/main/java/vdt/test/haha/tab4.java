package vdt.test.haha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class tab4 extends Fragment {
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
        View view=inflater.inflate(R.layout.tab1,container,false);
        return view;
    }
}
