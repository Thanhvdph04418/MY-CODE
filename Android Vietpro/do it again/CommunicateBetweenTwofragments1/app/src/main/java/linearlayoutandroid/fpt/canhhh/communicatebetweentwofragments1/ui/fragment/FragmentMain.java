package linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.R;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.model.StudentModel;
import linearlayoutandroid.fpt.canhhh.communicatebetweentwofragments1.ui.adapter.StudentAdapter;

/**
 * Created by canhh on 17/07/2017.
 */

public class FragmentMain extends Fragment {
    private ListView lvStudent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);

    }
    public interface Listener{
        void handel (StudentModel st);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvStudent =(ListView) view.findViewById(R.id.lvStudent);
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
    private ArrayList<StudentModel> initDatas(){
        ArrayList<StudentModel> datas= new ArrayList<>();
        datas.add(new StudentModel(12,"A"));
        datas.add(new StudentModel(11,"B"));
        datas.add(new StudentModel(13,"C"));
        datas.add(new StudentModel(14,"D"));
        return datas;
    }
}
