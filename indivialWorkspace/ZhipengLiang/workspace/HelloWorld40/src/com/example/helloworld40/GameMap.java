package com.example.helloworld40;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameMap {

	// 横向纵向tile块的数量
	int mWidthTileCount = 0;
	int mHeightTileCount = 0;

	// 横向纵向tile块的宽高
	int mBitMapWidth = 0;
	int mBitMapHeight = 0;
	
	// tile块的宽高
	public final static int TILE_WIDTH = 40;// 32
	public final static int TILE_HEIGHT = 40;// 32

	// tile块的宽高的数量
	public final static int TILE_WIDTH_COUNT = 32;// 10;//32
	public final static int TILE_HEIGHT_COUNT = 18;// 15;//18

	// 数组元素为0则什么都不画
	public final static int TILE_NULL = 0;
	// 游戏地图资源
	Bitmap bitmap = null;

	public abstract int[][] getMapRoadLayer1();


	public abstract int[][] getMapObjLayer2() ;


	public abstract int[][] getMapExtraLayer3() ;


	public abstract int[][] getRecoverPoint() ;
	
	
	// 原initMap(Context context)方法
	public GameMap(Context context) {
		bitmap = readBitMap(context, R.drawable.map);
		mBitMapWidth = bitmap.getWidth();
		mBitMapHeight = bitmap.getHeight();
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
public Bitmap readBitMap(Context context, int resId) {
    BitmapFactory.Options opt = new BitmapFactory.Options();
    opt.inPreferredConfig = Bitmap.Config.RGB_565;
    opt.inPurgeable = true;
    opt.inInputShareable = true;
    // 获取资源图片
    InputStream is = context.getResources().openRawResource(resId);
    return BitmapFactory.decodeStream(is, null, opt);
}

//画地图
	public void drawMap(Canvas canvas, Paint paint) {
		int i, j;
		for (i = 0; i < TILE_HEIGHT_COUNT; i++) {
			for (j = 0; j < TILE_WIDTH_COUNT; j++) {
				int roadId = this.getMapRoadLayer1()[i][j];
				int objId = this.getMapObjLayer2()[i][j];
				int extId = this.getMapExtraLayer3()[i][j];
				// 绘制地图第一层
				if (roadId > TILE_NULL) {
					drawMapTile(roadId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
				}

				// 绘制地图第二层
				if (objId > TILE_NULL) {
					drawMapTile(objId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
				}
				// 绘制地图第3层
				if (extId > TILE_NULL) {
					drawMapTile(extId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
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
private void drawMapTile(int id,Canvas canvas,Paint paint ,Bitmap bitmap,int x, int y) {
    //根据数组中的ID算出在地图资源中的XY 坐标
    //因为编辑器默认0 所以第一张tile的ID不是0而是1 所以这里 -1
    id--;
    int count = id /mWidthTileCount;
    int bitmapX = (id - (count * mWidthTileCount)) * TILE_WIDTH;
    int bitmapY = count * TILE_HEIGHT;
    drawClipImage(canvas,paint,bitmap,x,y,bitmapX,bitmapY,TILE_WIDTH,TILE_HEIGHT);
}

	/**
	 * 绘制图片中的一部分图片
	 * 
	 * @param canvas
	 * @param paint
	 * @param bitmap
	 * @param xOnCanvas
	 * @param yOnCanvas
	 * @param xOntile
	 * @param yOntile
	 * @param tileWidth
	 * @param tileHigh
	 */
	private void drawClipImage(Canvas canvas, Paint paint, Bitmap bitmap,
			int xOnCanvas, int yOnCanvas, int xOntile, int yOntile, int tileWidth,	int tileHigh) {
		canvas.save();
		canvas.clipRect(xOnCanvas, yOnCanvas, xOnCanvas + tileWidth, yOnCanvas+ tileHigh);
		canvas.drawBitmap(bitmap, xOnCanvas - xOntile, yOnCanvas - yOntile, paint);
		canvas.restore();
	}
}
