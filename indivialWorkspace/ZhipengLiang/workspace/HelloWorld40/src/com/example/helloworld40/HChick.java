package com.example.helloworld40;

public class HChick extends Hero{

	
	public HChick() {
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
		this.backHeroPosX = 100;
		this.backHeroPosY= 110;

		  //Ӣ���ڵ�ͼ�л�������
		this.heroImageX = 100;
		this.heroImageY= 110;

		  //Ӣ���ڵ�ͼ��λ�����е�����
		this.heroIndexX = 3;
		this.heroIndexY= 3;
		
		//�ĸ���ײ��
		this.hitPoints = new int[][]{
				{0,0},	{0,40},	{40,0},	{40,40}
		};
	}


}
