package com.lzh.farmbreak;

import android.content.Context;

public class TaskRound1 extends Task {
	
	public TaskRound1(Context context){
		
		this.context = context;
		
		this.hero =  Hero.getHero(Hero.HERO_CHICK);//第一关,小鸡
	
		this.gameMap = new GameMapRound1(this.context);
	}

}
