package linearlayoutandroid.fpt.canhhh.intenandroi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnshow;
    private TextView txtMain_Resulf;
    public static final int REQUEST_CODE =30; // hằng số

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        attachListener();
    }

    private void attachListener(){
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SeconActivitive.class);
                i.putExtra("greetting"," Hello Wolverine");
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }

    private void setUpView(){
        btnshow = (Button) findViewById(R.id.btnShow);
        txtMain_Resulf = (TextView) findViewById(R.id.txtMain_Resulf);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if (requestCode ==REQUEST_CODE && resultCode == RESULT_OK){
            String helloIOS = data.getStringExtra("greettingIOS");
            txtMain_Resulf.setText(helloIOS);
        }

    }
}
