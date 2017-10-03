package repeatcode.fpt.canhhh.tablayoutandroid.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import repeatcode.fpt.canhhh.tablayoutandroid.ui.fragment.FragmentConten;

/**
 * Created by canhh on 18/07/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private  String[] tagTitles =new String[]{// mảng phải là ngoặc vuông
        "Tab1",
        "Tab2",
        "Tab3",
    };

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragmentConten.newInstance(position +1);
            case 1:
                return FragmentConten.newInstance(position +1);
            case 2:
                return FragmentConten.newInstance(position +1);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    // tra ve tieu de cho tung tab tab1, tab2, tab3
    @Override
    public CharSequence getPageTitle(int position) {
        return tagTitles[position];
    }
}
