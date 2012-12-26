package com.example.helloworld40;

import android.os.Bundle;
import android.app.Activity;
import android.view.Display;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

	Hero hero = new Hero();
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_game);
		

		super.onCreate(savedInstanceState);
		// 全屏显示窗口
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// 获取屏幕宽高
		Display display = getWindowManager().getDefaultDisplay();
		
		// 显示自定义的游戏View
		AnimationView mAnimView = new AnimationView(this,display.getWidth(), display.getHeight(), hero);
		setContentView(mAnimView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

}
