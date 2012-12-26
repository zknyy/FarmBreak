package com.example.helloworld40;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameMap {


	//��������tile�������
	int mWidthTileCount = 0;
	int mHeightTileCount = 0;

	//��������tile�������
	int mBitMapWidth = 0;
	int mBitMapHeight = 0;
    //tile��Ŀ��
public final static int TILE_WIDTH = 32;
public final static int TILE_HEIGHT = 32;

    //tile��Ŀ�ߵ�����
public final static int TILE_WIDTH_COUNT = 10;
public final static int TILE_HEIGHT_COUNT = 15;

//����Ԫ��Ϊ0��ʲô������
public final static int TILE_NULL = 0;
//��һ����ϷView��ͼ����
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

//�ڶ�����Ϸʵ��actor����
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

//��������Ϸ��ײ��������� 
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

//��Ϸ��ͼ��Դ
Bitmap mBitmap = null;


//ԭinitMap(Context context)����
public GameMap(Context context) {
	 mBitmap = ReadBitMap(context, R.drawable.map);
	    mBitMapWidth = mBitmap.getWidth();
	    mBitMapHeight = mBitmap.getHeight();
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
public Bitmap ReadBitMap(Context context, int resId) {
    BitmapFactory.Options opt = new BitmapFactory.Options();
    opt.inPreferredConfig = Bitmap.Config.RGB_565;
    opt.inPurgeable = true;
    opt.inInputShareable = true;
    // ��ȡ��ԴͼƬ
    InputStream is = context.getResources().openRawResource(resId);
    return BitmapFactory.decodeStream(is, null, opt);
}


public void drawMap(Canvas canvas,Paint paint) {
    int i,j;
    for(i = 0; i< TILE_HEIGHT_COUNT; i++) {
	for(j = 0; j<TILE_WIDTH_COUNT;j++) {
	    int ViewID =  mMapView[i][j];
	    int ActorID = mMapAcotor[i][j];
	    //���Ƶ�ͼ��һ��
	    if(ViewID > TILE_NULL) {
		 DrawMapTile(ViewID,canvas,paint,mBitmap, j * TILE_WIDTH , i * TILE_HEIGHT);
	    }
	   
	    //���Ƶ�ͼ�ڶ���
	    if(ActorID > TILE_NULL) {
		DrawMapTile(ActorID,canvas,paint,mBitmap, j * TILE_WIDTH , i * TILE_HEIGHT);
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
private void DrawMapTile(int id,Canvas canvas,Paint paint ,Bitmap bitmap,int x, int y) {
    //���������е�ID����ڵ�ͼ��Դ�е�XY ����
    //��Ϊ�༭��Ĭ��0 ���Ե�һ��tile��ID����0����1 �������� -1
    id--;
    int count = id /mWidthTileCount;
    int bitmapX = (id - (count * mWidthTileCount)) * TILE_WIDTH;
    int bitmapY = count * TILE_HEIGHT;
    DrawClipImage(canvas,paint,bitmap,x,y,bitmapX,bitmapY,TILE_WIDTH,TILE_HEIGHT);
}


/**
* ����ͼƬ�е�һ����ͼƬ
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
