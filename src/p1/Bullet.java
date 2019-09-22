package p1;

public class Bullet extends Flyer{
	
	private int speed = 3; //�ӵ��������ٶ�Ϊ3
	
	/**
	 * �ӵ���Ĵ��ι��췽��
	 * ��Ϊ�ӵ��������λ��Ҫ����Ӣ�ۻ���λ�þ���
	 * �����ӵ�������x��yҪ����紫��
	 * @param x Ӣ�ۻ�ָ���ӵ�����λ�õ�x����
	 * @param y Ӣ�ۻ�ָ���ӵ�����λ�õ�y����
	 */
	public Bullet(int x,int y){
		image = ShootGame.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
	}
 
	@Override
	public void step() {
		//�ӵ�ÿ�������ƶ�һ��speed����
		y -= speed;
	}
 
	@Override
	public boolean outOfBounds() {
		//�ӵ���y����+�ӵ��ĸ߶�<0��Խ��
		return (y + height) < 0;
	}
}