package com.example.helloworld40;

public class Hero {

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
  int mHeroPosX = 0;
  int mHeroPosY= 0;

  //����Ӣ�۷�����ײ��ǰ�������
  int mBackHeroPosX = 0;
  int mBackHeroPosY= 0;

  //Ӣ���ڵ�ͼ�л�������
  int mHeroImageX = 0;
  int mHeroImageY= 0;

  //Ӣ���ڵ�ͼ��λ�����е�����
  int mHeroIndexX = 0;
  int mHeroIndexY= 0;
  
  //ԭprivate void initHero()����
  public Hero(){
	    mHeroImageX = 100;
	    mHeroImageY = 100;
	    /**����ͼƬ��ʾ���������Ӣ�۽ŵ׵����� **/
	    /**X��+ͼƬ��ȵ�һ�� Y���ͼƬ�ĸ߶� **/
	    mHeroPosX = mHeroImageX + OFF_HERO_X; 
	    mHeroPosY = mHeroImageY + OFF_HERO_Y;
	    mHeroIndexX = mHeroPosX / GameMap.TILE_WIDTH;
	    mHeroIndexY = mHeroPosY / GameMap.TILE_HEIGHT;
	}
  
  
  
  
}
