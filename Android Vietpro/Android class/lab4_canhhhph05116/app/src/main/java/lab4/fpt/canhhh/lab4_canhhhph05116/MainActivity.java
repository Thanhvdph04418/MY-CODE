package lab4.fpt.canhhh.lab4_canhhhph05116;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_DiemLab){
            AlertDialog.Builder dgLab = new AlertDialog.Builder(MainActivity.this);
            dgLab.setTitle("Xem diem LAB");
            final String[] all = new String[]{"Lab 1","Lab 2","Lab 3","Lab 4"};
            dgLab.setItems(all, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Bạn đã chọn "+all[i], Toast.LENGTH_SHORT).show();
                }
            });
            dgLab.create().show();
        }
        if (item.getItemId() == R.id.action_DiemQuiz){
            AlertDialog.Builder dgLab = new AlertDialog.Builder(MainActivity.this);
            dgLab.setTitle("Xem diem Quiz");
            final String[] all = new String[]{"Quiz 1","Quiz 2","Quiz 3","Quiz 4"};
            dgLab.setItems(all, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"Ban da chon " +all[i],Toast.LENGTH_SHORT).show();
                }
            });
            dgLab.create().show();
        }
        return super.onOptionsItemSelected(item);
    }
}
