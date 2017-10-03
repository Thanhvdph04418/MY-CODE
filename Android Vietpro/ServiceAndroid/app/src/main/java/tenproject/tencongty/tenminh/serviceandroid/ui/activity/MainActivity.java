package tenproject.tencongty.tenminh.serviceandroid.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tenproject.tencongty.tenminh.serviceandroid.R;
import tenproject.tencongty.tenminh.serviceandroid.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.mylayout, new HomeFragment());

        // service (dich vu) : giúp chúng ta thực thi các công việc nào đấy
        // kể cả khi ap không bật mà vẫn chạy ngầm

        // service : không cần giao diện

        // service : sẽ dừng khi làm xong việc or bị dừng đột ngột bởi người dùng

        // BoundService( thấy được quá trình nó làm việc )
        // UnBoundService(không quan tâm đến quá trình or quá trình nó làm thế nào )
        // bước 1 : tạo javaClass thừa kế service


    }
    public void nextFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mylayout);
            if (fragment instanceof HomeFragment) {
                super.onBackPressed();
                System.exit(0);
            } else {
                super.onBackPressed();
                System.exit(0);
            }
        } catch (Exception e) {
            super.onBackPressed();
            System.exit(0);
        }
    }
}
