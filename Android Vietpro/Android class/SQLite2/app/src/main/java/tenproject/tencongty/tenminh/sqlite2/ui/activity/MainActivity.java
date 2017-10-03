package tenproject.tencongty.tenminh.sqlite2.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.sqlite2.R;
import tenproject.tencongty.tenminh.sqlite2.db.StudentDao;
import tenproject.tencongty.tenminh.sqlite2.model.ModelSSV;
import tenproject.tencongty.tenminh.sqlite2.ui.adapter.AdapterSV;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText edtName, edtAge;
    private ListView lvStudent;
    private StudentDao dao;
    private AdapterSV adapterSV;
    private ArrayList<ModelSSV> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpview();
        atachListener();
    }
    public void atachListener(){
        btnAdd.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = edtName.getText().toString();
                    int age =Integer.parseInt(edtAge.getText().toString());

                    ModelSSV modelSSV = new ModelSSV(name,age);
                    if (dao.addData(modelSSV)){
                        Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();

                        datas = dao.getData();

                        adapterSV = new AdapterSV(MainActivity.this,datas);
                        lvStudent.setAdapter(adapterSV);
                        edtAge.setText("");
                        edtName.setText("");

                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "them khong thanh cong", Toast.LENGTH_SHORT).show();
                    Log.d("err","Lỗi rồi bạn ơi");
                }
            }
        });

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelSSV md = datas.get(position);

                dao.delete(md.getId());
                datas.remove(position);
                adapterSV.notifyDataSetChanged();
            }
        });
    }
    private void setUpview(){
        btnAdd = (Button)findViewById(R.id.btnAdd);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtName = (EditText) findViewById(R.id.edtName);
        lvStudent = (ListView)findViewById(R.id.lvSV);
        dao = new StudentDao(MainActivity.this);
        dao.open();
    }
}
