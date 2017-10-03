package you.fuck.i.ecommerceapp.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import you.fuck.i.ecommerceapp.R;
import you.fuck.i.ecommerceapp.common.Contants;
import you.fuck.i.ecommerceapp.model.ProductModel;
import you.fuck.i.ecommerceapp.ui.adapter.ProductAdapter;


public class ProductFragment extends Fragment {
    private ArrayList<ProductModel> datas;
    private RecyclerView rvProduct;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvProduct = (RecyclerView) view.findViewById(R.id.rvProduct);
        datas = new ArrayList<>();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Waiting");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        loadDatas();

    }

    private void loadDatas() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                Contants.URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject object = null;
                            try {
                                object = response.getJSONObject(i);
                                datas.add(new ProductModel(object.getInt("id_sanpham"), object.getString("ten_sanpham"), object.getInt("id_danhmuc"), object.getInt("gia_sanpham"), object.getString("mota_sanpham"), object.getInt("sanpham_noibat"), object.getString("anh_sanpham")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ProductAdapter adapter = new ProductAdapter(getActivity(), datas);
                        rvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        rvProduct.setAdapter(adapter);
                        if (progressDialog.isShowing()) progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Can not Load data from server");
            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }

}
