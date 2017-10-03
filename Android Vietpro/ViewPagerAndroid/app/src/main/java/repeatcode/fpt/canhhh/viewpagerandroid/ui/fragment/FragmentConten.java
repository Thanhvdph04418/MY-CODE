package repeatcode.fpt.canhhh.viewpagerandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import repeatcode.fpt.canhhh.viewpagerandroid.R;

public class FragmentConten extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content,container,false);
    }

    public static FragmentConten newInstance(int page){
        FragmentConten fragmentConten = new FragmentConten();
        Bundle args = new Bundle();
        args.putInt("page",page);
        fragmentConten.setArguments(args);
        return fragmentConten;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt = (TextView)view.findViewById(R.id.txt);
        int page = getArguments().getInt("page");
        txt.setText(String.valueOf(page));
    }
}
