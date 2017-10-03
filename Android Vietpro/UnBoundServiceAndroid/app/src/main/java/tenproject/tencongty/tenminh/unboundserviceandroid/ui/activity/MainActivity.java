package tenproject.tencongty.tenminh.unboundserviceandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tenproject.tencongty.tenminh.unboundserviceandroid.R;
import tenproject.tencongty.tenminh.unboundserviceandroid.ui.controller.Callback;
import tenproject.tencongty.tenminh.unboundserviceandroid.ui.fragment.HomeFragment;
import tenproject.tencongty.tenminh.unboundserviceandroid.ui.service.MyService;

public class MainActivity extends AppCompatActivity implements Callback {

    private Intent i = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout, new HomeFragment());
    }
    public void nextFragment(int id, Fragment fragment) {
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
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mylayout);
            if (fragment instanceof HomeFragment) {
                super.onBackPressed();
                System.exit(0);
            } else {
                super.onBackPressed();
                System.exit(0);
            }
        } catch (Exception e) {
            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public void playSong() {
        i = new Intent(this, MyService.class);
        startService(i);
    }

    @Override
    public void stopSong() {
        if (i != null){
            stopService(i);
        }
    }
}
