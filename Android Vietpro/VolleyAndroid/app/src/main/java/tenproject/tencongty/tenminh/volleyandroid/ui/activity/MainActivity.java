package tenproject.tencongty.tenminh.volleyandroid.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tenproject.tencongty.tenminh.volleyandroid.R;
import tenproject.tencongty.tenminh.volleyandroid.ui.fragment.LoadJsonFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout, new LoadJsonFragment());
    }

    public void nextFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(name);
        ft.commit();
    }
}
