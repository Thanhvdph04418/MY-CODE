package tenproject.tencongty.tenminh.assignment1.ui.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tenproject.tencongty.tenminh.assignment1.R;
import tenproject.tencongty.tenminh.assignment1.bean.LopModel;

//Created by X on 8/10/2017.

public class ThemLopDialogFragment extends DialogFragment implements View.OnClickListener{
    private EditText txtThemMaLop, txtThemTenLop;
    private Button btnXoaTrang, btnLuuLop;
    private DatabaseReference mData;
    public ThemLopDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public void onResume() {
        // Store access variables for window and blank point
        Window window = getDialog().getWindow();
        Point size = new Point();
        // Store dimensions of the screen in `size`
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        // Set the width of the dialog proportional to 75% of the screen width
        window.setLayout((int) (size.x * 0.98), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        // Call super onResume after sizing
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_them_lop, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mData = FirebaseDatabase.getInstance().getReference();
        txtThemMaLop = (EditText) view.findViewById(R.id.txtThemMaLop);
        txtThemTenLop = (EditText) view.findViewById(R.id.txtThemTenLop);
        btnXoaTrang = (Button) view.findViewById(R.id.btnXoaTrang);
        btnLuuLop = (Button) view.findViewById(R.id.btnLuuLop);
        btnXoaTrang.setOnClickListener(this);
        btnLuuLop.setOnClickListener(this);
        // Fetch arguments from bundle and set title
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        // Show soft keyboard automatically and request focus to field
        txtThemMaLop.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnXoaTrang:
                txtThemMaLop.setText("");
                txtThemTenLop.setText("");
                break;
            case R.id.btnLuuLop:
                String maLop = txtThemMaLop.getText().toString();
                String tenLop = txtThemTenLop.getText().toString();
                if (maLop.equals("") || tenLop.equals(""))
                    Toast.makeText(getActivity(), "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                else {
                    mData.child("lop").push().setValue(new LopModel(maLop, tenLop));
                    Toast.makeText(getActivity(), maLop + " - " + tenLop + "==> insert OK!", Toast.LENGTH_SHORT).show();
                    txtThemMaLop.setText("");
                    txtThemTenLop.setText("");
                }
                break;
        }
    }
}