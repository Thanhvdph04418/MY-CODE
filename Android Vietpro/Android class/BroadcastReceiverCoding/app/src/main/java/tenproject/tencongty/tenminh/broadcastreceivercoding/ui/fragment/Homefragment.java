package tenproject.tencongty.tenminh.broadcastreceivercoding.ui.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tenproject.tencongty.tenminh.broadcastreceivercoding.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {


    private BroadcastReceiver receiver = null;
    private TextView txt;
    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homefragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        // lọc ra những tín hiệu mình muốn nghe
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);//cắm sạc
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED); // rút sạc

        // sau khi lắng nghe tín hiệu cần phải đáp trả hành động đấy
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // đáp trả hành động gì viết code trong hàm onReceive
                if (intent.getAction().equals(intent.ACTION_POWER_CONNECTED)){
                    // nếu như đang cắm sạc thì viết vào trong này
                    txt.setText("đang cắm sạc");
                }else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
                    // nếu như rút sạc thì viết trong này
                    txt.setText("đã rút sạc");
                }
            }
        };

        // đăng ký cho rêceiver

        getActivity().registerReceiver(receiver,filter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt = (TextView) view.findViewById(R.id.txtName);
    }
}
