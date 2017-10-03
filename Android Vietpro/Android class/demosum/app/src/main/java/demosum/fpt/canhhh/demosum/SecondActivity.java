package demosum.fpt.canhhh.demosum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button btnBack;
    private TextView txtKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnBack = (Button)findViewById(R.id.btnBack);
        txtKQ = (TextView)findViewById(R.id.txtKQ);
        Intent i = getIntent();
        String data = i.getStringExtra("greetting");
        txtKQ.setText(data);
    }
}
