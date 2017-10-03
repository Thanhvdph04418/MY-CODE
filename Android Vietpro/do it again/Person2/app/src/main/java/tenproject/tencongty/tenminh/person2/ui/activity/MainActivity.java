package tenproject.tencongty.tenminh.person2.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tenproject.tencongty.tenminh.person2.R;
import tenproject.tencongty.tenminh.person2.ui.fragment.HomeFragmet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bd = getIntent().getExtras();
        if (bd != null){
            String message = bd.getString("message","");
            nextFragment(R.id.mylayout, HomeFragmet.newIntanst(message));
        }else {
            nextFragment(R.id.mylayout, new HomeFragmet());
        }
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
            if (fragment instanceof HomeFragmet) {
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
}
