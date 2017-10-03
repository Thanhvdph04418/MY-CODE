package you.fuck.i.ecommerceapp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import you.fuck.i.ecommerceapp.ui.fragment.FeaturesFragment;
import you.fuck.i.ecommerceapp.ui.fragment.FragmentCart;
import you.fuck.i.ecommerceapp.ui.fragment.ProductFragment;


public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private String tabTitles[]= {
            "Product",
            "Features",
            "Cart"
    };

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProductFragment();
            case 1:
                return new FeaturesFragment();
            case 2:
                return new FragmentCart();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
