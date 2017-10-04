package vdt.test.haha;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class Adap extends FragmentPagerAdapter {
    private  String[] tagTitles =new String[]{// mảng phải là ngoặc vuông
            "Tadb1",
            "Tadb2",
            "tabd3",
            "tabd4",
            "tabd5",
            "tabd6"

    };
    public Adap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new  tab1();
            case 1:
                return new  tab2();
            case 2:
                return new  tab3();
            case 3:
                return new  tab4();
            case 4:
                return new  tab5();
            case 5:
                return new  tab6();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tagTitles[position] ;
    }
}
