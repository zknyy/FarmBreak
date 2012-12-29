package com.lzh.farmbreak;

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
	
    gameMap=new GameMapRound1(context);
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
	    hero.mHeroAnim[hero.ANIM_DOWN] = new Animation(context,new int []{R.drawable.chick,R.drawable.chick,R.drawable.chick,R.drawable.chick},true);
	    hero.mHeroAnim[hero.ANIM_LEFT] = new Animation(context,new int []{R.drawable.chick,R.drawable.chick,R.drawable.chick,R.drawable.chick},true);
	    hero.mHeroAnim[hero.ANIM_RIGHT]= new Animation(context,new int []{R.drawable.chick,R.drawable.chick,R.drawable.chick,R.drawable.chick},true);
	    hero.mHeroAnim[hero.ANIM_UP]   = new Animation(context,new int []{R.drawable.chick,R.drawable.chick,R.drawable.chick,R.drawable.chick},true);
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
		
		Log.v("hero", "x: "+hero.heroPosX+" y:"+hero.heroPosY);
		
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
			if (hero.heroPosX <= 0) {
				hero.heroPosX = 0;
			    hero.isBorderCollision =true;
			} else if (hero.heroPosX >= mScreenWidth) {
				hero.heroPosX = mScreenWidth;
			    hero.isBorderCollision =true;
			}
			if (hero.heroPosY <= 0) {
				hero.heroPosY = 0;
			    hero.isBorderCollision =true;
			} else if (hero.heroPosY >= mScreenHeight) {
				hero.heroPosY = mScreenHeight;
				hero.isBorderCollision =true;
			}
		
			/** ���Ӣ���ƶ����ڵ�ͼ��λ�����е����� **/
			hero.heroIndexX=hero.heroPosX / GameMap.TILE_WIDTH;
			hero.heroIndexY=hero.heroPosY / GameMap.TILE_HEIGHT;
		
			/** Խ���� **/
//			int width = this.gameMap.mMapExtraLayer3[hero.mHeroIndexY].length - 1;
//			int height = this.gameMap.mMapExtraLayer3.length - 1;
			int width = this.gameMap.getMapObjLayer2()[hero.heroIndexY].length - 1;
			int height = this.gameMap.getMapObjLayer2().length - 1;
		
			if (hero.heroIndexX <= 0) {
				hero.heroIndexX = 0;
			} else if (hero.heroIndexX >= width) {
				hero.heroIndexX = width;
			}
			if (hero.heroIndexY <= 0) {
				hero.heroIndexY = 0;
			} else if (hero.heroIndexY >= height) {
				hero.heroIndexY = height;
			}
//			if (this.gameMap.mMapExtraLayer3[hero.mHeroIndexY][hero.mHeroIndexX] == -1) {
			if (this.gameMap.getMapObjLayer2()[hero.heroIndexY][hero.heroIndexX] !=0){//== -1) {
				hero.heroPosX = hero.backHeroPosX;
				hero.heroPosY = hero.backHeroPosY;
			    hero.isAcotrCollision = true;
			} else {
				hero.backHeroPosX = hero.heroPosX;
				hero.backHeroPosY = hero.heroPosY;
			    hero.isAcotrCollision = false;
			}
			/** ���������Ƶ�XY���� **/
			hero.heroImageX = hero.heroPosX - hero.heroOffX;//Hero.OFF_HERO_X;
			hero.heroImageY = hero.heroPosY - hero.heroOffY;//Hero.OFF_HERO_Y;
//	    }
	}
	private void RenderAnimation(Canvas canvas) {
	    if (mAllkeyDown) {
		/**�������Ƕ���**/
	    	hero.mHeroAnim[mAnimationState].DrawAnimation(canvas, mPaint, hero.heroImageX, hero.heroImageY);
	    }else {
		/**����̧�������ֹͣ����**/
	    	hero.mHeroAnim[mAnimationState].DrawFrame(canvas, mPaint, hero.heroImageX, hero.heroImageY, 0);
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
		if(this.posY>this.hero.heroPosY){
			mAnimationState = Hero.ANIM_DOWN;
			if(this.posY-this.hero.heroPosY>hero.step){
				this.hero.heroPosY += hero.step;
			}else{
				this.hero.heroPosY += this.posY-this.hero.heroPosY;				
			}
		}
		//��
		if(this.posX>this.hero.heroPosX){
			mAnimationState = Hero.ANIM_RIGHT;
			if(this.posX-this.hero.heroPosX>hero.step){
				this.hero.heroPosX += hero.step;
			}else{
				this.hero.heroPosX += this.posX-this.hero.heroPosX;				
			}
		}
		//��
		if(this.posY<this.hero.heroPosY){
			mAnimationState = Hero.ANIM_UP;
			if(this.hero.heroPosY-this.posY>hero.step){
				this.hero.heroPosY -= hero.step;
			}else{
				this.hero.heroPosY -= this.hero.heroPosY-this.posY;				
			}
		}
		//��
		if(this.posX<this.hero.heroPosX){
			mAnimationState = Hero.ANIM_LEFT;
			if(this.hero.heroPosX-this.posX>hero.step){
				this.hero.heroPosX -= hero.step;
			}else{
				this.hero.heroPosX -= this.hero.heroPosX-this.posX;				
			}
		}
	}

}