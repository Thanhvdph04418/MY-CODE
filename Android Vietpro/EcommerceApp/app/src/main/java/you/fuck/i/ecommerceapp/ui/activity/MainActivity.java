package you.fuck.i.ecommerceapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.ui.fragment.DetailProductFragment;
import you.fuck.i.ecommerceapp.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout, new MainFragment());

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
            if (fragment instanceof MainFragment) {
                super.onBackPressed();
                System.exit(0);
            } else if (fragment instanceof DetailProductFragment){
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
