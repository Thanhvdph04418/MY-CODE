package canhhhph05116_lab5.fpt.canhhh.canhhhph05116_bai3lab5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edittext1;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1=(EditText)findViewById(R.id.edittext1);
        button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String number=edittext1.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }

        });
    }

    }

