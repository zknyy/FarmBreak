package com.lzh.farmbreak;

public class HeroChick extends Hero{

	
	public HeroChick() {
		super();

		this.penOff = 20;//�ʵ�ƫ��12��pix
		
		/**�������߲���**/
		this.step = 15;//���ǵĲ���8��pix

//		/**����ͼƬ��Դ��ʵ��Ӣ�۽ŵװ������ƫ��**/
//		private   int OFF_HERO_X = 20;//16
//		private   int OFF_HERO_Y = 20;//35

		this.heroOffX = 20;//16
		this.heroOffY = 20;//35

		  //Ӣ���ڵ�ͼ�е�������Ӣ�۽ŵ�����Ϊԭ��
		this.heroPosX = 20;
		this.heroPosY= 20;

		  //����Ӣ�۷�����ײ��ǰ�������
		this.backHeroPosX = 80;//120;
		this.backHeroPosY= 120;

		  //Ӣ���ڵ�ͼ�л�������
		this.heroImageX = 80;//120;
		this.heroImageY= 120;

		  //Ӣ���ڵ�ͼ��λ�����е�����
		this.heroIndexX = 2;
		this.heroIndexY= 2;
		
		//�ĸ���ײ��
		this.hitPoints = new int[][]{
				{0,0},	{0,40},	{40,0},	{40,40}
		};
	}


}
