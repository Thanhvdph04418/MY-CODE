package linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.R;
import linearlayoutandroid.fpt.canhhh.androidfragmentbackstack.ui.fragment.Fragment_A;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(new Fragment_A(),R.id.myLayout);
    }

    public void nextFragment(Fragment fragment, int id){
        String name = fragment.getClass().getName();
        fm = getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
