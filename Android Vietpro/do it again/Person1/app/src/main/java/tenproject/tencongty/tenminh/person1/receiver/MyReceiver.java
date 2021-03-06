package tenproject.tencongty.tenminh.person1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tenproject.tencongty.tenminh.person1.ui.activity.MainActivity;

/**
 * Created by canhh on 12/09/2017.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("canhdeptrai")){
            Bundle bd = intent.getExtras();
            String message = bd.getString("message","");
            intent = new Intent(context, MainActivity.class);
            bd.putString("message",message);
            intent.putExtras(bd);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
