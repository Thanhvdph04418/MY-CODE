package linearlayoutandroid.fpt.canhhh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setUpView();
    }
    private void setUpView(){
        txtName = (TextView) findViewById(R.id.result);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        txtName.setText(name);
    }
}
