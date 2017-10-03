package tenproject.tencongty.tenminh.broadcastreceivermanifest.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tenproject.tencongty.tenminh.broadcastreceivermanifest.ui.activity.MainActivity;


public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            // nếu sạc pin thì xử lý code trong này
            intent = new Intent(context, MainActivity.class);
            Bundle bd = new Bundle();
            bd.putString("content", "Đang sạc");
            intent.putExtras(bd);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
