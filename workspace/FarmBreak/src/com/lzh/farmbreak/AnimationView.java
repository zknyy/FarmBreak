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
	//添加一个用于接受屏幕触屏的事件
    int touchAction ;
    
    
    Paint mPaint = null;

/**任意键被按下**/
private boolean mAllkeyDown = false;
/**按键下**/
private boolean mIskeyDown = false;
/**按键左**/
private boolean mIskeyLeft = false;
/**按键右**/
private boolean mIskeyRight = false;
/**按键上**/
private boolean mIskeyUp = false;

//当前绘制动画状态ID
int mAnimationState = 0;

//资源文件
Resources mResources = null;


//屏幕宽高才尺寸
int mScreenWidth = 0;
int mScreenHeight = 0;



//分离出来的GameMap类
GameMap gameMap = null;
Hero hero = null;
/**
 * 构造方法
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
	    //这里可以用循环来处理总之我们需要把动画的ID传进去
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
		
	    /**绘制地图**///整个地图重绘,如果没有无法看到场景
		this.gameMap.drawMap(canvas, mPaint);
		
		
	    /**绘制动画**///Hero自己的步行姿态--图片切换,没有这个就看不到Hero
		RenderAnimation(canvas);
		
		
	    /**更新动画**///更新Hero的移动,没有这个Hero无法移动,只能原地踏步
		UpdateAnimation();

		if (hero.isBorderCollision) {
			DrawCollision(canvas, "与边界发生碰撞");
		}

		if (hero.isAcotrCollision) {
			DrawCollision(canvas, "与实体层发生碰撞");
		}
		if (hero.isPersonCollision) {
			DrawCollision(canvas, "与NPC发生碰撞");
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
		
		//按键和触屏都能移动
//	    if (mAllkeyDown|| this.touchAction==MotionEvent.ACTION_MOVE
//	    		||this.touchAction==MotionEvent.ACTION_DOWN) {
		
			/** 根据按键更新显示动画 **/
			/** 在碰撞数组中寻找看自己是否与地图物理层发生碰撞 **/
	    	//用按键进行游戏
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
			
			//添加一个触屏的移动函数
//			this.touchHeroMove();
		
			/** 检测人物是否出屏 **/
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
		
			/** 算出英雄移动后在地图二位数组中的索引 **/
			hero.heroIndexX=hero.heroPosX / GameMap.TILE_WIDTH;
			hero.heroIndexY=hero.heroPosY / GameMap.TILE_HEIGHT;
		
			/** 越界检测 **/
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
			/** 算出人物绘制的XY坐标 **/
			hero.heroImageX = hero.heroPosX - hero.heroOffX;//Hero.OFF_HERO_X;
			hero.heroImageY = hero.heroPosY - hero.heroOffY;//Hero.OFF_HERO_Y;
//	    }
	}
	private void RenderAnimation(Canvas canvas) {
	    if (mAllkeyDown) {
		/**绘制主角动画**/
	    	hero.mHeroAnim[mAnimationState].DrawAnimation(canvas, mPaint, hero.heroImageX, hero.heroImageY);
	    }else {
		/**按键抬起后人物停止动画**/
	    	hero.mHeroAnim[mAnimationState].DrawFrame(canvas, mPaint, hero.heroImageX, hero.heroImageY, 0);
	    }
	}

	/**
	 * 设置按键状态true为按下 false为抬起
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
	 * 程序切割图片
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
	 * 读取本地资源的图片
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
		// 获取资源图片
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

	/**
	 * 绘制画带阴影的文字
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

	/** 触摸后在屏幕中显示的位置 **/
	int lastPosX = 0;
	int lastPosY = 0;
	int posX = 0;
	int posY = 0;

	/*
	 * 触摸屏幕事件,让hero行走(non-Javadoc)
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
//		// 触摸按下的事件
//		case MotionEvent.ACTION_DOWN:
//			Log.v("test", "ACTION_DOWN");
//			break;
//		// 触摸移动的事件
//		case MotionEvent.ACTION_MOVE:
//			Log.v("test", "ACTION_MOVE");
//			break;
//		// 触摸抬起的事件
//		case MotionEvent.ACTION_UP:
//			Log.v("test", "ACTION_UP");
//			break;
//		}
//		/** 得到事件触发时间 **/
//		// mActionTime = event.getEventTime();
//		/** 通知UI线程刷新屏幕 **/
//		// postInvalidate();
//		// invalidate();
//		// return super.onTouchEvent(event);
//		Log.v("mouse", "x:" + posX + " y:" + posY);
//		return true;
//	}
	//添加一个触屏的移动函数
	private void touchHeroMove(){
		//下
		if(this.posY>this.hero.heroPosY){
			mAnimationState = Hero.ANIM_DOWN;
			if(this.posY-this.hero.heroPosY>hero.step){
				this.hero.heroPosY += hero.step;
			}else{
				this.hero.heroPosY += this.posY-this.hero.heroPosY;				
			}
		}
		//右
		if(this.posX>this.hero.heroPosX){
			mAnimationState = Hero.ANIM_RIGHT;
			if(this.posX-this.hero.heroPosX>hero.step){
				this.hero.heroPosX += hero.step;
			}else{
				this.hero.heroPosX += this.posX-this.hero.heroPosX;				
			}
		}
		//上
		if(this.posY<this.hero.heroPosY){
			mAnimationState = Hero.ANIM_UP;
			if(this.hero.heroPosY-this.posY>hero.step){
				this.hero.heroPosY -= hero.step;
			}else{
				this.hero.heroPosY -= this.hero.heroPosY-this.posY;				
			}
		}
		//左
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