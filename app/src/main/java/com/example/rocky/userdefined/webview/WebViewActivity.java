package com.example.rocky.userdefined.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.rocky.userdefined.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView mWebView;

    @SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web_view);
        //
        ButterKnife.bind(this);
        //
        //mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JSBridge(),"control");
        //mWebView.setWebViewClient(new WebViewClient());
        //mWebView.setWebChromeClient(new WebChromeClient());
        //mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("file:///android_asset/web/test.html");
    }



    @OnClick(R.id.btn_url)
    void btn_url(View view){
        //mWebView.loadUrl("http://www.baidu.com");
       // mWebView.loadUrl("file:///android_asset/web/test.html");
        mWebView.loadUrl("javascript:sum(3,8)");
    }

    public class JSBridge{
        @JavascriptInterface
        public void toastMessage(String message){
            Toast.makeText(getApplicationContext(),"通过Native传递的Toast:"+message,Toast.LENGTH_SHORT).show();
        }
        @JavascriptInterface
        public void onSumResult(int result){
            Toast.makeText(getApplicationContext(),"result:"+result,Toast.LENGTH_SHORT).show();
        }
    }

}
