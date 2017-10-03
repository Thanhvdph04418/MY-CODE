package linearlayoutandroid.fpt.canhhh.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeconActivity extends AppCompatActivity {
    private TextView best;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        setUpView();
        attachListener();
    }

    private void attachListener(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SeconActivity.this,MainActivity.class);
                in.putExtra("perfect","i good man");
                setResult(RESULT_OK,in);
                finish();
            }
        });
    }

    private void setUpView(){
        btnBack = (Button) findViewById(R.id.btnBack);
        best = (TextView) findViewById(R.id.txtWife);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        best.setText(name);
    }
}
