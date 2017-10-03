package tenproject.tencongty.tenminh.unboundserviceandroid.ui.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;

import tenproject.tencongty.tenminh.unboundserviceandroid.ui.bean.MyMediaPlayer;

public class MyService extends Service {
    private MyMediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player != null){
            player.start();
        }
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MyMediaPlayer(getBaseContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
