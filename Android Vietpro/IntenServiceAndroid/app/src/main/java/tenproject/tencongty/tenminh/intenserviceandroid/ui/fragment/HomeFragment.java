package tenproject.tencongty.tenminh.intenserviceandroid.ui.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import tenproject.tencongty.tenminh.intenserviceandroid.R;
import tenproject.tencongty.tenminh.intenserviceandroid.ui.commom.Constants;
import tenproject.tencongty.tenminh.intenserviceandroid.ui.sevice.MyIntentService;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ProgressBar progressBar;
    private BroadcastReceiver mReceiver =null;

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
    public void onResume() {
        super.onResume();
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Constants.MY_ACTION)){
                    Bundle bd = intent.getExtras();
                    if (bd != null){
                        int percent = bd.getInt("percent",-1);
                        new ShowProgressTask().execute(percent);
                    }
                }
            }
        };

        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.MY_ACTION);

        getActivity().registerReceiver(mReceiver,filter);
    }
    public class ShowProgressTask extends AsyncTask<Integer, Integer,Integer>{

        @Override
        protected Integer doInBackground(Integer... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            progressBar.setProgress(integer);
            if (integer==100){
                Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mReceiver);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = (Button) view.findViewById(R.id.btnStart);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MyIntentService.class);
                getActivity().startService(i);
            }
        });
    }
}
