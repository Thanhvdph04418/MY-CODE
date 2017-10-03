package linearlayoutandroid.fpt.canhhh.buttonknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.btn)
    Button btn;
    @BindString(R.string.greeting)
    String greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn)
    public void doSomething(){
        txt.setText(greeting);
    }
}
