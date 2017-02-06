package ir.easyapp.android.easyauth;

/**
 * Created by mohsen on 12/29/16.
 */

public interface OnAuthKeyReadyListener {

    void onKeyReady(String key);
    void onError(String error);
}
