package you.fuck.i.ecommerceapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.ui.adapter.MyPagerAdapter;


public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
