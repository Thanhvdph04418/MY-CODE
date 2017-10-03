package tenproject.tencongty.tenminh.assignment1.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import tenproject.tencongty.tenminh.assignment1.R;
import tenproject.tencongty.tenminh.assignment1.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout, new HomeFragment());
        Log.d(TAG, "onCreate: started");

    }

    public void nextFragment(int id , Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
        Log.d(TAG, "nextFragment: started");
    }

    @Override
    public void onBackPressed() {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mylayout);
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
