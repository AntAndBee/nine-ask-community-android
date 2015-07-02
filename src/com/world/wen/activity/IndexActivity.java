/**
 * 
 */
package com.world.wen.activity;

import com.world.wen.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

/**
 * @author jswu
 *
 */
public class IndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置屏幕没有标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.index);
		
		GridView tectGV = (GridView)findViewById(R.id.techGV);
		
		
	}
}
