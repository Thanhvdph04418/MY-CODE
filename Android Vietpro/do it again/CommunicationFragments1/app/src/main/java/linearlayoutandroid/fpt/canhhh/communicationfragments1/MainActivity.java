package linearlayoutandroid.fpt.canhhh.communicationfragments1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentActivity.listener {
    private FragmentManager fm;
    private FragmentTransaction ft;
    private FragmentActivity fragmentActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void setUpView(){
        fm = getSupportFragmentManager();
        FragmentActivity fragmentActivity = (FragmentActivity) fm.findFragmentById(R.id.mainFragment);
        fragmentActivity.doSomething();
    }

    @Override
    public void handle() {
        fragmentActivity.changeTexṭ̣̣("hello java");
    }
}
