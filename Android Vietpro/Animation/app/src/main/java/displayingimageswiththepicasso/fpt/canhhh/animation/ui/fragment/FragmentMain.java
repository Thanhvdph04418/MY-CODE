package displayingimageswiththepicasso.fpt.canhhh.animation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import displayingimageswiththepicasso.fpt.canhhh.animation.R;

/**
 * Created by canhh on 25/07/2017.
 */

public class FragmentMain extends Fragment {
    private Animation alpha;
    private Animation rotate;
    private Animation translate;
    private Animation scale;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button btnAlpha = (Button) view.findViewById(R.id.btnAlpha);
        final Button btnTranslate= (Button) view.findViewById(R.id.btnTranslate);
        final Button btnRotate = (Button) view.findViewById(R.id.btnRotate);
        final Button btnScale = (Button) view.findViewById(R.id.btnScale);
        final Button btnSet = (Button) view.findViewById(R.id.btnSet);
        alpha = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
        translate = AnimationUtils.loadAnimation(getActivity(), R.anim.translate);
        rotate = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate);
        scale = AnimationUtils.loadAnimation(getActivity(), R.anim.scale);
        final AnimationSet set = new AnimationSet(true);
        set.addAnimation(alpha);
        set.addAnimation(scale);
        set.addAnimation(rotate);
        set.addAnimation(scale);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAlpha.startAnimation(alpha);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRotate.startAnimation(rotate);

            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnScale.startAnimation(scale);
            }
        });
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSet.startAnimation(set);
            }
        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTranslate.startAnimation(translate);
            }
        });
    }
}
