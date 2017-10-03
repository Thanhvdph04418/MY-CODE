package displayingimageswiththepicasso.fpt.canhhh.jsonandroid.ui.fragment;

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

import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.R;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.common.Contanst;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.common.Utils;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.model.Product;
import displayingimageswiththepicasso.fpt.canhhh.jsonandroid.ui.adapter.ProducAdapter;

public class MainFragment extends Fragment {
    private ArrayList<Product> datas;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        datas = new ArrayList<>();
        new LoadData().execute(Contanst.URL);
    }

    class LoadData extends AsyncTask<String, Void,Void>{
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
        protected Void doInBackground(String... params) {// làm công việc tính toán load dữ liệu,
            // thực thi các công việc chính cho tiến trình,không dược phép cập nhật trực tiếp giao diện,
            //giá trị mà hàm doInBackGround trả về sẽ là tham số của hàm onPostExcute
            String url = params[0]; // lấy đường dẫn cần load ở bên trên
            Utils handle = new Utils();// là hàm lấy dữ liệu trên sever
            handle.makeServiceCall(url);
            String json = handle.makeServiceCall(url);
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i< jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    int id_sanpham = object.getInt("id_sanpham");
                    int id_danh_muc = object.getInt("id_danhmuc");
                    int sanpham_noibat = object.getInt("sanpham_noibat");
                    int gia_sanpham = object.getInt("gia_sanpham");
                    String ten_sanpham = object.getString("ten_sanpham");
                    String mota_sanpham = object.getString("mota_sanpham");
                    String anh_sanpham = object.getString("anh_sanpham");
                    Product product = new Product(id_sanpham,ten_sanpham,id_danh_muc,gia_sanpham,mota_sanpham,sanpham_noibat,anh_sanpham);
                    datas.add(product);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            // nơi cập nhật giao diện nếu có
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // đây là hàm được gọi sau khi tiến trình thực hiện xong tức là hàm doinbackground làm xong việc
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing()) progressDialog.dismiss();
            ProducAdapter adapter = new ProducAdapter(getActivity(),datas);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv.setAdapter(adapter);
        }
    }
}
