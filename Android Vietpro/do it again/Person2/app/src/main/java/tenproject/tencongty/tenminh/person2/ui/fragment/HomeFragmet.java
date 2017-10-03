package tenproject.tencongty.tenminh.person2.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tenproject.tencongty.tenminh.person2.R;
import tenproject.tencongty.tenminh.person2.common.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragmet extends Fragment {


    public HomeFragmet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragmet, container, false);
    }
    public static HomeFragmet newIntanst(String message){
        HomeFragmet homeFragmet = new HomeFragmet();
        Bundle bd = new Bundle();
        bd.putString("message",message);
        homeFragmet.setArguments(bd);
        return homeFragmet;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText txtInput =(EditText) view.findViewById(R.id.txtInput);
        Button btnSend =(Button) view.findViewById(R.id.btnSend);
        TextView txtResult =(TextView) view.findViewById(R.id.txtResult);
        Bundle bd = getArguments();
        if (bd != null){
            txtResult.setText(bd.getString("message",""));
        }
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Constant.ACTION_PERSON1);
                Bundle bd = new Bundle();
                bd.putString("message",txtInput.getText().toString());
                i.putExtras(bd);
                getActivity().sendBroadcast(i);
            }
        });
    }
}
