package com.world.wen;

import com.world.wen.activity.BaseActivity;
import com.world.wen.activity.IndexActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {
	// 进入按钮
	private Button btnEnter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		initEvent();
	}
	
	/**
	 * 初始化界面控
	 */
	private void initView() {
		btnEnter = (Button) findViewById(R.id.btnEnter);
	}
	
	/**
	 * 初始化事件
	 */
	private void initEvent() {
		btnEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, IndexActivity.class);
				startActivity(intent);
			}
		});
	}
}
