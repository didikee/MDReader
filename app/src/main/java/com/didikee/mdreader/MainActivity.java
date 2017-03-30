package com.didikee.mdreader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.didikee.mdreader.utils.MDUtil;
import com.didikee.mdreader.utils.UriUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import io.github.gitbucket.markedj.Marked;


public class MainActivity extends Activity {

    private final int PERMISSION = 1;
    private WebView webView;

    private String mdName;/*2017 Android 面试题 [ 基础与细节 ]*/
    private String mdPath;/*/storage/emulated/0/Blog/2017 Android 面试题 [ 基础与细节 ].md*/
    private String savePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        initView();
        prepare2DoDoDo();
    }

    private void prepare2DoDoDo() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION);
            } else {
                md2Html();
            }
        } else {
            md2Html();
        }
    }

    private boolean getUriData() {
        Intent intent = getIntent();
        if (intent == null) {
            showError(1);
            return false;
        }
        Uri uri = intent.getData();
        if (uri == null) {
            showError(2);
            return false;
        }
        mdPath = UriUtil.getPathFromUri(this, uri);
        Log.e("test", "path: " + mdPath);
        ///storage/emulated/0/Blog/2017 Android 面试题 [ 基础与细节 ].md
        if (TextUtils.isEmpty(mdPath)) {
            showError(3);
            return false;
        }
        int start = mdPath.lastIndexOf(File.separator);
        int end = mdPath.lastIndexOf(".");
        mdName = mdPath.substring(start + 1, end);
        Log.e("test", "name: " + mdName);

        savePath = mdPath.substring(0, end) + ".html";
        return true;
    }

    private void showError(int type) {
        String msg = "";
        switch (type) {
            case 1:
                msg = "错误！";
                break;
            case 2:
                msg = "未捕获到文件信息！";
                break;
            case 3:
                msg = "解析文件路径出错啦~(maybe you can retry...)";
                break;
            case 4:
                msg = "Markdown 文本转换 Html 时出错了！";
                break;
        }
        showToast(msg);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        webView = ((WebView) findViewById(R.id.webView));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    private void md2Html() {
        if (getUriData()){
            String s = readFromMarkDownFile(mdPath);
            String codeBlock = "\n" + "```" + "\n";
            String replaceAll = s.replaceAll("```", codeBlock);
            String html1 = Marked.marked(replaceAll);
            write2SDCard(html1);
        }
    }

    private void write2SDCard(String text) {
        File saveFile = new File(savePath);
        boolean isSuccess = MDUtil.write2SDCard(saveFile, text);
        if (isSuccess) {
            webView.loadUrl("file://" + savePath);
        } else {
            showError(4);
        }
    }

    private String readFromMarkDownFile(String finalPath) {
        if (TextUtils.isEmpty(finalPath)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(finalPath));

            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null) {
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override
    public void onBackPressed() {
        if (!webView.canGoBack()) {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]
            grantResults) {
        if (requestCode == PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                md2Html();
            } else {
                // Permission Denied
                Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                finish();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
