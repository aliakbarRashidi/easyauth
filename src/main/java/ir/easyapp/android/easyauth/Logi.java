package ir.easyapp.android.easyauth;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;


public class Logi {

    private static final String AppName = "EasyAppAuthLibrary";
    public static boolean isInDebugMode=false;


    public static void i(Activity activity, String msg) {
        i(activity.getClass().getSimpleName(), msg);
    }

    public static void i(String tag, String msg) {
        if (isInDebugMode)
            Log.i(tag,AppName+  msg);
    }

    public static void error(Throwable t) {
        if (isInDebugMode)
            Log.wtf(AppName,t);
    }

    public static void i(Context mContext, String msg) {
        i((Activity)mContext,msg);
    }
}