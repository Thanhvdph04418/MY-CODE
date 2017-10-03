package displayingimageswiththepicasso.fpt.canhhh.displayingimageswiththepicasso.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import displayingimageswiththepicasso.fpt.canhhh.displayingimageswiththepicasso.R;

/**
 * Created by canhh on 23/07/2017.
 */

public class MainFragment extends Fragment {
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img = (ImageView) view.findViewById(R.id.img);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Glide.with(getActivity())
//                .load("https://68.media.tumblr.com/6c4add8b6146e6e7a80f82e72e936428/tumblr_n0n3vwW48X1tp57gjo1_400.gif")
//                .into(img);
        ImageView imageView = (ImageView) findViewById(R.id.img);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.sample_gif).into(imageViewTarget);
    }
}
