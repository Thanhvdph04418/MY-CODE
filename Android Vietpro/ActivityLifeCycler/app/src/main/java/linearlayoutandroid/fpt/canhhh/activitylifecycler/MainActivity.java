package linearlayoutandroid.fpt.canhhh.activitylifecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test", "onStar Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test", "onResume Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test", "onPause Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test", "onStop Started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test", "onDestroy Started");
    }
}
