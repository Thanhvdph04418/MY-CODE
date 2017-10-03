package tenproject.tencongty.tenminh.bai2.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tenproject.tencongty.tenminh.bai2.MainActivity;
import tenproject.tencongty.tenminh.bai2.MyService;
import tenproject.tencongty.tenminh.bai2.R;

import static android.os.Build.VERSION_CODES.M;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Context context;

    public HomeFragment() {
        // Required empty public constructor
    }
    Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText edt = (EditText)view.findViewById(R.id.editText);
        Button btn = (Button)view.findViewById(R.id.button);
        intent = new Intent(context, MyService.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long numSleep = Long.parseLong(edt.getText().toString());
                intent.putExtra("a",numSleep);
            }
        });
    }
}
