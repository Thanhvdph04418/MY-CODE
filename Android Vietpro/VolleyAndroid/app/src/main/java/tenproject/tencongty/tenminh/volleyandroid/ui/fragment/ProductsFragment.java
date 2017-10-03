package tenproject.tencongty.tenminh.volleyandroid.ui.fragment;

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

import tenproject.tencongty.tenminh.volleyandroid.R;
import tenproject.tencongty.tenminh.volleyandroid.common.Constants;
import tenproject.tencongty.tenminh.volleyandroid.model.Products;
import tenproject.tencongty.tenminh.volleyandroid.ui.adapter.ProductsAdapter;

//Created by X on 7/30/2017.

public class ProductsFragment extends Fragment {
    private RecyclerView rvProducts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvProducts = (RecyclerView) view.findViewById(R.id.rvProducts);
        loadDatas();
    }

    private void loadDatas() {
        final ArrayList<Products> datas = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Constants.URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        datas.add(new Products(object.getInt("id_sanpham"), object.getString("ten_sanpham"), object.getInt("id_danhmuc"), object.getInt("gia_sanpham"), object.getString("mota_sanpham"), object.getInt("sanpham_noibat"), object.getString("anh_sanpham")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                rvProducts.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                ProductsAdapter adapter = new ProductsAdapter(getActivity(), datas);
                rvProducts.setAdapter(adapter);
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
