package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.R;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.model.StudentModel;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.fragment.FragmentDetail;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.fragment.FragmentMain;

public class MainActivity extends AppCompatActivity implements FragmentMain.Listener{
    private boolean flag = false; // potrait
// Activity chỉ có khả năng điều hướng
    // còn các nhiệm vụ và chức năng viết bên fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deteminePaneLayout();// sét xem máy ng dùng ngang hay dọc
    }
    private void deteminePaneLayout(){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            nextFragment(R.id.mylayout, new FragmentMain());
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.myDetail, FragmentDetail.newInstance("Nguyen Van A",23));
            ft.commit();
            flag = true;
        }
    }

    public void nextFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

    @Override
    public void handel(StudentModel st) {
        if(flag){
            // landscape
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.myDetail, FragmentDetail.newInstance(st.getName(),st.getAge()));
            ft.commit();
        }else {
            // potrait
            nextFragment(R.id.mylayout, FragmentDetail.newInstance(st.getName(), st.getAge()));
        }
    }
}
