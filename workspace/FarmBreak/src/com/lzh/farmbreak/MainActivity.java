package com.lzh.farmbreak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener{
	private MediaPlayer mBgSound;			//背景音使用MediaPlayer
	private ImageButton startGame;			//图片按钮
	private ImageButton soundSwitch;		//图片按钮
	private boolean isSound;				//背景音开关
    Context context = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
	//全屏,一定要放在setContentView之前，要不然会报错
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,  
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	initSounds();						//初始化背景音
	mBgSound.start();					//播放背景音
	setContentView(R.layout.activity_main);
	context = this;
	
	/**进入游戏世界**/
	startGame=(ImageButton) this.findViewById(R.id.imageButton2);	//加载开始图片按钮
	startGame.setOnClickListener(new OnClickListener() {			//为开始游戏按钮添加监听
	    @Override
	    public void onClick(View arg0) {
		 Intent intent = new Intent(context,GameActivity.class); 
		 startActivity(intent);			//启动新activitiy
	    }
	}); 
	soundSwitch=(ImageButton) this.findViewById(R.id.imageButton1);
	soundSwitch.setOnClickListener(this);
	}
	private void initSounds() {					//初始化声音的方法
		//初始化背景音
		mBgSound = MediaPlayer.create(this,R.raw.backsound);//初始化MediaPlayer
		mBgSound.setLooping(true);			//设置循环播放
		isSound=true;									//背景音开关标志
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	public void onClick(View v) 
	{
		if(v==soundSwitch)
		{
			
			isSound=!isSound;					//将声音开关取反
			if(isSound)							//需要播放
			{
				if(mBgSound!=null)				//保险起见，判断mBgSound是否为空
					if(!mBgSound.isPlaying())	//如果当时不在播放
					{
						mBgSound.start();		//才开始播放
						soundSwitch.setImageResource(R.drawable.horn);
					}
			}
			else								//不需要播放
			{
				if(mBgSound!=null)				//保险起见，判断mBgSound是否为空
					if(mBgSound.isPlaying())	//如果当时正在播放
					{
						mBgSound.pause();		//才暂停
						soundSwitch.setImageResource(R.drawable.horn2);
					}
			}
		}
	}
}
