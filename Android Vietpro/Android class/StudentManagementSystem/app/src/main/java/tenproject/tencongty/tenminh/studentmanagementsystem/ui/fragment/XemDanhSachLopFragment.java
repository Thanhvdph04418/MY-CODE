package tenproject.tencongty.tenminh.studentmanagementsystem.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.studentmanagementsystem.R;
import tenproject.tencongty.tenminh.studentmanagementsystem.model.LopModel;
import tenproject.tencongty.tenminh.studentmanagementsystem.ui.adapter.DanhSachLopAdapter;

//Created by X on 8/10/2017.

public class XemDanhSachLopFragment extends Fragment {
    private ArrayList<LopModel> danhSach;
    private DatabaseReference mData;
    private DanhSachLopAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xem_danh_sach_lop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        danhSach = new ArrayList<>();
        RecyclerView rvDanhSachLop = (RecyclerView) view.findViewById(R.id.rvDanhSachLop);
        adapter = new DanhSachLopAdapter(getActivity(), danhSach, this);
        rvDanhSachLop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDanhSachLop.setAdapter(adapter);
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("lop").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                LopModel lopModel = dataSnapshot.getValue(LopModel.class);
                if (lopModel != null)
                    lopModel.setKey(dataSnapshot.getKey());
                danhSach.add(lopModel);
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


    public void xoaPhanTu(final int position) {
        mData.child("lop").child(danhSach.get(position).getKey()).removeValue();
        danhSach.remove(position);
        adapter.notifyDataSetChanged();
    }
}
