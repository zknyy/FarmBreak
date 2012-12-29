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

	public void updateLifeOnMap(){
		int i = this.hero.lifeNum;//3
		int [] layer3_top = this.gameMap.getMapExtraLayer3()[0];
		int j = layer3_top.length-1;//第一行整条的格子数
		for (;i>0;i--){
			layer3_top[j]=27;
			j--;
		}
	}
}
