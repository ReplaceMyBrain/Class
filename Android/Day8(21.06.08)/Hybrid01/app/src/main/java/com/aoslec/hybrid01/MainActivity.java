package com.aoslec.hybrid01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    WebView webView = null;
    Button btnReload, btnPage1,btnPage2,btnPage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        btnReload =findViewById(R.id.btn_reload);
        btnPage1 =findViewById(R.id.btn_page1);
        btnPage2 =findViewById(R.id.btn_page2);
        btnPage3 =findViewById(R.id.btn_page3);

        btnReload.setOnClickListener(onClickListener);
        btnPage1.setOnClickListener(onClickListener);
        btnPage2.setOnClickListener(onClickListener);
        btnPage3.setOnClickListener(onClickListener);

        //Web Setting
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //javaScript 사용가능
        webSettings.setBuiltInZoomControls(true); // 축소 확대 가능
        webSettings.setDisplayZoomControls(false); // 돋보기 없애기

        //Link 시 다른 Browser 안보이게
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                btnReload.setText("로딩중...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                btnReload.setText(webView.getTitle());
            }
        });

//        webView.loadUrl("https://www.naver.com");


    }//c

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_page1:
                    btnPage1Click();
                    break;

                case R.id.btn_page2:
                    webView.loadUrl("https://www.google.com");
                    break;

                case R.id.btn_page3:
                    webView.loadUrl("https://www.daum.net");
                    break;

            }
        }
    };

    public void btnPage1Click(){
        webView.loadUrl("http://192.168.2.3:8080/test/Arithmetic.jsp");
    }


    //백눌렀을때 행동
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }
}//m