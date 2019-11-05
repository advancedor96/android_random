package com.dingding.random;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    public static String FACEBOOK_URL = "https://www.facebook.com/advancedor96";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        myWebView = findViewById(R.id.webview);
//        myWebView.setWebChromeClient(new WebChromeClient());
//        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.author) {
            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);
            return true;
        } else if (id == R.id.idea){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("設計理念");
            alert.setCancelable(false);
            alert.setMessage("如果你沒辦法在腦子裡先把選項簡化到剩下2個，那你動的腦太少了。再動一下試試看。");
            alert.setPositiveButton("關閉", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
