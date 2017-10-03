package tenproject.tencongty.tenminh.broadcastreceivercoding.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tenproject.tencongty.tenminh.broadcastreceivercoding.R;
import tenproject.tencongty.tenminh.broadcastreceivercoding.ui.fragment.Homefragment;

public class MainActivity extends AppCompatActivity {
    // lắng nghe các tín hiệu từ hệ thống

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout, new Homefragment());
    }
    public void nextFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id,fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mylayout);
            if (fragment instanceof Homefragment) {
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
