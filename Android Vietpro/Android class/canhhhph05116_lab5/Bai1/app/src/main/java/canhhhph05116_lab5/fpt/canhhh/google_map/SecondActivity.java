package canhhhph05116_lab5.fpt.canhhh.google_map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button btncon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btncon = (Button)findViewById(R.id.btncon);
        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}
