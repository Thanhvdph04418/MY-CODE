package custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.activiti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.R;
import custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.adapter.StudenAdapter;
import custumlistviewusingadapter.fpt.canhhh.custumlistviewusingadapter.model.Studen;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Studen> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }
    private void setUpView(){
    lv = (ListView)findViewById(R.id.lv);
        data = new ArrayList<>();
        initdata();
        StudenAdapter adapter = new StudenAdapter(MainActivity.this,data);
        lv.setAdapter(adapter);
    }
    private void initdata(){
        data.add(new Studen("hoang",18));
        data.add(new Studen("huu",19));
        data.add(new Studen("canh",16));
    }
}
