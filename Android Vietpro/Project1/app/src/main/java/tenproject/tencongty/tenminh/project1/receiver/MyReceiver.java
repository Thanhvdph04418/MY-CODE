package tenproject.tencongty.tenminh.project1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tenproject.tencongty.tenminh.project1.ui.activity.MainActivity;

/**
 * Created by X on 9/10/2017.
 **/

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("VIETPRO.ACTION.PROJECT2")) {
            Bundle bd = intent.getExtras();
            String message = bd.getString("message", "");
            intent = new Intent(context, MainActivity.class);
            bd = new Bundle();
            bd.putString("message", message);
            intent.putExtras(bd);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
