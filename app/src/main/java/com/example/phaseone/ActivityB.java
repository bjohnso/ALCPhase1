package com.example.phaseone;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityB extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_layout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About ALC");

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl("https://andela.com/alc/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.back_button:
                Toast.makeText(this, "Going To Main Screen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class CustomWebViewClient extends WebViewClient
    {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError er) {
            handler.proceed();
        }
    }
}

