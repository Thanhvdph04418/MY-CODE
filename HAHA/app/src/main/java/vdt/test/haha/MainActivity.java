package vdt.test.haha;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    nextFragment2(R.id.content,new tab2());


                    return true;
                case R.id.navigation_dashboard:
                    nextFragment(R.id.content, new FragControl());
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nextFragment(R.id.content, new FragControl());
        setContentView(R.layout.activity_main);


        android.app.FragmentManager fragmentManager= getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void nextFragment(int content, FragControl fragControl) {
        String name = fragControl.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(content,fragControl);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

    private void nextFragment2(int content, tab2 fragControl) {
        String name = fragControl.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(content,fragControl);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

}
