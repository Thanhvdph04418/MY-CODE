package tenproject.tencongty.tenminh.sqlite3.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite3.R;
import tenproject.tencongty.tenminh.sqlite3.db.StudentDao;
import tenproject.tencongty.tenminh.sqlite3.model.Model;
import tenproject.tencongty.tenminh.sqlite3.ui.adapter.Adapter;

public class MainActivity extends AppCompatActivity {
    EditText edtAge,edtPoin,edtID;
    Button btnAdd;
    ListView lvSV;
    StudentDao dao;
    Adapter adapter;
    ArrayList<Model> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpview();
        attachEvent();
    }

    public void attachEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                int poin = Integer.parseInt(edtPoin.getText().toString());

                Model md = new Model(age,poin,id);
                if (dao.addData(md)){
                    Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();

                    datas = dao.getData();
                    adapter = new Adapter(MainActivity.this,datas);
                    lvSV.setAdapter(adapter);
                    edtAge.setText("");
                    edtID.setText("");
                    edtPoin.setText("");
                }
            }
        });
    }
    public void setUpview(){
        edtPoin = (EditText)findViewById(R.id.edtPoin);
        edtAge = (EditText)findViewById(R.id.edtAge);
        edtID = (EditText)findViewById(R.id.edtID);
        lvSV = (ListView)findViewById(R.id.lvSV);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        dao = new StudentDao(MainActivity.this);
        dao.open();
    }
}
