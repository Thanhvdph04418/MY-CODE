package tenproject.tencongty.tenminh.demoquanlysinhvien.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.demoquanlysinhvien.R;
import tenproject.tencongty.tenminh.demoquanlysinhvien.model.LopModel;
import tenproject.tencongty.tenminh.demoquanlysinhvien.ui.adapter.AdapterDSL;

/**
 * Created by canhh on 13/08/2017.
 */

public class XemDanhsachlopFragment extends Fragment {
    private ArrayList<LopModel> danhSach;
    private AdapterDSL adapter;
    private DatabaseReference mData;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // khởi tạo progressdialog
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("loading");
        progressDialog.setMessage("waiting....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        danhSach = new ArrayList<>();

        RecyclerView rvDanhSachLop = (RecyclerView) view.findViewById(R.id.rvdsl);

        adapter = new AdapterDSL(danhSach, getActivity());

        rvDanhSachLop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDanhSachLop.setAdapter(adapter);

        mData = FirebaseDatabase.getInstance().getReference();

        layData();
    }

    public void layData(){
        //check xem load xong toàn bộ thông tin hay chưa
        // nếu nhưu load xong thì tắt progressdialog
        mData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (progressDialog.isShowing())
                        progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("lop").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                danhSach.add(dataSnapshot.getValue(LopModel.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
