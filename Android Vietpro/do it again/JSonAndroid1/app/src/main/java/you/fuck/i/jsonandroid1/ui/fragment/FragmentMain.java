package you.fuck.i.jsonandroid1.ui.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import you.fuck.i.jsonandroid1.R;
import you.fuck.i.jsonandroid1.common.Utils;
import you.fuck.i.jsonandroid1.model.ProductModer;
import you.fuck.i.jsonandroid1.ui.adapter.ProducAdapter;


public class FragmentMain extends Fragment {
    private RecyclerView rv;
    private ArrayList<ProductModer> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView)view.findViewById(R.id.rv);
        datas = new ArrayList<>();

    }

    class LoadData extends AsyncTask<String,Void, Void>{
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Waiting...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            String url = params[0];
            Utils hander = new Utils();
            hander.makeServiceCall(url);
            String json = hander.makeServiceCall(url);
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i=0;i<datas.size(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    int id_sanpham = object.getInt("id_sanpham");
                    int id_danh_muc = object.getInt("id_danhmuc");
                    int sanpham_noibat = object.getInt("sanpham_noibat");
                    int gia_sanpham = object.getInt("gia_sanpham");
                    String ten_sanpham = object.getString("ten_sanpham");
                    String mota_sanpham = object.getString("mota_sanpham");
                    String anh_sanpham = object.getString("anh_sanpham");
                    ProductModer product = new ProductModer(id_sanpham,ten_sanpham,id_danh_muc,gia_sanpham,mota_sanpham,sanpham_noibat,anh_sanpham);
                    datas.add(product);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing()) progressDialog.dismiss();
            ProducAdapter adapter = new ProducAdapter(datas,getContext());
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.setAdapter(adapter);
        }
    }
}
