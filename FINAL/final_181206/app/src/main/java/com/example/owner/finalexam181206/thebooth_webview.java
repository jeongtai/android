package com.example.owner.finalexam181206;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class thebooth_webview extends AppCompatActivity {

    WebView WV;
    String url= "http://thebooth.co.kr/";
    Button closeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thebooth_webview);
        WV=(WebView)findViewById(R.id.webview);
        WV.setWebViewClient(new TestBrowser());
        WV.getSettings().setJavaScriptEnabled(true);
        WV.loadUrl(url);
    }

    private class TestBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    public void close(View v){
        finish();
    }

}


