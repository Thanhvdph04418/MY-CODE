package linearlayoutandroid.fpt.canhhh.creatingandusingfragmant.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import linearlayoutandroid.fpt.canhhh.creatingandusingfragmant.R;
import linearlayoutandroid.fpt.canhhh.creatingandusingfragmant.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    // b1 : tạo giao diện cho fragment
    // b2 : tạo một class tương ứng với giao diện
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();

        }
        private void setUpView(){
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.myLayout,new MainFragment());
            ft.commit(); // cam ket
        }
    }

