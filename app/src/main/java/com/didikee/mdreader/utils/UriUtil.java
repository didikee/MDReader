package com.didikee.mdreader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

/**
 * Created by didik on 2017/3/30.
 */

public class UriUtil {
    public static String getPathFromUri(Context context, Uri uri) {
        //得到uri，后面就是将uri转化成file的过程
        if (context == null || uri == null) {
            return null;
        }
        String pathFromUri;
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= 19) {
            pathFromUri = Uri2Path.getRealPathFromURI_API19(context, uri);
        } else if (sdkInt >= 11 && sdkInt < 19) {
            pathFromUri = Uri2Path.getRealPathFromURI_API11to18(context, uri);
        } else {
            pathFromUri = Uri2Path.getRealPathFromURI_BelowAPI11(context, uri);
        }
        return pathFromUri;
    }
}
