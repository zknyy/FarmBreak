package com.example.helloworld40;

import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	//���һ�����ڽ�����Ļ�������¼�
    int touchAction ;
    
    
    Paint mPaint = null;

/**�����������**/
private boolean mAllkeyDown = false;
/**������**/
private boolean mIskeyDown = false;
/**������**/
private boolean mIskeyLeft = false;
/**������**/
private boolean mIskeyRight = false;
/**������**/
private boolean mIskeyUp = false;

//��ǰ���ƶ���״̬ID
int mAnimationState = 0;

//��Դ�ļ�
Resources mResources = null;


//��Ļ��߲ųߴ�
int mScreenWidth = 0;
int mScreenHeight = 0;



//���������GameMap��
GameMap gameMap = null;
Hero hero = null;
/**
 * ���췽��
 * 
 * @param context
 */
public AnimationView(Context context,int screenWidth, int screenHeight,Hero hero) {
	
    super(context);
    
    this.hero=hero;
	
    gameMap=new GameMap(context);
    mPaint = new Paint();
    mScreenWidth = screenWidth;
    mScreenHeight = screenHeight;  
    initAnimation(context);
}

	
	//private void initMap(Context context) {
	//    mBitmap = ReadBitMap(context, R.drawable.map);
	//    mBitMapWidth = mBitmap.getWidth();
	//    mBitMapHeight = mBitmap.getHeight();
	//    mWidthTileCount = mBitMapWidth / TILE_WIDTH;
	//    mHeightTileCount = mBitMapHeight / TILE_HEIGHT;
	//}
	
	private void initAnimation(Context context) {
	    //���������ѭ����������֮������Ҫ�Ѷ�����ID����ȥ
	//    hero.mHeroAnim[hero.ANIM_DOWN] = new Animation(context,new int []{R.drawable.hero_down_a,R.drawable.hero_down_b,R.drawable.hero_down_c,R.drawable.hero_down_d},true);
	//    hero.mHeroAnim[hero.ANIM_LEFT] = new Animation(context,new int []{R.drawable.hero_left_a,R.drawable.hero_left_b,R.drawable.hero_left_c,R.drawable.hero_left_d},true);
	//    hero.mHeroAnim[hero.ANIM_RIGHT]= new Animation(context,new int []{R.drawable.hero_right_a,R.drawable.hero_right_b,R.drawable.hero_right_c,R.drawable.hero_right_d},true);
	//    hero.mHeroAnim[hero.ANIM_UP]   = new Animation(context,new int []{R.drawable.hero_up_a,R.drawable.hero_up_b,R.drawable.hero_up_c,R.drawable.hero_up_d},true);
	    hero.mHeroAnim[hero.ANIM_DOWN] = new Animation(context,new int []{R.drawable.dog40,R.drawable.dog40,R.drawable.dog40,R.drawable.dog40},true);
	    hero.mHeroAnim[hero.ANIM_LEFT] = new Animation(context,new int []{R.drawable.dog40,R.drawable.dog40,R.drawable.dog40,R.drawable.dog40},true);
	    hero.mHeroAnim[hero.ANIM_RIGHT]= new Animation(context,new int []{R.drawable.dog40,R.drawable.dog40,R.drawable.dog40,R.drawable.dog40},true);
	    hero.mHeroAnim[hero.ANIM_UP]   = new Animation(context,new int []{R.drawable.dog40,R.drawable.dog40,R.drawable.dog40,R.drawable.dog40},true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
	    /**���Ƶ�ͼ**///������ͼ�ػ�,���û���޷���������
		this.gameMap.drawMap(canvas, mPaint);
		
		
	    /**���ƶ���**///Hero�Լ��Ĳ�����̬--ͼƬ�л�,û������Ϳ�����Hero
		RenderAnimation(canvas);
		
		
	    /**���¶���**///����Hero���ƶ�,û�����Hero�޷��ƶ�,ֻ��ԭ��̤��
		UpdateAnimation();

		if (hero.isBorderCollision) {
			DrawCollision(canvas, "��߽緢����ײ");
		}

		if (hero.isAcotrCollision) {
			DrawCollision(canvas, "��ʵ��㷢����ײ");
		}
		if (hero.isPersonCollision) {
			DrawCollision(canvas, "��NPC������ײ");
		}
		super.onDraw(canvas);
		
		Log.v("hero", "x: "+hero.mHeroPosX+" y:"+hero.mHeroPosY);
		
		invalidate();
	}

	private void DrawCollision(Canvas canvas, String str) {
		drawRimString(canvas, str, Color.WHITE, mScreenWidth >> 1,
				mScreenHeight >> 1);
	}

	private void UpdateAnimation() {
		
		//�����ʹ��������ƶ�
//	    if (mAllkeyDown|| this.touchAction==MotionEvent.ACTION_MOVE
//	    		||this.touchAction==MotionEvent.ACTION_DOWN) {
		
			/** ���ݰ���������ʾ���� **/
			/** ����ײ������Ѱ�ҿ��Լ��Ƿ����ͼ����㷢����ײ **/
	    	//�ð���������Ϸ
//			if (mIskeyDown) {
//			    mAnimationState = hero.ANIM_DOWN;
//			    hero.mHeroPosY += hero.step;
//			} else if (mIskeyLeft) {
//			    mAnimationState = hero.ANIM_LEFT;
//			    hero.mHeroPosX -= hero.step;
//			} else if (mIskeyRight) {
//			    mAnimationState = hero.ANIM_RIGHT;
//			    hero.mHeroPosX += hero.step;
//			} else if (mIskeyUp) {
//			    mAnimationState = hero.ANIM_UP;
//			    hero.mHeroPosY -= hero.step;
//			}
			
			//���һ���������ƶ�����
//			this.touchHeroMove();
		
			/** ��������Ƿ���� **/
			hero.isBorderCollision = false;
			if (hero.mHeroPosX <= 0) {
				hero.mHeroPosX = 0;
			    hero.isBorderCollision =true;
			} else if (hero.mHeroPosX >= mScreenWidth) {
				hero.mHeroPosX = mScreenWidth;
			    hero.isBorderCollision =true;
			}
			if (hero.mHeroPosY <= 0) {
				hero.mHeroPosY = 0;
			    hero.isBorderCollision =true;
			} else if (hero.mHeroPosY >= mScreenHeight) {
				hero.mHeroPosY = mScreenHeight;
				hero.isBorderCollision =true;
			}
		
			/** ���Ӣ���ƶ����ڵ�ͼ��λ�����е����� **/
			hero.mHeroIndexX = hero.mHeroPosX / GameMap.TILE_WIDTH;
			hero.mHeroIndexY = hero.mHeroPosY / GameMap.TILE_HEIGHT;
		
			/** Խ���� **/
//			int width = this.gameMap.mMapExtraLayer3[hero.mHeroIndexY].length - 1;
//			int height = this.gameMap.mMapExtraLayer3.length - 1;
			int width = this.gameMap.mMapObjLayer2[hero.mHeroIndexY].length - 1;
			int height = this.gameMap.mMapObjLayer2.length - 1;
		
			if (hero.mHeroIndexX <= 0) {
				hero.mHeroIndexX = 0;
			} else if (hero.mHeroIndexX >= width) {
				hero.mHeroIndexX = width;
			}
			if (hero.mHeroIndexY <= 0) {
				hero.mHeroIndexY = 0;
			} else if (hero.mHeroIndexY >= height) {
				hero.mHeroIndexY = height;
			}
//			if (this.gameMap.mMapExtraLayer3[hero.mHeroIndexY][hero.mHeroIndexX] == -1) {
			if (this.gameMap.mMapObjLayer2[hero.mHeroIndexY][hero.mHeroIndexX] !=0){//== -1) {
				hero.mHeroPosX = hero.mBackHeroPosX;
				hero.mHeroPosY = hero.mBackHeroPosY;
			    hero.isAcotrCollision = true;
			} else {
				hero.mBackHeroPosX = hero.mHeroPosX;
				hero.mBackHeroPosY = hero.mHeroPosY;
			    hero.isAcotrCollision = false;
			}
			/** ���������Ƶ�XY���� **/
			hero.mHeroImageX = hero.mHeroPosX - Hero.OFF_HERO_X;
			hero.mHeroImageY = hero.mHeroPosY - Hero.OFF_HERO_Y;
//	    }
	}
	private void RenderAnimation(Canvas canvas) {
	    if (mAllkeyDown) {
		/**�������Ƕ���**/
	    	hero.mHeroAnim[mAnimationState].DrawAnimation(canvas, mPaint, hero.mHeroImageX, hero.mHeroImageY);
	    }else {
		/**����̧�������ֹͣ����**/
	    	hero.mHeroAnim[mAnimationState].DrawFrame(canvas, mPaint, hero.mHeroImageX, hero.mHeroImageY, 0);
	    }
	}

	/**
	 * ���ð���״̬trueΪ���� falseΪ̧��
	 * 
	 * @param keyCode
	 * @param state
	 */
	public void setKeyState(int keyCode, boolean state) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_DOWN:
			mIskeyDown = state;
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			mIskeyUp = state;
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			mIskeyLeft = state;
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			mIskeyRight = state;
			break;
		}
		mAllkeyDown = state;
	}

	/**
	 * �����и�ͼƬ
	 * 
	 * @param bitmap
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public Bitmap BitmapClipBitmap(Bitmap bitmap, int x, int y, int w, int h) {
		return Bitmap.createBitmap(bitmap, x, y, w, h);
	}

	/**
	 * ��ȡ������Դ��ͼƬ
	 * 
	 * @param context
	 * @param resId
	 * @return
	 */
	public Bitmap ReadBitMap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// ��ȡ��ԴͼƬ
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

	/**
	 * ���ƻ�����Ӱ������
	 * 
	 * @param canvas
	 * @param str
	 * @param color
	 * @param x
	 * @param y
	 */
	public final void drawRimString(Canvas canvas, String str, int color,
			int x, int y) {
		int backColor = mPaint.getColor();
		mPaint.setColor(~color);
		canvas.drawText(str, x + 1, y, mPaint);
		canvas.drawText(str, x, y + 1, mPaint);
		canvas.drawText(str, x - 1, y, mPaint);
		canvas.drawText(str, x, y - 1, mPaint);
		mPaint.setColor(color);
		canvas.drawText(str, x, y, mPaint);
		mPaint.setColor(backColor);
	}

	/** ����������Ļ����ʾ��λ�� **/
	int lastPosX = 0;
	int lastPosY = 0;
	int posX = 0;
	int posY = 0;

	/*
	 * ������Ļ�¼�,��hero����(non-Javadoc)
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//
//		touchAction = event.getAction();
//		posX = (int) event.getX();
//		posY = (int) event.getY();
//		if (lastPosX != posX) {
//			lastPosX = posX;
//		}
//		if (lastPosY != posY) {
//			lastPosY = posY;
//		}
//
//		switch (touchAction) {
//		// �������µ��¼�
//		case MotionEvent.ACTION_DOWN:
//			Log.v("test", "ACTION_DOWN");
//			break;
//		// �����ƶ����¼�
//		case MotionEvent.ACTION_MOVE:
//			Log.v("test", "ACTION_MOVE");
//			break;
//		// ����̧����¼�
//		case MotionEvent.ACTION_UP:
//			Log.v("test", "ACTION_UP");
//			break;
//		}
//		/** �õ��¼�����ʱ�� **/
//		// mActionTime = event.getEventTime();
//		/** ֪ͨUI�߳�ˢ����Ļ **/
//		// postInvalidate();
//		// invalidate();
//		// return super.onTouchEvent(event);
//		Log.v("mouse", "x:" + posX + " y:" + posY);
//		return true;
//	}
	//���һ���������ƶ�����
	private void touchHeroMove(){
		//��
		if(this.posY>this.hero.mHeroPosY){
			mAnimationState = Hero.ANIM_DOWN;
			if(this.posY-this.hero.mHeroPosY>hero.step){
				this.hero.mHeroPosY += hero.step;
			}else{
				this.hero.mHeroPosY += this.posY-this.hero.mHeroPosY;				
			}
		}
		//��
		if(this.posX>this.hero.mHeroPosX){
			mAnimationState = Hero.ANIM_RIGHT;
			if(this.posX-this.hero.mHeroPosX>hero.step){
				this.hero.mHeroPosX += hero.step;
			}else{
				this.hero.mHeroPosX += this.posX-this.hero.mHeroPosX;				
			}
		}
		//��
		if(this.posY<this.hero.mHeroPosY){
			mAnimationState = Hero.ANIM_UP;
			if(this.hero.mHeroPosY-this.posY>hero.step){
				this.hero.mHeroPosY -= hero.step;
			}else{
				this.hero.mHeroPosY -= this.hero.mHeroPosY-this.posY;				
			}
		}
		//��
		if(this.posX<this.hero.mHeroPosX){
			mAnimationState = Hero.ANIM_LEFT;
			if(this.hero.mHeroPosX-this.posX>hero.step){
				this.hero.mHeroPosX -= hero.step;
			}else{
				this.hero.mHeroPosX -= this.hero.mHeroPosX-this.posX;				
			}
		}
	}

}