package linearlayoutandroid.fpt.canhhh.communicationfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by canhh on 12/07/2017.
 */

public class FragmentMain extends Fragment {
    private TextView txt;
    private Button btn;
    public interface listener{
        public void handle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    public static FragmentMain newInstance(String title){
        FragmentMain fragmentMain = new FragmentMain();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragmentMain.setArguments(args);
        return fragmentMain;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt = (TextView) view.findViewById(R.id.txt);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ((listener) getActivity()).handle();
            }
        });
    }
    public void doSomething(){
        Toast.makeText(getActivity(), " toi dep trai", Toast.LENGTH_SHORT).show();
    }
    public void changText(String test){
        txt.setText(test);
    }
}
