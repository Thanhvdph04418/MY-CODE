package vdt.test.haha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class FragControl extends android.support.v4.app.Fragment {
    Adap ad;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tabhome,container,false);
        ad=new Adap(getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPage);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager.setAdapter(ad);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
