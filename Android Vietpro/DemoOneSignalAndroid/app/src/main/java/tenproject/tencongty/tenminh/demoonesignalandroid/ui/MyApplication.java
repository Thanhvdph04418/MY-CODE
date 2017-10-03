package tenproject.tencongty.tenminh.demoonesignalandroid.ui;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by canhh on 21/09/2017.
 */

public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effectiveness of OneSignal's "best-time" notification scheduling feature.
        // OneSignal.syncHashedEmail(userEmail);
    }
}
