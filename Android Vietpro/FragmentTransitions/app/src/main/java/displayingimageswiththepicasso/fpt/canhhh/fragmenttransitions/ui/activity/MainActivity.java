package displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.R;
import displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.ui.fragment.FragmentA;
import displayingimageswiththepicasso.fpt.canhhh.fragmenttransitions.ui.fragment.FragmentB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout,new FragmentA(),0,0,0,0);
    }

    public void nextFragment(int id, Fragment fragment,int anim1,int anim2, int anim3, int anim4){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(anim1,anim2,anim3,anim4);
        ft.replace(id,fragment);
        ft.addToBackStack(name);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        try{
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mylayout);
            if (fragment instanceof FragmentA){
                super.onBackPressed();
                System.exit(0);
            }else if(fragment instanceof FragmentB){
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }catch(Exception e){
            super.onBackPressed();
            System.exit(0);
        }
    }
}
