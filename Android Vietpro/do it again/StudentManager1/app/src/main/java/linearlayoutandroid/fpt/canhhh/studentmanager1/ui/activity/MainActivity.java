package linearlayoutandroid.fpt.canhhh.studentmanager1.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import linearlayoutandroid.fpt.canhhh.studentmanager1.R;

public class MainActivity extends AppCompatActivity {
    private TextView name,age;
    private Button add, show;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
