package linearlayoutandroid.fpt.canhhh.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.project.model.Student;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtAge,txtEmail;
    private Button btnAdd,btnShow;
    private ArrayList<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        attachListeners();
    }
    private void attachListeners(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                int age = Integer.parseInt(txtAge.getText().toString());
                int mark = Integer.parseInt(txtAge.getText().toString());
                Student st = new Student(name,age,mark);
                data.add(st);
                txtName.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stMax = data.get(0);// thuật toán đặt lính canh
                for(int i =0 ; i< data.size(); i++){
                    if(data.get(i).getMark()>stMax.getMark()) stMax=data.get(i);
                }
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("name",stMax.getName());
                startActivity(i);
            }
        });
    }


    private void setUpView(){
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnShow = (Button) findViewById(R.id.btnShow);
        data = new ArrayList<>();
    }
}
