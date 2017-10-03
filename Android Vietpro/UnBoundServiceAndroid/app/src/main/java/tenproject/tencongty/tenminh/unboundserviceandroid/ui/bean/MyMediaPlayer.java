package tenproject.tencongty.tenminh.unboundserviceandroid.ui.bean;

import android.content.Context;
import android.media.MediaPlayer;

import tenproject.tencongty.tenminh.unboundserviceandroid.R;

/**
 * Created by canhh on 19/09/2017.
 */

public class MyMediaPlayer {
    private MediaPlayer player;

    public MyMediaPlayer(Context context){
        player = MediaPlayer.create(context, R.raw.dd);
    }

    public  void start(){
        if (player != null) {
            player.start();
        }
    }

    public void stop(){
        if (player != null){
            player.stop();
            player.release();
        }
    }
}
