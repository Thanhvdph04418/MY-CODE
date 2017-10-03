package repeatcode.fpt.canhhh.musicapp.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import repeatcode.fpt.canhhh.musicapp.ui.fragment.FragmentAlbum;
import repeatcode.fpt.canhhh.musicapp.ui.fragment.FragmentSinger;
import repeatcode.fpt.canhhh.musicapp.ui.fragment.FragmentSong;

// nếu dữ liệu dạng tĩnh thì mới dùng FragmentPagerAdapter
public class PagerAdapter extends FragmentStatePagerAdapter{
    private String[] tabTitles = new String[]{
            "Bài hát",
            "Album",
            "Nghệ sĩ"
    };

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentSong();
            case 1:
                return new FragmentAlbum();
            case 2:
                return new FragmentSinger();
        }
        return null;
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
