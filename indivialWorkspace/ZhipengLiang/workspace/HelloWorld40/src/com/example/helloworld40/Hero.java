package com.example.helloworld40;

public class Hero {

	public int life = 3;//3����
	
	public int penOff = 20;//�ʵ�ƫ��12��pix
	
	/**�������߲���**/
	public int step = 15;//���ǵĲ���8��pix
	
	
	/**��ʵ��㷢����ײ**/
	public boolean isAcotrCollision = false;
	/**��߽�㷢����ײ**/
	public boolean isBorderCollision = false;
	/**�����﷢����ײ**/
	public boolean isPersonCollision = false;
	


	/**����ͼƬ��Դ��ʵ��Ӣ�۽ŵװ������ƫ��**/
	public final static int OFF_HERO_X = 16;
	public final static int OFF_HERO_Y = 35;


/**�����ƶ�����**/
    public final static int ANIM_DOWN = 0;
    /**�����ƶ�����**/
    public final static int ANIM_LEFT = 1;
    /**�����ƶ�����**/
    public final static int ANIM_RIGHT = 2;
    /**�����ƶ�����**/
    public final static int ANIM_UP = 3;
    /**������������**/
    public final static int ANIM_COUNT = 4;

    Animation mHeroAnim [] = new Animation[ANIM_COUNT];


  //Ӣ���ڵ�ͼ�е�������Ӣ�۽ŵ�����Ϊԭ��
  int mHeroPosX = 20;
  int mHeroPosY= 20;

  //����Ӣ�۷�����ײ��ǰ�������
  int mBackHeroPosX = 100;
  int mBackHeroPosY= 110;

  //Ӣ���ڵ�ͼ�л�������
  int mHeroImageX = 100;
  int mHeroImageY= 110;

  //Ӣ���ڵ�ͼ��λ�����е�����
  int mHeroIndexX = 3;
  int mHeroIndexY= 3;
  
  //ԭprivate void initHero()����
  public Hero(){
//	    mHeroImageX = 100;
//	    mHeroImageY = 100;
//	    /**����ͼƬ��ʾ���������Ӣ�۽ŵ׵����� **/
//	    /**X��+ͼƬ��ȵ�һ�� Y���ͼƬ�ĸ߶� **/
//	    mHeroPosX = mHeroImageX + OFF_HERO_X; 
//	    mHeroPosY = mHeroImageY + OFF_HERO_Y;
//	    mHeroIndexX = mHeroPosX / GameMap.TILE_WIDTH;
//	    mHeroIndexY = mHeroPosY / GameMap.TILE_HEIGHT;
	}
  
  
  
  
}
