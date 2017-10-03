package linearlayoutandroid.fpt.canhhh.custumalertdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // b1 : tự thiết kế giao diện
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCustomdialog(View view) {
        View v ;
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        v = inflater.inflate(R.layout.custom_dialog,null);
        final Dialog dialog = new Dialog(MainActivity.this);
        Button btnLogin = (Button)v.findViewById(R.id.btnLogin);
        dialog.setContentView(v);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
