package ir.easyapp.android.easyauth;

import android.util.Base64;

/**
 * Created by mohsen on 12/30/16.
 */

public class Base64Decoder {

    public static String decode(String str){
        return new String(Base64.decode(str,0));
    }
}
