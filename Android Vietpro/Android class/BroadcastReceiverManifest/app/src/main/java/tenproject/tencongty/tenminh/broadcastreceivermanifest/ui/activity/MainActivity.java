package tenproject.tencongty.tenminh.broadcastreceivermanifest.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tenproject.tencongty.tenminh.broadcastreceivermanifest.R;
import tenproject.tencongty.tenminh.broadcastreceivermanifest.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bd = getIntent().getExtras();
        if (bd != null){
            String content = bd.getString("content","");
            nextFragment(R.id.mylayout, HomeFragment.newInstance(content));
        }else {
            nextFragment(R.id.mylayout, new HomeFragment());
        }
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
            Fragment fragment =getSupportFragmentManager().findFragmentById(R.id.mylayout);
                if (fragment instanceof HomeFragment){
                    super.onBackPressed();
                    System.exit(0);
                }else {
                    super.onBackPressed();
                    System.exit(0);
                }
        }catch (Exception e){
            super.onBackPressed();
            System.exit(0);

        }
    }
}
