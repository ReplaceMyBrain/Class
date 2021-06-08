package com.aoslec.hybrid_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hello,img,imgFull;
    WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        hello = findViewById(R.id.hello);
        img = findViewById(R.id.btn_img);
        imgFull = findViewById(R.id.btn_imgFull);

        hello.setOnClickListener(onClickListener);
        img.setOnClickListener(onClickListener);
        imgFull.setOnClickListener(onClickListener);


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
            }

            @Override
            public void onPageFinished(WebView view, String url) {
            }
        });
    }//c

    String url1 = "<html>" +
            "<head>"+
            "</head>" +
            "<body>";

    String urlHello = "<h1>Hello World!</h1>";
    String urlImg = "<img src=\"http://192.168.2.3:8080/test/dog.jpg\">";
    String urlImgFull = "<img src=\"http://192.168.2.3:8080/test/dog.jpg\" style=\"width: 100%; height: auto;\">";

    String url2 = "</body>" +
            "</html>";


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.hello:
                        webView.loadDataWithBaseURL(null, url1+urlHello+url2, "text/HTML", "UTF-8", null);
                        break;

                    case R.id.btn_img:
                        webView.loadDataWithBaseURL(null, url1+urlImg+url2, "text/HTML", "UTF-8", null);
                        break;

                    case R.id.btn_imgFull:
                        webView.loadDataWithBaseURL(null, url1+urlImgFull+url2, "text/HTML", "UTF-8", null);
                        break;
            }
        }
    };
}