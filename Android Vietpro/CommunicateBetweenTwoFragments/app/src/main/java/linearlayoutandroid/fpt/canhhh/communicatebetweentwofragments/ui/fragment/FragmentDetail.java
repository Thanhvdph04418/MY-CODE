package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.R;



public class FragmentDetail extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container,false);
    }

    public static FragmentDetail newInstance(String name, int age){
        FragmentDetail fragmentDetal = new FragmentDetail();
        Bundle args =new Bundle();
        args.putString("name",name);
        args.putInt("age",age);
        fragmentDetal.setArguments(args);
        return fragmentDetal;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtNameConten =(TextView)view.findViewById(R.id.txtNameConten);
        TextView txtAgeConten = (TextView)view.findViewById(R.id.txtAgeConten);
        String name = getArguments().getString("name");
        int age = getArguments().getInt("age");
        txtNameConten.setText(name);
        txtAgeConten.setText(String.valueOf(age));
    }
}
