package linearlayoutandroid.fpt.canhhh.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText name, age,mark;
    private Button add,show;
    private ArrayList<Student> data;
    public static final int REQUEST_CODE = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        attachListener();
    }

    private void attachListener(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                int tuoi = Integer.parseInt(age.getText().toString());
                int diem = Integer.parseInt(mark.getText().toString());
                Student st = new Student(ten,tuoi,diem);
                data.add(st);
                name.setText("");
                age.setText("");
                mark.setText("");
                Toast.makeText(MainActivity.this, ten, Toast.LENGTH_SHORT).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stMax = data.get(0);
                for (int i=0;i< data.size();i++){
                    if (data.get(i).getMark()> stMax.getMark())
                        stMax = data.get(i);
                }
                Intent i = new Intent(MainActivity.this, SeconActivity.class);
                i.putExtra("name",stMax.getName());
                startActivity(i);
            }
        });
    }

    private void setUpView(){
        name = (EditText) findViewById(R.id.txtName);
        age = (EditText) findViewById(R.id.txtAge);
        mark = (EditText) findViewById(R.id.txtMark);
        add = (Button) findViewById(R.id.btnAdd);
        show = (Button) findViewById(R.id.btnShow);
        data= new ArrayList<>();
    }

        }