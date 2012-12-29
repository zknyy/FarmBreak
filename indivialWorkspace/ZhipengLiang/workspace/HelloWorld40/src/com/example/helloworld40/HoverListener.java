package com.example.helloworld40;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.samsung.spensdk.applistener.SPenHoverListener;

public class HoverListener implements SPenHoverListener {
	int posX;
	int posY;
	int lastPosX;
	int lastPosY;
	boolean atFirstTime = true;
	
	Hero hero;
	
	public HoverListener(Hero hero){
		this.hero = hero;
	}
	
	
	@Override
	public void onHoverButtonDown(View arg0, MotionEvent event) {
		Log.v("spen", "onHoverButtonDown " + event.getAction());

	}

	@Override
	public void onHoverButtonUp(View arg0, MotionEvent event) {
		Log.v("spen", "onHoverButtonUp " + event.getAction());

	}
	
	@Override
	public boolean onHover(View arg0, MotionEvent event) {
		
		
		
		//Log.v("spen", "onHover " + event.getAction());
		int touchAction = event.getAction();
		if(touchAction != 7){
			return false;
		}
//		if(this.hero.isAcotrCollision||hero.isBorderCollision||hero.isPersonCollision){
//			return false;
//		}
		
		
		posX = (int) event.getX();
		posY = (int) event.getY();
		
		if(this.atFirstTime){
			this.lastPosX = this.posX;
			this.lastPosY = this.posY;
			this.atFirstTime=false;
		}

//		if (lastPosX < posX+hero.penOff && lastPosX > posX-hero.penOff ) {
//			lastPosX = posX;
//		}
//		if (lastPosY < posY+hero.penOff && lastPosY > posY-hero.penOff ) {
//			lastPosY = posY;
//		}
//
//		this.hero.mHeroPosX = posX;
//		this.hero.mHeroPosY = posY;


		if ((lastPosX < (posX+hero.penOff) && lastPosX > (posX-hero.penOff) ) && 
		(lastPosY < (posY+hero.penOff) && lastPosY > (posY-hero.penOff) ) ){
			lastPosY = posY;
			lastPosX = posX;

			//this.hero.mBackHeroPosX = lastPosX;
			//this.hero.mBackHeroPosY = lastPosY;
			
		this.hero.heroPosX=posX;
		this.hero.heroPosY=posY;
		
		
		}

//		Log.v("onHover", "x:" + posX + " y:" + posY+ " touchAction="+touchAction);
		
		return true;
	}
}
