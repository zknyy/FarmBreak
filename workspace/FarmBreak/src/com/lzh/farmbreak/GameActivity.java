package com.lzh.farmbreak;

import android.os.Bundle;
import android.app.Activity;
import android.view.Display;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.samsung.spen.lib.input.SPenEventLibrary;

public class GameActivity extends Activity {

//	Hero hero = Hero.getHero(Hero.HERO_CHICK);//��һ��,С��
	Task task;

    SPenEventLibrary spel = new SPenEventLibrary();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_game);
		

		super.onCreate(savedInstanceState);
		// ȫ����ʾ����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// ��ȡ��Ļ���
		Display display = getWindowManager().getDefaultDisplay();
		
		task = Task.getTask(Task.TASK1, this);
		// ��ʾ�Զ������ϷView
		AnimationView mAnimView = new AnimationView(this,display.getWidth(), display.getHeight(), this.task.hero);
		setContentView(mAnimView);
		
		
		//���SPen�ļ�����

	    spel.setSPenTouchListener(mAnimView, new TouchListener());//*/
	    spel.setSPenHoverListener(mAnimView, new HoverListener(this.task.hero));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

}
