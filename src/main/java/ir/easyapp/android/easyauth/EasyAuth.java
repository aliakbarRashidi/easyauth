package ir.easyapp.android.easyauth;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohsen on 12/30/16.
 */

public class EasyAuth {

    public static void getAuthKey(AppCompatActivity activity, OnAuthKeyReadyListener onAuthKeyReadyListener) {
        EasyAuthController easyAuthController = new EasyAuthController(activity);
        easyAuthController.setOnAuthKeyReadyListener(onAuthKeyReadyListener);
        easyAuthController.init();

    }
}

