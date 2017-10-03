package linearlayoutandroid.fpt.canhhh.intenandroi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeconActivitive extends AppCompatActivity {
    private Button btnBack;
    private TextView txtResulf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon_activitive);
        setUpView();
        attachListenner();
    }
    private void attachListenner(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SeconActivitive.this,MainActivity.class);
                in.putExtra("greettingIOS","Hello IOS");
                setResult(RESULT_OK,in);
                finish();
            }
        });
    }
    private void setUpView(){
        btnBack = (Button) findViewById(R.id.btnBack);
        txtResulf = (TextView) findViewById(R.id.txtResulf);
        Intent i1 = getIntent();
        //nhận intent ở bên kia truyền sang
        String data = i1.getStringExtra("greetting");
        txtResulf.setText(data);
    }
}
