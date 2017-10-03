package tenproject.tencongty.tenminh.animationandroid.ui.fragment;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tenproject.tencongty.tenminh.animationandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(btn, "alpha", 0, 1);
//                fadeAnim.start();
                ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(btn, "scaleX", 1.0f, 2.0f);
                scaleAnim.setDuration(3000);
                scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
                scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
                scaleAnim.start();
            }
        });
    }
}
