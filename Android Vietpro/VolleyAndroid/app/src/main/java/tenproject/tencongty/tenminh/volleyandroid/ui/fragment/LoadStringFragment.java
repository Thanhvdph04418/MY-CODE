package tenproject.tencongty.tenminh.volleyandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import tenproject.tencongty.tenminh.volleyandroid.R;
import tenproject.tencongty.tenminh.volleyandroid.common.Constants;

//Created by X on 7/30/2017.

public class LoadStringFragment extends Fragment {
    private TextView txtWebContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_load_string, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtWebContent = (TextView) view.findViewById(R.id.txtWebContent);
        loadStringData();
    }

    private void loadStringData() {
        StringRequest request = new StringRequest(Request.Method.GET, Constants.URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtWebContent.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Can not load data from server");
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }
}
