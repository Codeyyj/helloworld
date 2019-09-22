package p1;

import java.util.Random;

public class BigPlane extends Flyer{
	/*���影�����͵ı�ѡ���*/
	public static final int DOUBLE_FIRE = 0; //����������0��˵������˫������
	public static final int FILE = 1; //����������1��˵������һ������
	
	/*��ɻ���˽�г�Ա*/
	private int xspeed = 1; //ˮƽ�ƶ����ٶ�Ϊ1
	private int yspeed = 2; //��ֱ�ƶ����ٶ�Ϊ2
	private int awardType; //��ǰ��ɻ�����Ľ�������
	
	//�����ṩ�Ķ�ȡ��ɻ��������͵ķ���
	public int getAwardType(){
		return awardType;
	}
	
	/**
	 * ��ɻ����޲ι��췽��
	 */
	public BigPlane(){
		//step1: ���������л�ȡ��ɻ�ͼƬ�ľ�̬��������bigplane
		image = ShootGame.bigplane;
		//step2: ʹ��ͼƬ�������ö������
		width = image.getWidth();
		height= image.getHeight();
		//step3: ���ô�ɻ���ʼ����ĸ߶�
		y = -height;
		//step4:  ��ɻ�����ʼ�����x������0~��������� - ��ɻ�ͼƬ���ȣ�֮ǰ���
		Random r = new Random();
		x = r.nextInt(ShootGame.WIDTH - width);
		//��0��1֮���������һ�ֽ�������
		awardType = r.nextInt(2);
	}
 
	public void step() {
		//ÿ��x�ƶ�һ��xspeed��y�ƶ�һ��yspeed
		x += xspeed;
		y += yspeed;
		//��ɻ���������߽磬һ��������ôxspeed*��-1�����൱�ڷ����ƶ�
		if(x < 0 || x > ShootGame.WIDTH - width){
			xspeed *= -1;
		}
	}
 
	@Override
	public boolean outOfBounds() {
		//��ɻ���y����>��Ϸ���棬Խ��
		return y > ShootGame.HEIGHT;
	}
}