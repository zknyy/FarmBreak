package com.lzh.farmbreak;

import android.content.Context;

public class GMTask1 extends GameMap{

	public GMTask1(Context context) {
		super(context);
	}


	//第一层游戏View地图数组
	//从游戏画面来是路
	private int [][]mapRoadLayer1 = {
			{	0,45,34,45,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,34,34,34,34,34,34,34,34,45,34,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,34,34,34,34,34,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,34,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,34,45,34,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,0,	},
			{	0,45,34,45,0,0,0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,0,	},
			{	0,34,45,34,0,0,0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,34,34,34,34,45,34,45,0,	},
			{	0,45,34,45,0,0,0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,0,	},
			{	0,34,45,34,0,0,0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,34,34,34,34,45,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,34,34,34,34,45,34,45,34,0,	},
			{	0,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,0,	},
			{	0,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,45,34,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0	}

		};

	//第二层游戏实体actor数组,也用于碰撞
	private int [][]mapObjLayer2  = {
			{	26,4,4,4,46,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,47,54,	},
			{	26,15,15,15,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,10,10,10,0,0,0,0,13,49,13,49,13,49,13,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,10,10,10,0,0,0,0,16,13,16,13,16,13,16,0,0,0,10,10,10,10,10,10,10,0,0,0,23,	},
			{	26,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,12,12,12,12,12,12,12,0,0,0,23,	},
			{	26,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,12,12,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,0,0,0,0,0,0,10,10,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,0,0,0,23,	},
			{	26,0,0,0,0,0,0,0,0,0,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,13,13,13,0,0,0,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,35,36,37,0,0,0,10,10,0,0,0,0,0,0,0,0,0,0,0,14,14,14,14,0,0,0,0,23,	},
			{	26,0,0,0,46,47,48,0,0,0,10,10,0,0,0,0,22,22,22,22,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,13,13,13,0,0,0,10,10,0,0,0,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,0,0,0,0,0,0,10,10,0,0,0,10,10,0,0,0,0,0,55,55,55,55,0,0,0,0,0,23,	},
			{	26,0,0,0,0,0,0,0,0,0,10,10,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	26,0,0,0,0,0,0,0,0,0,12,12,0,0,0,12,12,12,12,0,0,0,0,0,0,0,0,0,0,0,0,23,	},
			{	32,36,36,36,36,36,36,36,36,36,36,37,20,20,20,35,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,21	}

		};

	//第三层,修饰的花边 和 游戏血槽
	private int [][]mapExtraLayer3  = {
			{	0,6,6,7,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,27,27,27,	},
			{	0,0,0,6,6,6,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,7,0,0,0,6,6,2,38,2,38,2,38,2,0,0,0,6,6,6,6,6,6,6,0,0,0,0,	},
			{	0,0,0,0,0,7,0,0,0,0,0,5,2,5,2,5,2,5,0,0,0,1,1,1,1,1,1,1,6,0,0,0,	},
			{	0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,6,6,6,6,6,0,0,0,	},
			{	0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,2,2,2,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,11,11,11,0,0,0,7,7,7,7,0,0,0,0,0,	},
			{	0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,1,6,6,6,6,6,6,6,7,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,7,7,6,6,6,44,44,44,44,6,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,6,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	},
			{	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0	}

		};

	//隐藏层,恢复区域

//	  <object x="0" y="0" width="440" height="720"/>
//	  <object x="440" y="0" width="840" height="320"/>
//	  <object x="440" y="320" width="840" height="400"/>
	private int [][] recoverArea  = {
			{0,0,440,720},
			{440,0,840,320},
			{440,320,840,400}
	};
	

	//回复点所在的Tile坐标
	private int [][] recoverPoint  = {
			{2,2},{11,6},{29,8}			
		};


	public int[][] getRecoverArea() {
		return recoverArea;
	}


	public int[][] getMapRoadLayer1() {
		return mapRoadLayer1;
	}


	public int[][] getMapObjLayer2() {
		return mapObjLayer2;
	}


	public int[][] getMapExtraLayer3() {
		return mapExtraLayer3;
	}


	public int[][] getRecoverPoint() {
		return recoverPoint;
	}

}
