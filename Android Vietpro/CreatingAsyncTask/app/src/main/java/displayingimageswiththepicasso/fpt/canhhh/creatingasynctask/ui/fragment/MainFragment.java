package displayingimageswiththepicasso.fpt.canhhh.creatingasynctask.ui.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import displayingimageswiththepicasso.fpt.canhhh.creatingasynctask.R;

/**
 * Created by canhh on 25/07/2017.
 */

public class MainFragment extends Fragment {
    private EditText txtInputSecond;
    private TextView txtResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtInputSecond =(EditText)view.findViewById(R.id.txtInputSecond);
        txtResult = (TextView) view.findViewById(R.id.txtResult);
        Button btnRun = (Button) view.findViewById(R.id.btnRun);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Mytask().execute(txtInputSecond.getText().toString());
            }
        });
    }

    class Mytask extends AsyncTask<String, String, String>{
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // hiển thị ra progressdialog( giống xoay lúc load phim)
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Wait for" + txtInputSecond.getText().toString() +"seconds");
            progressDialog.setCancelable(false); // để làm gì?
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            //đây là hàm có tác dụng thực thi công việc chính cho tiến trình
            // không dược phép cập nhật trực tiếp giao diện
            // giá trị mà hàm doInBackGround trả về sẽ là tham số của hàm onPostExcute
            publishProgress("sleeping...");
            String reusult ="";
            int time = Integer.parseInt(strings[0]) * 1000 ;
            try{
                Thread.sleep(time);
                reusult = "done";
            }catch (Exception e){
                e.printStackTrace();
            }
            return reusult;
        }

        @Override
        protected void onProgressUpdate(String... values) {//String... là nạp trồng vô hạn chuỗi
            super.onProgressUpdate(values);
            // nơi cập nhật trực tiếp giao diện nếu có
            txtResult.setText(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // đây là hàm được gọi sau khi tiến trình thực hiện xong tức là hàm doInBackGround làm xong việc
            if (progressDialog.isShowing()) progressDialog.dismiss();
            txtResult.setText(s);
        }
    }
}
