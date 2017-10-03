package repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.R;



public class FragmentDetail extends Fragment {
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtAge)
    TextView txtAge;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    public static FragmentDetail newInstance(String name, int age){
        FragmentDetail fragmentDetail = new FragmentDetail();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("age",age);
        fragmentDetail.setArguments(args);
        return fragmentDetail;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = getArguments().getString("name");
        int age = getArguments().getInt("age");
        txtName.setText(name);
        txtAge.setText(String.valueOf(age));
    }
}
