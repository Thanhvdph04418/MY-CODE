package repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import repeatcode.fpt.canhhh.communicatebetweentwofragments2.R;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.model.StudentModel;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.fragment.FragmentMain;

public class MainActivity extends AppCompatActivity implements FragmentMain.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void deteminePaneLayout(){
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            nextFragment(R.id.myLayout,new FragmentMain());
        }
    }
    private void nextFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

    @Override
    public void handel(StudentModel st) {

    }
}
