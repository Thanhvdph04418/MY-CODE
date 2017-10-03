package repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.R;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.model.StudentModel;
import repeatcode.fpt.canhhh.communicatebetweentwofragments2.ui.adapter.StudentAdapter;

/**
 * Created by canhh on 18/07/2017.
 */

public class FragmentMain extends Fragment {
    @BindView(R.id.lvConten)
    ListView lvStudent;

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
        final ArrayList<StudentModel> datas = initData();
        StudentAdapter adapter = new StudentAdapter(getActivity(), initData());
        lvStudent.setAdapter(adapter);
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((Listener)getActivity()).handel(datas.get(position));
            }
        });
    }

    private ArrayList<StudentModel> initData(){
        ArrayList<StudentModel> datas = new ArrayList<>();
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        datas.add(new StudentModel("A",18));
        return datas;
    }
}
