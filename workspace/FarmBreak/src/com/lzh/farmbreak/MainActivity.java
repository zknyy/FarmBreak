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
	private MediaPlayer mBgSound;			//������ʹ��MediaPlayer
	private ImageButton startGame;			//ͼƬ��ť
	private ImageButton soundSwitch;		//ͼƬ��ť
	private boolean isSound;				//����������
    Context context = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
	//ȫ��,һ��Ҫ����setContentView֮ǰ��Ҫ��Ȼ�ᱨ��
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,  
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	initSounds();						//��ʼ��������
	mBgSound.start();					//���ű�����
	setContentView(R.layout.activity_main);
	context = this;
	
	/**������Ϸ����**/
	startGame=(ImageButton) this.findViewById(R.id.imageButton2);	//���ؿ�ʼͼƬ��ť
	startGame.setOnClickListener(new OnClickListener() {			//Ϊ��ʼ��Ϸ��ť��Ӽ���
	    @Override
	    public void onClick(View arg0) {
		 Intent intent = new Intent(context,GameActivity.class); 
		 startActivity(intent);			//������activitiy
	    }
	}); 
	soundSwitch=(ImageButton) this.findViewById(R.id.imageButton1);
	soundSwitch.setOnClickListener(this);
	}
	private void initSounds() {					//��ʼ�������ķ���
		//��ʼ��������
		mBgSound = MediaPlayer.create(this,R.raw.backsound);//��ʼ��MediaPlayer
		mBgSound.setLooping(true);			//����ѭ������
		isSound=true;									//���������ر�־
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
			
			isSound=!isSound;					//����������ȡ��
			if(isSound)							//��Ҫ����
			{
				if(mBgSound!=null)				//����������ж�mBgSound�Ƿ�Ϊ��
					if(!mBgSound.isPlaying())	//�����ʱ���ڲ���
					{
						mBgSound.start();		//�ſ�ʼ����
						soundSwitch.setImageResource(R.drawable.horn);
					}
			}
			else								//����Ҫ����
			{
				if(mBgSound!=null)				//����������ж�mBgSound�Ƿ�Ϊ��
					if(mBgSound.isPlaying())	//�����ʱ���ڲ���
					{
						mBgSound.pause();		//����ͣ
						soundSwitch.setImageResource(R.drawable.horn2);
					}
			}
		}
	}
}
