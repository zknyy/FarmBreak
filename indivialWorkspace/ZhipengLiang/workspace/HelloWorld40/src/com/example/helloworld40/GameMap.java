package com.example.helloworld40;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameMap {


	//横向纵向tile块的数量
	int mWidthTileCount = 0;
	int mHeightTileCount = 0;

	//横向纵向tile块的数量
	int mBitMapWidth = 0;
	int mBitMapHeight = 0;
    //tile块的宽高
public final static int TILE_WIDTH = 32;
public final static int TILE_HEIGHT = 32;

    //tile块的宽高的数量
public final static int TILE_WIDTH_COUNT = 10;
public final static int TILE_HEIGHT_COUNT = 15;

//数组元素为0则什么都不画
public final static int TILE_NULL = 0;
//第一层游戏View地图数组
public int [][]mMapView = {
	{ 1, 1, 1, 1, 137, 137, 137, 1, 1, 1 },
	{ 1, 1, 1, 1, 137, 137, 137, 1, 1, 1 },
	{ 1, 1, 1, 1, 137, 137, 137, 1, 1, 1 },
	{ 137, 137, 137, 137, 137, 137, 137, 137, 137, 137 },
	{ 137, 137, 137, 137, 137, 137, 137, 137, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 1, 1, 1, 1, 1, 1, 1, 1, 137, 137 },
	{ 137, 137, 137, 137, 137, 137, 137, 137, 137, 137 },
	{ 137, 137, 137, 137, 137, 137, 137, 137, 137, 137 },
	{ 1, 1, 1, 1, 1, 137, 137, 137, 1, 1 },
	{ 1, 1, 1, 1, 1, 137, 137, 137, 1, 1 }
	};

//第二层游戏实体actor数组
public int [][]mMapAcotor  = {
	{ 102, 103, 103, 104, 0, 0, 0, 165, 166, 167 },
	{ 110, 111, 111, 112, 0, 0, 0, 173, 174, 175 },
	{ 126, 127, 127, 128, 0, 0, 0, 181, 182, 183 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 41, 42, 43, 44, 0, 0, 0, 0, 0, 0 },
	{ 49, 50, 51, 52, 0, 0, 0, 0, 0, 0 },
	{ 57, 58, 59, 60, 229, 230, 231, 232, 0, 0 },
	{ 65, 66, 67, 68, 237, 238, 239, 240, 0, 0 },
	{ 0, 0, 0, 0, 245, 246, 247, 248, 0, 0 },
	{ 0, 0, 0, 0, 0, 254, 255, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 102, 103, 103, 103, 104, 0, 0, 0, 143, 144 },
	{ 110, 111, 111, 111, 112, 0, 0, 0, 143, 144 }
	};

//第三层游戏碰撞物理层数组 
public int [][]mCollision  = {
	{ -1, -1, -1, -1, 0, 0, 0, -1, -1, -1 },
	{ -1, -1, -1, -1, 0, 0, 0, -1, -1, -1 },
	{ -1, -1, -1, -1, 0, 0, 0, -1, -1, -1 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ -1, -1, -1, -1, 0, 0, 0, 0, 0, 0 },
	{ -1, -1, -1, -1, 0, 0, 0, 0, 0, 0 },
	{ -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
	{ -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 },
	{ 0, 0, 0, 0, -1, -1, -1, -1, 0, 0 },
	{ 0, 0, 0, 0, 0, -1, -1, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ -1, -1, -1, -1, -1, 0, 0, 0, -1, -1 },
	{ -1, -1, -1, -1, -1, 0, 0, 0, -1, -1 }
	};

//游戏地图资源
Bitmap mBitmap = null;


//原initMap(Context context)方法
public GameMap(Context context) {
	 mBitmap = ReadBitMap(context, R.drawable.map);
	    mBitMapWidth = mBitmap.getWidth();
	    mBitMapHeight = mBitmap.getHeight();
	    mWidthTileCount = mBitMapWidth / TILE_WIDTH;
	    mHeightTileCount = mBitMapHeight / TILE_HEIGHT;
}

/**
 * 读取本地资源的图片
 * 
 * @param context
 * @param resId
 * @return
 */
public Bitmap ReadBitMap(Context context, int resId) {
    BitmapFactory.Options opt = new BitmapFactory.Options();
    opt.inPreferredConfig = Bitmap.Config.RGB_565;
    opt.inPurgeable = true;
    opt.inInputShareable = true;
    // 获取资源图片
    InputStream is = context.getResources().openRawResource(resId);
    return BitmapFactory.decodeStream(is, null, opt);
}


public void drawMap(Canvas canvas,Paint paint) {
    int i,j;
    for(i = 0; i< TILE_HEIGHT_COUNT; i++) {
	for(j = 0; j<TILE_WIDTH_COUNT;j++) {
	    int ViewID =  mMapView[i][j];
	    int ActorID = mMapAcotor[i][j];
	    //绘制地图第一层
	    if(ViewID > TILE_NULL) {
		 DrawMapTile(ViewID,canvas,paint,mBitmap, j * TILE_WIDTH , i * TILE_HEIGHT);
	    }
	   
	    //绘制地图第二层
	    if(ActorID > TILE_NULL) {
		DrawMapTile(ActorID,canvas,paint,mBitmap, j * TILE_WIDTH , i * TILE_HEIGHT);
	    }
	}
    }
}
/**
 * 根据ID绘制一个tile块
 * @param id
 * @param canvas
 * @param paint
 * @param bitmap
 */
private void DrawMapTile(int id,Canvas canvas,Paint paint ,Bitmap bitmap,int x, int y) {
    //根据数组中的ID算出在地图资源中的XY 坐标
    //因为编辑器默认0 所以第一张tile的ID不是0而是1 所以这里 -1
    id--;
    int count = id /mWidthTileCount;
    int bitmapX = (id - (count * mWidthTileCount)) * TILE_WIDTH;
    int bitmapY = count * TILE_HEIGHT;
    DrawClipImage(canvas,paint,bitmap,x,y,bitmapX,bitmapY,TILE_WIDTH,TILE_HEIGHT);
}


/**
* 绘制图片中的一部分图片
* @param canvas
* @param paint
* @param bitmap
* @param x
* @param y
* @param src_x
* @param src_y
* @param src_width
* @param src_Height
*/
private void DrawClipImage(Canvas canvas,Paint paint ,Bitmap bitmap, int x, int y, int src_x, int src_y, int src_xp, int src_yp) {
canvas.save();
canvas.clipRect(x, y, x + src_xp, y + src_yp);
canvas.drawBitmap(bitmap, x - src_x, y - src_y,paint);
canvas.restore();
}
}
