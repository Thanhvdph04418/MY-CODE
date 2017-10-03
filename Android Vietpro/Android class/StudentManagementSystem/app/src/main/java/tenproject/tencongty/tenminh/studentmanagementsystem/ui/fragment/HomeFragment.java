package tenproject.tencongty.tenminh.studentmanagementsystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tenproject.tencongty.tenminh.studentmanagementsystem.R;
import tenproject.tencongty.tenminh.studentmanagementsystem.ui.activity.MainActivity;

//Created by X on 8/10/2017.

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button btnThem, btnXem, btnQuanLy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnThem = (Button) view.findViewById(R.id.btnThem);
        btnXem = (Button) view.findViewById(R.id.btnXem);
        btnQuanLy = (Button) view.findViewById(R.id.btnQuanLy);
        btnThem.setOnClickListener(this);
        btnXem.setOnClickListener(this);
        btnQuanLy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnThem:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                ThemLopDialogFragment editNameDialogFragment = new ThemLopDialogFragment();
                editNameDialogFragment.show(fm, "fragment_them_lop_dialog");
                break;
            case R.id.btnXem:
                ((MainActivity) getActivity()).nextFragment(R.id.myLayout, new XemDanhSachLopFragment());
                break;
            case R.id.btnQuanLy:
                break;
        }
    }
}
