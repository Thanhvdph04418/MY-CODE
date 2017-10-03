package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.R;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.model.StudentModel;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments.ui.adapter.StudentAdapter;



public class
FragmentMain extends Fragment {
    private ListView lvStudent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmet_main,container,false);
    }

    public interface Listener{
        void handel (StudentModel st);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvStudent = (ListView) view.findViewById(R.id.lvStudent);
        final ArrayList<StudentModel> datas = initDatas();
        StudentAdapter adapter = new StudentAdapter(getActivity(),initDatas());
        lvStudent.setAdapter(adapter);
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((Listener) getActivity()).handel(datas.get(position));
            }
        });
    }
    private ArrayList<StudentModel> initDatas(){//thiết lập dữ liệu cho fragment_main
        ArrayList<StudentModel> datas = new ArrayList<>();
        datas.add(new StudentModel(12,"canh1"));
        datas.add(new StudentModel(13,"q"));
        datas.add(new StudentModel(14,"anh"));
        datas.add(new StudentModel(15,"linh"));
        datas.add(new StudentModel(15,"can"));
        datas.add(new StudentModel(17,"cuong"));
        datas.add(new StudentModel(18,"canh"));
        datas.add(new StudentModel(19,"canh"));
        datas.add(new StudentModel(20,"canhb"));
        return datas;
    }
}
