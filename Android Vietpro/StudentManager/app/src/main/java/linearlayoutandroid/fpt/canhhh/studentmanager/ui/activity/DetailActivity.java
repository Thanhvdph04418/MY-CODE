package linearlayoutandroid.fpt.canhhh.studentmanager.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.studentmanager.R;
import linearlayoutandroid.fpt.canhhh.studentmanager.db.StudentDao;
import linearlayoutandroid.fpt.canhhh.studentmanager.model.StudentModel;
import linearlayoutandroid.fpt.canhhh.studentmanager.ui.adapter.StudentAdapter;

public class DetailActivity extends AppCompatActivity {
    private ListView lvName;
    private ArrayList<StudentModel> data;
    private StudentAdapter adapter;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUpView();
        attachListeners();
    }

    private void attachListeners(){
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentModel st = data.get(position);
                data.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpView(){
        lvName = (ListView) findViewById(R.id.lvName);
        data = new ArrayList<>();
        studentDao = new StudentDao(DetailActivity.this);
        studentDao.open();
        data = studentDao.getData();
        adapter = new StudentAdapter(DetailActivity.this,data);
        lvName.setAdapter(adapter);
    }


}
