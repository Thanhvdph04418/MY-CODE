package linearlayoutandroid.fpt.canhhh.communicationfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  FragmentMain.listener{
    private FragmentManager fm;
    private FragmentTransaction ft;
    private FragmentMain fragmentMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }
    private void setUpView(){
        fm = getSupportFragmentManager();
        fragmentMain = (FragmentMain) fm.findFragmentById(R.id.mainFragment);
        fragmentMain.doSomething();
    }

    @Override
    public void handle() {
        fragmentMain.changText("Hello Java");
    }
}
