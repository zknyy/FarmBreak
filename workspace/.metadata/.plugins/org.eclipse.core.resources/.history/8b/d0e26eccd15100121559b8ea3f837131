package com.example.helloworld40;

import android.view.KeyEvent;

public abstract class Hero {


	public static final int HERO_CHICK =1;
	public static final int HERO_DOG =2;
	public static final int HERO_SHEEP =3;
	
	//根据关卡得到主角
	public static Hero getHero(int heroNum){
		switch (heroNum) {
		case HERO_CHICK:
			return new HChick();
//			break;
		case HERO_DOG:
			return null;
//			break;
		case HERO_SHEEP:
			return null;
//			break;
		}
		return null;
	}

	/**向下移动动画**/
    public final static int ANIM_DOWN = 0;
    /**向左移动动画**/
    public final static int ANIM_LEFT = 1;
    /**向右移动动画**/
    public final static int ANIM_RIGHT = 2;
    /**向上移动动画**/
    public final static int ANIM_UP = 3;
    /**动画的总数量**/
    public final static int ANIM_COUNT = 4;

    Animation mHeroAnim [] = new Animation[ANIM_COUNT];

	public int lifeNum = 3;//3条命


	/**与实体层发生碰撞**/
	public boolean isAcotrCollision = false;
	/**与边界层发生碰撞**/
	public boolean isBorderCollision = false;
	/**与人物发生碰撞**/
	public boolean isPersonCollision = false;
	
	
	//----------begin--------------------------每个子类不同
	public int penOff;//笔的偏移12个pix
	
	/**主角行走步长**/
	public int step;//主角的步长8个pix

//	/**人物图片资源与实际英雄脚底板坐标的偏移**/
//	public   int OFF_HERO_X = 20;//16
//	public   int OFF_HERO_Y = 20;//35

	public   int heroOffX;//20//16
	public   int heroOffY;//20//35

	  //英雄在地图中的坐标以英雄脚底中心为原点
	public  int heroPosX ;//100//20;
	public  int heroPosY;//110//20;

	  //备份英雄发生碰撞以前的坐标点
	public  int backHeroPosX ;//100;
	public  int backHeroPosY;//110;

	  //英雄在地图中绘制坐标
	public  int heroImageX ;//100;
	public  int heroImageY;//110;

	  //英雄在地图二位数组中的索引
	public  int heroIndexX ;// 3;
	public  int heroIndexY;// 3;
	
	//四个碰撞点
	public int[][] hitPoints ;
//	= {
//			{0,0},	{0,40},	{40,0},	{40,40}
//	};	

	//----------end---------------------------每个子类不同

  
  //原private void initHero()函数
  public Hero(){
//	    mHeroImageX = 100;
//	    mHeroImageY = 100;
//	    /**根据图片显示的坐标算出英雄脚底的坐标 **/
//	    /**X轴+图片宽度的一半 Y轴加图片的高度 **/
//	    mHeroPosX = mHeroImageX + OFF_HERO_X; 
//	    mHeroPosY = mHeroImageY + OFF_HERO_Y;
//	    mHeroIndexX = mHeroPosX / GameMap.TILE_WIDTH;
//	    mHeroIndexY = mHeroPosY / GameMap.TILE_HEIGHT;
	}
  

}
