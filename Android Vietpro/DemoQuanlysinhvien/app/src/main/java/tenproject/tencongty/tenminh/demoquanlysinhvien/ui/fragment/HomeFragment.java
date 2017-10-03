package tenproject.tencongty.tenminh.demoquanlysinhvien.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tenproject.tencongty.tenminh.demoquanlysinhvien.R;
import tenproject.tencongty.tenminh.demoquanlysinhvien.ui.activity.MainActivity;


public class HomeFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnThemlop =(Button)view.findViewById(R.id.btnTL);
        Button btnDSL =(Button)view.findViewById(R.id.btnXDSL);
        Button btnQlsv =(Button)view.findViewById(R.id.btnQLSV);
        btnThemlop.setOnClickListener(this);
        btnDSL.setOnClickListener(this);
        btnQlsv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTL:
                DialogFragment dialogFragment = new DialogFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                dialogFragment.show(fm,"dialog_them_lop_fragment");

                // kết thúc hiển thị dialog fragment
                break;
            case R.id.btnQLSV:
                break;
            case R.id.btnXDSL:
                ((MainActivity) getActivity()).nextFragment(R.id.mylayout, new XemDanhsachlopFragment());
                break;

        }
    }
}
