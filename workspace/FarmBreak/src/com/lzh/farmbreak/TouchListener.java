package com.lzh.farmbreak;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.samsung.spensdk.applistener.SPenTouchListener;

public class TouchListener implements SPenTouchListener {

	
	@Override
	public boolean onTouchFinger(View view, MotionEvent event) {
		// updateTouchUI(event.getX(), event.getY(), event.getPressure(),
		// event.getAction(), "Finger--");
		Log.v("spen",
				"onTouchFinger -> event.getX()=" + event.getX()
						+ " event.getY():" + event.getY()
						+ " event.getPressure():" + event.getPressure()
						+ "  event.getAction()" + event.getAction());
		// Update Current Color
		// if(mCurrentTool!= TOOL_FINGER){
		// mCurrentTool = TOOL_FINGER;
		//
		// if(event.getAction()==MotionEvent.ACTION_DOWN)
		// mSCanvas.setSettingViewStrokeInfo(mStrokeInfoFinger);
		// }
		return false; // dispatch event to SCanvasView for drawing
	}

	@Override
	public boolean onTouchPen(View view, MotionEvent event) {
		Log.v("spen",
				"onTouchPen -> event.getX()=" + event.getX() + " event.getY():"
						+ event.getY() + " event.getPressure():"
						+ event.getPressure() + "  event.getAction()"
						+ event.getAction());

		// updateTouchUI(event.getX(), event.getY(), event.getPressure(),
		// event.getAction(), "+Pen+");
		//
		// // Update Current Color
		// if(mCurrentTool!=TOOL_PEN){
		// mCurrentTool = TOOL_PEN;
		//
		// if(event.getAction()==MotionEvent.ACTION_DOWN)
		// mSCanvas.setSettingViewStrokeInfo(mStrokeInfoPen);
		// }

		return false; // dispatch event to SCanvasView for drawing
	}

	@Override
	public boolean onTouchPenEraser(View view, MotionEvent event) {
		//
		// updateTouchUI(event.getX(), event.getY(),
		// event.getPressure(),event.getAction(), "Pen-Eraser");
		//
		// if(mCurrentTool!=TOOL_PEN_ERASER){
		// mCurrentTool = TOOL_PEN_ERASER;
		// }
		//
		// if(event.getAction()==MotionEvent.ACTION_DOWN)
		// mSCanvas.setEraserStrokeSetting(SObjectStroke.SAMM_DEFAULT_MAX_ERASERSIZE);

		return false; // dispatch event to SCanvasView for drawing
	}

	@Override
	public void onTouchButtonDown(View view, MotionEvent event) {
		Log.v("spen", "onTouchButtonDown " + event.getAction());
	}

	@Override
	public void onTouchButtonUp(View view, MotionEvent event) {
		Log.v("spen", "onTouchButtonUp " + event.getAction());
	}

}
