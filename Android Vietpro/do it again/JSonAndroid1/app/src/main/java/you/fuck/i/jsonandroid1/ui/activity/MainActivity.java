package you.fuck.i.jsonandroid1.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import you.fuck.i.jsonandroid1.R;
import you.fuck.i.jsonandroid1.ui.fragment.FragmentMain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragmenṭ(R.id.mylayout,new FragmentMain());
    }

    public void nextFragmenṭ(int id, Fragment fragment){
        String name = fragment.getClass().getName();// ?
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id,fragment);
        ft.addToBackStack(name);
        ft.commit();
    }
}
