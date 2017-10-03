package repeatcode.fpt.canhhh.viewpagerandroid.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import repeatcode.fpt.canhhh.viewpagerandroid.ui.fragment.FragmentConten;

/**
 * Created by canhh on 18/07/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            // trang đếm từ số 0
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
    public int getCount() {// trả về số trang ở trong slideshow(viewpager)
        return 3;
    }
}
