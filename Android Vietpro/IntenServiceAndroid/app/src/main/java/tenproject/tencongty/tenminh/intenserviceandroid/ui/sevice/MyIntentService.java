package tenproject.tencongty.tenminh.intenserviceandroid.ui.sevice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import tenproject.tencongty.tenminh.intenserviceandroid.ui.commom.Constants;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i=0; i<100;i++){
            intent = new Intent(Constants.MY_ACTION);
            Bundle bd = new Bundle();
            bd.putInt("percent",i);
            intent.putExtras(bd);
            sendBroadcast(intent);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
