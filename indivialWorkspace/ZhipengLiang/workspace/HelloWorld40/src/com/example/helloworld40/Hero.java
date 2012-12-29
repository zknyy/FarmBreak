package com.example.helloworld40;

public class Hero {

	public int life = 3;//3条命
	
	public int penOff = 20;//笔的偏移12个pix
	
	/**主角行走步长**/
	public int step = 15;//主角的步长8个pix
	
	
	/**与实体层发生碰撞**/
	public boolean isAcotrCollision = false;
	/**与边界层发生碰撞**/
	public boolean isBorderCollision = false;
	/**与人物发生碰撞**/
	public boolean isPersonCollision = false;
	


	/**人物图片资源与实际英雄脚底板坐标的偏移**/
	public final static int OFF_HERO_X = 16;
	public final static int OFF_HERO_Y = 35;


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


  //英雄在地图中的坐标以英雄脚底中心为原点
  int mHeroPosX = 20;
  int mHeroPosY= 20;

  //备份英雄发生碰撞以前的坐标点
  int mBackHeroPosX = 100;
  int mBackHeroPosY= 110;

  //英雄在地图中绘制坐标
  int mHeroImageX = 100;
  int mHeroImageY= 110;

  //英雄在地图二位数组中的索引
  int mHeroIndexX = 3;
  int mHeroIndexY= 3;
  
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
