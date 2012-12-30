package com.lzh.farmbreak;

import android.content.Context;

public abstract class Task {
	

	public static final int TASK1 =1;

	public static final int TASK2 =2;

	public static final int TASK3 =3;
	
	public Hero hero;
	
	public GameMap gameMap;
	
	public Context context;
	
	public int [][] recoverArea;//恢复区域包括恢复点public int [][] recoverPoint;
	
	public static Task getTask(int taskNum,Context context){

		switch (taskNum) {
		case TASK1:
			return new TaskRound1(context);
//			break;
		case TASK2:
			return null;
//			break;
		case TASK3:
			return null;
//			break;
		}
		return null;
	}

	public void getHurted(){
		int i = --this.hero.lifeNum;//2
		int [] layer3_top = this.gameMap.getMapExtraLayer3()[0];
		int j = layer3_top.length-1;//第一行整条的格子数
		for (;i>0;i--){
			layer3_top[j]=0;
			j--;
		}
	}
	
//	public void updateLifeOnMap(){
//		int i = this.hero.lifeNum;//3
//		int [] layer3_top = this.gameMap.getMapExtraLayer3()[0];
//		int j = layer3_top.length-1;//第一行整条的格子数
//		for (;i>0;i--){
//			layer3_top[j]=27;
//			j--;
//		}
//	}

	

	//隐藏层,恢复区域
//	  <object x="0" y="0" width="440" height="720"/>
//	  <object x="440" y="0" width="840" height="320"/>
//	  <object x="440" y="320" width="840" height="400"/>
//	private int [][] recoverArea  = {
//			{0,0,440,720},
//			{440,0,840,320},
//			{440,320,840,400}
//	};
//	//回复点所在的Tile坐标
//	private int [][] recoverPoint  = {
//			{2,2},{11,6},{29,8}			
//	};
	public void recover(){
		int [][]point = this.gameMap.getRecoverPoint();
		int [][]area = this.gameMap.getRecoverArea();
		for(int i=0;i<area.length;i++){
			int minX = area[i][0];
			int minY = area[i][1];
			int maxX = area[i][2]+minX;
			int maxY = area[i][3]+minY;
			
			if((minX < hero.heroPosX)&&(hero.heroPosX< maxX)
					&&(minY < hero.heroPosY)&&(hero.heroPosY< maxY)){
				this.hero.heroPosX = area[i][0]*GameMap.TILE_WIDTH;
				this.hero.heroPosY = area[i][1]*GameMap.TILE_HEIGHT;
			}
		}
	}

}
