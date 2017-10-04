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

public class tab3 extends Fragment {
    public static tab3 newInstance(int page){
        tab3 fragmentConten = new tab3();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragmentConten.setArguments(args);
        return  fragmentConten;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab3,container,false);
        return view;
    }
}
