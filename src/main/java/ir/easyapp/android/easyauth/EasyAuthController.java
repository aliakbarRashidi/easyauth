package ir.easyapp.android.easyauth;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;


/**
 * Created by mohsen on 12/29/16.
 */

public class EasyAuthController implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String APP_NOT_FOUND="this app can not be authorize with easy yet";
    private String content="Y29udGVudDovL2lyLmVhc3lhcHAuYW5kcm9pZC5hdXRocHJvdmlkZXIvYXV0aC8=";

    CursorLoader mCursorLoader;

    private OnAuthKeyReadyListener mOnAuthKeyReadyListener = null;

    private AppCompatActivity mAppCompatActivity;

    public EasyAuthController(AppCompatActivity context) {
        mAppCompatActivity = context;

    }

    public void init() {
        mAppCompatActivity.getLoaderManager().initLoader(1, null, this);
    }

    public void setOnAuthKeyReadyListener(OnAuthKeyReadyListener onAuthKeyReadyListener) {
        this.mOnAuthKeyReadyListener = onAuthKeyReadyListener;
    }

    public static void setDebugMode(boolean isInDebugMode) {
        Logi.isInDebugMode = isInDebugMode;
    }

    public static void getAuthKey(AppCompatActivity activity, OnAuthKeyReadyListener onAuthKeyReadyListener) {
        EasyAuthController easyAuthController = new EasyAuthController(activity);
        easyAuthController.setOnAuthKeyReadyListener(onAuthKeyReadyListener);
        easyAuthController.init();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        try {
            mCursorLoader = new CursorLoader(mAppCompatActivity, Uri.parse(Base64Decoder.decode(content)+getPackageName()), null, null, null, null);
            return mCursorLoader;
        } catch (Throwable t) {
            Logi.error(t);
            if (mOnAuthKeyReadyListener!=null)
                mOnAuthKeyReadyListener.onError(t.getMessage());
            return null;
        }

    }

    private String getPackageName() {
        return  mAppCompatActivity.getApplicationInfo().packageName;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null) {
            Logi.error(new Exception(APP_NOT_FOUND));

            if (mOnAuthKeyReadyListener!=null)
                mOnAuthKeyReadyListener.onError(APP_NOT_FOUND);
            return;
        }
        try {
            cursor.moveToFirst();

            String key=cursor.getString(cursor.getColumnIndex(cursor.getColumnNames()[2]));

            if (mOnAuthKeyReadyListener!=null)
                mOnAuthKeyReadyListener.onKeyReady(key);

        } catch (Throwable t) {
            Logi.error(t);

            if (mOnAuthKeyReadyListener!=null)
                mOnAuthKeyReadyListener.onError(t.getMessage());
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}
