/**
 * 
 */
package com.world.wen.activity;

import com.world.wen.R;
import com.world.wen.util.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * @author jswu
 *
 */
public class IndexActivity extends BaseActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置屏幕没有标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.index);
		
		GridView tectGV = (GridView)findViewById(R.id.techGV);
		
		getGVData();
	}
	
	public void getGVData() {
		post(Constants.ALL_TOPIC, addParam(Constants.ALL_TOPIC), false,"TAG");
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		
	}
}
