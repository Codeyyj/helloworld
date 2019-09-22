package p1;

import java.util.Random;

/**
 * ��װӢ�ۻ������Ժ͹�����
 */
public class Hero extends Flyer {
	
	private int doubleFire; //˫�������ӵ���
	private int life; //����ֵ
	private int score; //�÷�
	
	//�����ṩ��ȡ����ֵ�ķ���
	public int getLife(){
		return life;
	}
	
	//�����ṩ�Ļ�ȡ�÷ֵķ���
	public int getScore(){
		return score;
	}
	
	/**
	 * Ӣ�ۻ�������޲ι��췽��
	 */
	public Hero(){
		image = ShootGame.hero0;
		height = image.getHeight();
		width = image.getWidth();
		x = 127;
		y = 388;
		doubleFire = 0;
		life = 3;
		score = 0;
	}
	
	/**
	 * ʵ��Ӣ�ۻ��Ķ���Ч���ķ���
	 * ��Ӣ�ۻ���ͼƬ��hero0��hero1֮���л�
	 */
	@Override
	public void step() {
		Random r = new Random();
		if(r.nextInt(2) == 0){
			image = ShootGame.hero0;
		}else{
			image = ShootGame.hero1;
		}
	}
 
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Ӣ�ۻ�������ƶ��ķ���
	 * Ҫ������굱ǰ��λ��
	 * @param x ���λ�õ�x����
	 * @param y ���λ�õ�y����
	 */
	public void move(int x,int y){
		//�����x��y����������
		//move����������Ӣ�ۻ�������λ�ú����λ��һ��
		this.x = x - width / 2;
		this.y = y - height / 2;
	}
	
	/**
	 * Ӣ�ۻ���÷��������ķ���
	 * @param f ��һ�������︸�෽��������ָ��л����ߴ�ɻ�
	 */
	public void getScore_Award(Flyer f){
		//���жϵ��˶��������
		if(f instanceof Airplane){ //��������ǵл�
			//��õл������еķ������ӵ����ַ�����
			score += ((Airplane)f).getScore();
		}else{ //��������Ǵ�ɻ�
			//�����жϴ�ɻ������б���Ľ�������
			if(((BigPlane)f).getAwardType() == BigPlane.DOUBLE_FIRE){
				//����������˫������
				doubleFire += 20;
			}else{
				//��������������ֵ����
				life += 1;
			}
		}
		
	}
	
	/**
	 * Ӣ�ۻ������ӵ��ķ���
	 * @return �´����������ӵ�����
	 * 			������һ����Ҳ���� �������������鱣��
	 */
	public Bullet[] shoot(){
		Bullet[] bullets = null;
		//��ʱ����˫��������
		if(doubleFire != 0){ //����˫������
			bullets = new Bullet[2];
			bullets[0] =new Bullet(x + width/4 - ShootGame.bullet.getWidth()/2,y + ShootGame.bullet.getWidth());
			bullets[1] = new Bullet(x + width*3/4 - ShootGame.bullet.getWidth()/2,y + ShootGame.bullet.getWidth());
			//ÿ����һ��˫��������doubleFire-1
			doubleFire -= 1;
		}else{
			//����������
			//�ӵ�x���꣺x+Ӣ�ۻ�����/2-�ӵ�����/2
			//�ӵ�y���꣺y-�ӵ��߶�
			bullets = new Bullet[1];
			bullets[0] = new Bullet(x + width/2 - ShootGame.bullet.getWidth()/2,y - ShootGame.bullet.getHeight());
		}
		return bullets;
	}
	
	/**
	 * Ӣ�ۻ��Դ��͵�����ײ��ⷽ��
	 * @param f ���ܷ�����ײ�ĵ���
	 * 			�����ǵл�Ҳ�����Ǵ�ɻ�
	 * @return �Ƿ���ײ
	 */
	public boolean hit(Flyer f){
		//������ײ��ⷽ��������Ƿ���ײ
		boolean r = Flyer.boom(this, f);
		if(r){ //�����ײ
			life--;
			doubleFire = 0;
		}
		return r;
	}
	
}