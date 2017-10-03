package demosum.fpt.canhhh.demosum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static demosum.fpt.canhhh.demosum.R.id.a;

public class MainActivity extends AppCompatActivity {
    Button btnsum;
    EditText eda , edb;
    TextView viewsum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        sum();
    }

    private void sum() {
        btnsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(eda.getText().toString());
                double b = Double.parseDouble(edb.getText().toString());
                double c= a+b;
                Intent i =new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("greetting",c);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }

    private void setUpView() {
        btnsum = (Button) findViewById(R.id.btnsum);
        eda = (EditText) findViewById(a);
        edb = (EditText) findViewById(R.id.b);
        viewsum = (TextView) findViewById(R.id.viewsum);
    }
}
