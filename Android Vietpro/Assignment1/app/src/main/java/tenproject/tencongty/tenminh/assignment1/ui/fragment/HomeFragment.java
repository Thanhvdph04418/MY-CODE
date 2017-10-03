package tenproject.tencongty.tenminh.assignment1.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tenproject.tencongty.tenminh.assignment1.R;
import tenproject.tencongty.tenminh.assignment1.ui.activity.MainActivity;


public class HomeFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "HomeFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        return inflater.inflate(R.layout.fragment_home1, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imgNews = (ImageView)view.findViewById(R.id.imgNews);
        ImageView imgSocial = (ImageView)view.findViewById(R.id.imgSocicals);
        ImageView imgMaps = (ImageView)view.findViewById(R.id.imgMaps);
        ImageView imgStudent = (ImageView)view.findViewById(R.id.imgStudents);
        imgMaps.setOnClickListener(this);
        imgNews.setOnClickListener(this);
        imgSocial.setOnClickListener(this);
        imgStudent.setOnClickListener(this);
        Log.d(TAG, "onViewCreated: started");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgStudents:
                ((MainActivity) getActivity()).nextFragment(R.id.mylayout, new StudentFragment());
                break;
            case R.id.imgMaps:
                ((MainActivity) getActivity()).nextFragment(R.id.mylayout, new MapsFragment());
                break;
            case R.id.imgNews:
                ((MainActivity) getActivity()).nextFragment(R.id.mylayout, new NewsFragment());
                break;
            case R.id.imgSocicals:
                ((MainActivity) getActivity()).nextFragment(R.id.mylayout, new SocialFragment());
        }
    }
}
