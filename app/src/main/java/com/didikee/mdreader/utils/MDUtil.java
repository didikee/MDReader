package com.didikee.mdreader.utils;

import android.text.TextUtils;

import com.didikee.mdreader.CSS;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by didik on 2017/3/30.
 */

public class MDUtil {
    public static boolean write2SDCard(File saveFile,String text){
        if (saveFile == null || TextUtils.isEmpty(text))
            return false;
        boolean isSuccess = true;
        String start = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "  <meta charset=\"utf-8\"/>\n" +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>\n" +
                CSS.github+
                "  <title>MDReader</title>\n" +
                "</head>\n"+
                "<body>\n" +
                "  <div id=\"content\">";
        String baseStart = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\"/>\n" +
                "  <title>MDReader</title>\n" +
                "<script src=\"lib/marked.js\"></script>\n"+
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"content\">";


        String baseEnd = "</div>"+
                "</body>\n" +
                "</html>";
        text = start + text + baseEnd;
        try {
            FileOutputStream os = new FileOutputStream(saveFile);
            os.write(text.getBytes());
            os.close();
        } catch (Exception e) {
            isSuccess = false;
            e.printStackTrace();
        }
        return isSuccess;
    }
}
