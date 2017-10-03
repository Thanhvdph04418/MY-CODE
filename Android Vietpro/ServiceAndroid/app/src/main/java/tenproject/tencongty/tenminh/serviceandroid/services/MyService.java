package tenproject.tencongty.tenminh.serviceandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by canhh on 12/09/2017.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {// để khởi tạo các đối tượng
        // chỉ gọi một lần khi bắt đầu! chỉ khi chạy xong thì mới bắt đầu lại
        // thoát ap ra vào lại không gọi lại hàm này
        super.onCreate();
        Log.d("Service","onCreate started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // thực thi dịch vụ giao việc cho service
        new HandleTask().execute();

        return START_NOT_STICKY;
    }

    public static class HandleTask extends AsyncTask<Void, Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            for (int i =1; i<=100; i++){
                Log.d("Service","Value : " + i);
                try {
                    Thread.sleep(1000);
                    // dừng 1 dây
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
    @Override
    public void onDestroy() {
        // chạy xong tự hủy gọi hàm này
        super.onDestroy();
        Log.d("Service","onDestroy started");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Service","Do not care");
        return null;
    }
}
