package repeatcode.fpt.canhhh.viewpagerandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import repeatcode.fpt.canhhh.viewpagerandroid.R;
import repeatcode.fpt.canhhh.viewpagerandroid.ui.fragment.FragmentMain;

public class MainActivity extends AppCompatActivity {
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout,new FragmentMain());
    }
    public void nextFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id,fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }
}
