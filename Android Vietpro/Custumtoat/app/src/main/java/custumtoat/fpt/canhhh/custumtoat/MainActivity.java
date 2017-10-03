package custumtoat.fpt.canhhh.custumtoat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //b1: tự thiết kế giao diện do chính mình tự định nghia
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        Toast t = new Toast(MainActivity.this);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v = inflater.inflate(R.layout.custum_toast,null);
        t.setView(v);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}
