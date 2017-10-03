package displayingimageswiththepicasso.fpt.canhhh.displayingimageswiththepicasso.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import displayingimageswiththepicasso.fpt.canhhh.displayingimageswiththepicasso.R;
import displayingimageswiththepicasso.fpt.canhhh.displayingimageswiththepicasso.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout,new MainFragment());
    }

    public void nextFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id,fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.addToBackStack(name);
        ft.commit();
    }
}
