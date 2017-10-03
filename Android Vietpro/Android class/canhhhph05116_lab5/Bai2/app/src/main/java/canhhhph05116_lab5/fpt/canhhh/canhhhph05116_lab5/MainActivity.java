package canhhhph05116_lab5.fpt.canhhh.canhhhph05116_lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txt1,txt2;
    private Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (EditText)findViewById(R.id.txt1);
        txt2 = (EditText)findViewById(R.id.txt2);
        btnSum =(Button) findViewById(R.id.btnsum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a =Double.parseDouble(txt1.getText().toString());
                double b =Double.parseDouble(txt2.getText().toString());
                Intent i = new Intent(MainActivity.this, SeconActivity.class);
                i.putExtra("sum", (a+b)/2);
                startActivity(i);
            }
        });
    }
}
