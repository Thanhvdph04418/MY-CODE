package tenproject.tencongty.tenminh.project1.ui.fragment;


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

import tenproject.tencongty.tenminh.project1.R;
import tenproject.tencongty.tenminh.project1.common.Constants;

/**
 * A simple {@link Fragment} subclass.
 **/
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public static HomeFragment newInstance(String message) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bd = new Bundle();
        bd.putString("message", message);
        homeFragment.setArguments(bd);
        return homeFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText txtInput = view.findViewById(R.id.txtInput);
        Button btnSend = view.findViewById(R.id.btnSend);
        TextView txtResult = view.findViewById(R.id.txtResult);
        Bundle bd = getArguments();
        if (bd != null) {
            String message = bd.getString("message", "");
            txtResult.setText(message);
        }
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Constants.ACTION_MESSAGE_PROJECT1);
                Bundle bd = new Bundle();
                bd.putString("message", txtInput.getText().toString());
                i.putExtras(bd);
                getActivity().sendBroadcast(i);
            }
        });
    }
}
