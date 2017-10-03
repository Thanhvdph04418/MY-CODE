package linearlayoutandroid.fpt.canhhh.communicationfragments.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import linearlayoutandroid.fpt.canhhh.communicationfragments.R;
import linearlayoutandroid.fpt.canhhh.communicationfragments.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.listener {
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MainFragment mainFragment;
// ui vieets tat cua tu uses interface( giao dien ng dung)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }
    private void setUpView(){
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        MainFragment mainFragment = MainFragment.newInstance("Some Title");
//        ft.replace(R.id.myLayout, mainFragment);
//        ft.commit();
        fm = getSupportFragmentManager();
        mainFragment = (MainFragment) fm.findFragmentById(R.id.mainFragment);
        mainFragment.doSomething();
    }

    @Override
    public void handle() {
        mainFragment.changeText("Hello Java");
    }


}
