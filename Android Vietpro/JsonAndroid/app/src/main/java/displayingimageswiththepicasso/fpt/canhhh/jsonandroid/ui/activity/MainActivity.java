package displayingimageswiththepicasso.fpt.canhhh.jsonandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.R;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.ui.fragment.MainFragment;

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
        ft.commit();
    }
}
