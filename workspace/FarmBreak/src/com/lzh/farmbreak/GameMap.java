package com.lzh.farmbreak;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameMap {

	// ��������tile�������
	int mWidthTileCount = 0;
	int mHeightTileCount = 0;

	// ��������tile��Ŀ���
	int mBitMapWidth = 0;
	int mBitMapHeight = 0;
	
	// tile��Ŀ���
	public final static int TILE_WIDTH = 40;// 32
	public final static int TILE_HEIGHT = 40;// 32

	// tile��Ŀ��ߵ�����
	public final static int TILE_WIDTH_COUNT = 32;// 10;//32
	public final static int TILE_HEIGHT_COUNT = 18;// 15;//18

	// ����Ԫ��Ϊ0��ʲô������
	public final static int TILE_NULL = 0;
	// ��Ϸ��ͼ��Դ
	Bitmap bitmap = null;

	public abstract int[][] getMapRoadLayer1();


	public abstract int[][] getMapObjLayer2() ;


	public abstract int[][] getMapExtraLayer3() ;


	public abstract int[][] getRecoverPoint() ;
	
	
	// ԭinitMap(Context context)����
	public GameMap(Context context) {
		bitmap = readBitMap(context, R.drawable.map);
		mBitMapWidth = bitmap.getWidth();
		mBitMapHeight = bitmap.getHeight();
		mWidthTileCount = mBitMapWidth / TILE_WIDTH;
		mHeightTileCount = mBitMapHeight / TILE_HEIGHT;

		
	}

/**
 * ��ȡ������Դ��ͼƬ
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
    // ��ȡ��ԴͼƬ
    InputStream is = context.getResources().openRawResource(resId);
    return BitmapFactory.decodeStream(is, null, opt);
}

//����ͼ
	public void drawMap(Canvas canvas, Paint paint) {
		int i, j;
		for (i = 0; i < TILE_HEIGHT_COUNT; i++) {
			for (j = 0; j < TILE_WIDTH_COUNT; j++) {
				int roadId = this.getMapRoadLayer1()[i][j];
				int objId = this.getMapObjLayer2()[i][j];
				int extId = this.getMapExtraLayer3()[i][j];
				// ���Ƶ�ͼ��һ��
				if (roadId > TILE_NULL) {
					drawMapTile(roadId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
				}

				// ���Ƶ�ͼ�ڶ���
				if (objId > TILE_NULL) {
					drawMapTile(objId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
				}
				// ���Ƶ�ͼ��3��
				if (extId > TILE_NULL) {
					drawMapTile(extId, canvas, paint, bitmap, j * TILE_WIDTH, i * TILE_HEIGHT);
				}
			}
		}
	}
/**
 * ����ID����һ��tile��
 * @param id
 * @param canvas
 * @param paint
 * @param bitmap
 */
private void drawMapTile(int id,Canvas canvas,Paint paint ,Bitmap bitmap,int x, int y) {
    //���������е�ID����ڵ�ͼ��Դ�е�XY ����
    //��Ϊ�༭��Ĭ��0 ���Ե�һ��tile��ID����0����1 �������� -1
    id--;
    int count = id /mWidthTileCount;
    int bitmapX = (id - (count * mWidthTileCount)) * TILE_WIDTH;
    int bitmapY = count * TILE_HEIGHT;
    drawClipImage(canvas,paint,bitmap,x,y,bitmapX,bitmapY,TILE_WIDTH,TILE_HEIGHT);
}

	/**
	 * ����ͼƬ�е�һ����ͼƬ
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