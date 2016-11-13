package com.bw.songjialin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	private TextView mTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		mTv=(TextView) findViewById(R.id.tv);
		
		String name=getIntent().getStringExtra("name");
		mTv.setText(name);
	}

}
