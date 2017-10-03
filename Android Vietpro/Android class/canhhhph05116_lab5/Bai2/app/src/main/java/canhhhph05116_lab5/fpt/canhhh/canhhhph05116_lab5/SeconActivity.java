package canhhhph05116_lab5.fpt.canhhh.canhhhph05116_lab5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeconActivity extends AppCompatActivity {
    private TextView txtKQ;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        btnBack = (Button)findViewById(R.id.btnBack);
        txtKQ = (TextView)findViewById(R.id.txtKQ);

        Double data = getIntent().getDoubleExtra("sum", 0 );
        txtKQ.setText(String.valueOf(data));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeconActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
