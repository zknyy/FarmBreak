package com.example.helloworld40;

public abstract class Task {
	

	public static final int TASK1 =1;

	public static final int TASK2 =2;

	public static final int TASK3 =3;
	
	public Hero hero;
	
	public GameMap gameMap;
	
	public int [][] recoverArea;//�ָ���������ָ���public int [][] recoverPoint;
	
	public static Task getTask(int taskNum){

		switch (taskNum) {
		case TASK1:
			return new TaskRound1();
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

}
