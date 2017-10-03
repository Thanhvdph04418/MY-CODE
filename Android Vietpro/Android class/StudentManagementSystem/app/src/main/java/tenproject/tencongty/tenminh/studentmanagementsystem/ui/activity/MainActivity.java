package tenproject.tencongty.tenminh.studentmanagementsystem.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tenproject.tencongty.tenminh.studentmanagementsystem.R;
import tenproject.tencongty.tenminh.studentmanagementsystem.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        nextFragment(R.id.myLayout, new HomeFragment());
    }

    public void nextFragment(int id , Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
            if (fragment instanceof HomeFragment) {
                super.onBackPressed();
                System.exit(0);
            } else {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        } catch (Exception e) {
            super.onBackPressed();
            System.exit(0);
        }
    }
}
