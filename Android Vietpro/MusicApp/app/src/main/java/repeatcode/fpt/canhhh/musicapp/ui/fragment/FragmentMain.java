package repeatcode.fpt.canhhh.musicapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import repeatcode.fpt.canhhh.musicapp.R;
import repeatcode.fpt.canhhh.musicapp.ui.adapter.PagerAdapter;

/**
 * Created by canhh on 19/07/2017.
 */

public class FragmentMain extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPage);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
