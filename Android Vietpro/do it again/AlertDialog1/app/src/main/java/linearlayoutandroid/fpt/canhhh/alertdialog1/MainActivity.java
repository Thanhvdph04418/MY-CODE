package linearlayoutandroid.fpt.canhhh.alertdialog1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button diaLog,list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        attachListener();
        attachListenlist();
    }
    private void attachListener(){
        diaLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void attachListenlist(){
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertList();
            }
        });
    }

    private void showAlertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Hello Wolverine");
        dialog.setMessage("thật tuyệt vời !!!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "bạn đã là người hạnh phúc nhất khi có một cô vợ thật tuyệt vời", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "bạn làm tôi thật thất vọng !!!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.create().show();
    }

    private void showAlertList(){
        AlertDialog.Builder list = new AlertDialog.Builder(MainActivity.this);
        list.setTitle("danh sách những cô vợ tương lai của bạn đây !!");

        final String[] data = new String[]{"Nguyễn Xuân Thúy", "Trương Tuyết Nghêng", " wonder woman","An Duyệt Khuê"};
        list.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, data[which], Toast.LENGTH_SHORT).show();
            }
        });
        list.create().show();
    }

    private void setUpView(){
        diaLog = (Button)findViewById(R.id.btnDialog);
        list = (Button) findViewById(R.id.btnList);
    }
}
