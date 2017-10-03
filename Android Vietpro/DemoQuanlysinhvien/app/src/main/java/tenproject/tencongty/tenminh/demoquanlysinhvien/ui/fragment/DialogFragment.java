package tenproject.tencongty.tenminh.demoquanlysinhvien.ui.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tenproject.tencongty.tenminh.demoquanlysinhvien.R;
import tenproject.tencongty.tenminh.demoquanlysinhvien.model.LopModel;

/**
 * Created by canhh on 13/08/2017.
 */

public class DialogFragment extends android.support.v4.app.DialogFragment implements View.OnClickListener{
    EditText txtTML ;
    EditText txtTTL ;
    private DatabaseReference mData;

    public DialogFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_dialog_fragment,container);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTML = (EditText) view.findViewById(R.id.txtTML);
        txtTTL = (EditText) view.findViewById(R.id.txtTTL);


        Button btnXT = (Button) view.findViewById(R.id.btnXT);
        Button btnLL = (Button) view.findViewById(R.id.btnLL);
        btnLL.setOnClickListener(this);
        btnXT.setOnClickListener(this);

        // xóa đi title của dialog fragment
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        // kết thúc ánh xạ view

        // Truy cập đến node cha của firebase
        mData = FirebaseDatabase.getInstance().getReference();

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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnXT:
                txtTML.setText("");
                txtTTL.setText("");
                // kết thúc phần xóa trắng
                break;
            case R.id.btnLL:
                //chức năng lưu lớp
                //lấy dữ liệu khi người dùng nhập vào ô edittext
                String malop = txtTML.getText().toString();
                String tenlop = txtTTL.getText().toString();

                LopModel lopModel = new LopModel(malop, tenlop);
                mData.child("lop").push().setValue(lopModel);

                txtTML.setText("");
                txtTTL.setText("");
                //kết thúc chức năng lưu lớp
                break;
        }

    }
}
