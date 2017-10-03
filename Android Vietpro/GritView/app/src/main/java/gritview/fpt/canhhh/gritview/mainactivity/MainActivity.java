package gritview.fpt.canhhh.gritview.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import gritview.fpt.canhhh.gritview.R;
import gritview.fpt.canhhh.gritview.adapter.MyAdapter;
import gritview.fpt.canhhh.gritview.model.MyModel;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private ImageView im;
    private ArrayList<MyModel> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }
    private void setUpView(){
        gv =(GridView) findViewById(R.id.gv);
        data = new ArrayList<>();
        initdata();
        MyAdapter adapter = new MyAdapter(MainActivity.this,data);
        gv.setAdapter(adapter);
    }
    private void initdata(){
        data.add(new MyModel(R.drawable.a,"A"));
        data.add(new MyModel(R.drawable.b,"A"));
        data.add(new MyModel(R.drawable.c,"A"));
        data.add(new MyModel(R.drawable.d,"A"));
        data.add(new MyModel(R.drawable.e,"A"));
        data.add(new MyModel(R.drawable.f,"A"));
    }
}
