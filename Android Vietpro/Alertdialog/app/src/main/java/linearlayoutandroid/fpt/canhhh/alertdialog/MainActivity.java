package linearlayoutandroid.fpt.canhhh.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button show_alert_dialog;
    private Button show_alert_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        Show_alert_dialog();
        Show_alert_list();
    }

    
    private  void Show_alert_dialog(){
        show_alert_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }


    private void Show_alert_list(){
        show_alert_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertList();
            }
        });
    }


    private void showAlertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("chúc mừng bạn !");
        dialog.setMessage("bạn đã trúng một triệu !!!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "bạn đã bị lừa ", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "bạn rất tỉnh", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.create().show();
    }


    private void showAlertList(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Vietpro Courses");
        final String[] data = new String[]{"php","Android","Photoshop","worpress","ios"};
        dialog.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, data[which], Toast.LENGTH_SHORT).show();
            }
        });
        dialog.create().show();
    }

    private void setUpView(){
        show_alert_dialog = (Button) findViewById(R.id.show_normal_alert_dialog);
        show_alert_list = (Button) findViewById(R.id.show_normal_alert_list);
    }
}
