package linearlayoutandroid.fpt.canhhh.studentmanager.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import linearlayoutandroid.fpt.canhhh.studentmanager.R;
import linearlayoutandroid.fpt.canhhh.studentmanager.db.StudentDao;
import linearlayoutandroid.fpt.canhhh.studentmanager.model.StudentModel;

public class MainActivity extends AppCompatActivity {
    private EditText txtName,txtAge;
    private Button btnAdd,btnShow;
    private StudentDao dao;
    // b1 : tạo lớp Molder (trong sglite có bn cột) ==> có bằng đấy thuộc tính
    // b2 : tạo một lớp thừa kế SQLiteOPenhelper(lớp nà chỉ có tác dụng tạo ra CSDL, tạo ra bảng, tạo cột)
    // b3 : tạo ra một lớp DAO (làm các chức năng tương tác với DB như thêm, lấy, sửa , xóa)
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
                StudentModel st = new StudentModel(age, name);
                if(dao.addData(st) == true)
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                txtName.setText("");
                txtAge.setText("");
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.close();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpView(){
        txtName = (EditText) findViewById(R.id.txtName);
        txtAge = (EditText) findViewById(R.id.txtAge);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnShow = (Button) findViewById(R.id.btnShow);
        dao = new StudentDao(MainActivity.this);
        dao.open();
    }
}
