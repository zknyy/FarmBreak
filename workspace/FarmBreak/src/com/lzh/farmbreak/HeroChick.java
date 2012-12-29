package com.lzh.farmbreak;

public class HeroChick extends Hero{

	
	public HeroChick() {
		super();

		this.penOff = 20;//笔的偏移12个pix
		
		/**主角行走步长**/
		this.step = 15;//主角的步长8个pix

//		/**人物图片资源与实际英雄脚底板坐标的偏移**/
//		private   int OFF_HERO_X = 20;//16
//		private   int OFF_HERO_Y = 20;//35

		this.heroOffX = 20;//16
		this.heroOffY = 20;//35

		  //英雄在地图中的坐标以英雄脚底中心为原点
		this.heroPosX = 20;
		this.heroPosY= 20;

		  //备份英雄发生碰撞以前的坐标点
		this.backHeroPosX = 80;//120;
		this.backHeroPosY= 120;

		  //英雄在地图中绘制坐标
		this.heroImageX = 80;//120;
		this.heroImageY= 120;

		  //英雄在地图二位数组中的索引
		this.heroIndexX = 2;
		this.heroIndexY= 2;
		
		//四个碰撞点
		this.hitPoints = new int[][]{
				{0,0},	{0,40},	{40,0},	{40,40}
		};
	}


}
