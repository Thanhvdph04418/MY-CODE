package linearlayoutandroid.fpt.canhhh.communicationfragments.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import linearlayoutandroid.fpt.canhhh.communicationfragments.R;

/**
 * Created by canhh on 11/07/2017.
 */
// Bundles
// call method  in Fragment
// Communicate width parent activity by using interface
public class MainFragment extends Fragment {
    private TextView txtName;
    private Button btnB;
    public interface listener {//tai sao lai phai ke thua interface
        public void handle();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public static MainFragment newInstance(String title){// hàm này tạo ra để làm cái gì?
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        mainFragment.setArguments(args);
        return mainFragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {// hàm này đc tạo ra để ánh xạ như hàm setUpView bên lớp Activity
        super.onViewCreated(view, savedInstanceState);
        txtName =(TextView) view.findViewById(R.id.txtName);
        btnB = (Button) view.findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((listener) getActivity()).handle();
            }
        });
    }

    public void doSomething(){
        Toast.makeText(getActivity(), "Hello , I am your fragment", Toast.LENGTH_SHORT).show();
    }
    public void changeText(String text){
        txtName.setText(text);
    }
}
