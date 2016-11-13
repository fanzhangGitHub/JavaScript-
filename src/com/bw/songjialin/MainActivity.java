package com.bw.songjialin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {
	private WebView webview;
    private String url="file:///android_asset/form.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=(WebView) findViewById(R.id.webview);
        webview.loadUrl(url);
        //在本应用中浏览
        webview.setWebViewClient(new WebViewClient());
        //开关
        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new Object(){
        		@android.webkit.JavascriptInterface
				public void showName(){
        			Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        		}
        		@android.webkit.JavascriptInterface
        		public void showPass(){
        			 AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        			builder.setTitle("警示框");
        			builder.setMessage("密码不能为空");
        			builder.setPositiveButton("确定", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							
						}
					});
        			Dialog dialog=builder.create();
        			dialog.show();
        		}
        		@android.webkit.JavascriptInterface
        		public void showJump(String name){
        			Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        			intent.putExtra("name", name);
        			startActivity(intent);
        		}
        }, "demo");
    }
}
