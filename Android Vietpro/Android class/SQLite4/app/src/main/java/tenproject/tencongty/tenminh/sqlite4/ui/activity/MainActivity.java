package tenproject.tencongty.tenminh.sqlite4.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite4.Model.Model;
import tenproject.tencongty.tenminh.sqlite4.R;
import tenproject.tencongty.tenminh.sqlite4.db.StudentDao;
import tenproject.tencongty.tenminh.sqlite4.ui.adapter.Adapter;

public class MainActivity extends AppCompatActivity {
    EditText edtID,edtAge,edtPoin;
    Button btnAdd;
    StudentDao dao;
    ListView lv;
    Adapter adapter;
    ArrayList<Model> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        attachListener();
    }

    public void attachListener(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int age =Integer.parseInt(edtAge.getText().toString()) ;
                    int id = Integer.parseInt(edtID.getText().toString());
                    int poin = Integer.parseInt(edtPoin.getText().toString());

                    Model model = new Model(id,age,poin);
                    if (dao.addData(model)){
                        Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        datas = dao.getData();

                        adapter = new Adapter(MainActivity.this,datas);
                        lv.setAdapter(adapter);
                        edtAge.setText("");
                        edtPoin.setText("");
                        edtID.setText("");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "thất bại rồi", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    public void setUpView(){
        edtPoin = (EditText)findViewById(R.id.edtPoin);
        edtID = (EditText)findViewById(R.id.edtID);
        edtAge = (EditText)findViewById(R.id.edtAge);
        lv = (ListView)findViewById(R.id.lvStudent);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        dao = new StudentDao(MainActivity.this);
        dao.open();
    }
}
