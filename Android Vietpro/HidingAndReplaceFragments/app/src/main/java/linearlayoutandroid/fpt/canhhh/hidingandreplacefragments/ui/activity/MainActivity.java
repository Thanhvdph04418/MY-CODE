package linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.R;
import linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.ui.fragment.FragmentA;
import linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.ui.fragment.FragmentB;
import linearlayoutandroid.fpt.canhhh.hidingandreplacefragments.ui.fragment.FragmentC;

public class MainActivity extends AppCompatActivity {
    private Button btnA,btnB,btnC;
    private FragmentManager fm;
    private FragmentC fragmentC;
    private FragmentB fragmentB;
    private FragmentA fragmentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setUpEvents();
    }

    private void setUpEvents(){
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragmentA();
            }

        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragmentB();

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragmentC();
            }
        });
    }

    private void displayFragmentC() {
        FragmentTransaction ft = fm.beginTransaction();
        if (fragmentA.isAdded()){
            ft.hide(fragmentA);
        }
        if (fragmentB.isAdded()){
            ft.hide(fragmentB);
        }
        if (fragmentC.isAdded()){
            ft.show(fragmentC);
        }else {
            ft.replace(R.id.myFragments,fragmentC);
        }

        ft.commit();
    }

    private void displayFragmentB() {
        FragmentTransaction ft = fm.beginTransaction();
        if (fragmentA.isAdded()){
            ft.hide(fragmentA);
        }
        if(fragmentC.isAdded()){
            ft.hide(fragmentC);
        }
        if (fragmentB.isAdded()){
            ft.show(fragmentB);
        }
        else {
            ft.replace(R.id.myFragments,fragmentB);
        }

        ft.commit();
    }

    private void displayFragmentA() {
        FragmentTransaction ft = fm.beginTransaction();
        if(fragmentB.isAdded()){
            ft.hide(fragmentB);
        }
        if (fragmentC.isAdded()){
            ft.hide(fragmentC);
        if(fragmentA.isAdded()){
            ft.show(fragmentA);
        } else {
            ft.replace(R.id.myFragments,fragmentA);
        }

        }
        ft.commit();
    }

    private void setUpView(){
        btnA =(Button) findViewById(R.id.btnFA);
        btnB =(Button) findViewById(R.id.btnFB);
        btnC =(Button) findViewById(R.id.btnFC);
        fm = getSupportFragmentManager();
        fragmentA= FragmentA.newInstance("fragmentA");
        fragmentB= FragmentB.newInstance("fragmentB");
        fragmentC = FragmentC.newInstance("fragmentC");
    }
}
