package cn.sxt.game;

import java.awt.Color;//�ṩ������ɫ�ռ���ࡣ
import java.awt.Font;//�ṩ��������ص���ͽӿڡ�
import java.awt.Frame;//Frame �Ǵ��б���ͱ߿�Ķ��㴰�ڡ�
import java.awt.Graphics;//������ͼ�������ĵĳ�����࣬����Ӧ�ó�����������Ѿ��ڸ����豸��ʵ�֣��Լ�����ͼ���Ͻ��л��ơ�
import java.awt.Image;//�ṩ�������޸�ͼ��ĸ����ࡣ
import java.awt.event.KeyAdapter;//���ռ����¼��ĳ����������ࡣ
import java.awt.event.KeyEvent;//��ʾ����з����������¼���
import java.awt.event.WindowAdapter;//���մ����¼��ĳ����������ࡣ
import java.awt.event.WindowEvent;//ָʾ����״̬�ı�ĵͼ����¼���
import java.util.Date;//���� collection ��ܡ������� collection �ࡢ�¼�ģ�͡����ں�ʱ����ʩ�����ʻ��͸���ʵ�ù�����

/**
 * �ɻ���Ϸ��������
 * @author ���
 *
 */
//��Ϸ�����ڣ�����pain������launchFrame������update������
//Graphics��drawImage������setFont������drawString����
//Frame��setTitle������setVisible������setSize������setLocation����
//�ڲ���PaintThread��KeyMonitor
//Image��getGraphics������
//��һ����̳�Thread��󣬾Ϳ����ڸ����и���run��������ʵ�ָ��̹߳��ܵĴ���д��run���������У�
//Ȼ�����Thread���е�start��������ִ���̣߳�������run()����.
public class MyGameFrame  extends  Frame {
	
	Image   planeImg  = GameUtil.getImage("images/plane.png");//GameUtil��getImage����
	Image   bg  = GameUtil.getImage("images/bg.jpg");
	
	Plane   plane = new Plane(planeImg,250,250);
	Shell[]   shells = new Shell[50];
	
	Explode   bao ;//������ը����
	//��ʱ����
	Date  startTime = new Date();
	Date  endTime;
	int period;   //��Ϸ������ʱ��
	
	@Override
//paint����
//Ϊʲô���Զ������ã�����
	public void paint(Graphics g) {		//�Զ������á�  g�൱��һֻ����
		Color   c =  g.getColor();// ��ȡ��ͼ�������ĵĵ�ǰ��ɫ��
		g.drawImage(bg, 0, 0, null);//bgͼƬΪ����ͼƬ������ָ��ͼ���е�ǰ���õ�ͼ��
	//���÷ɻ����е�drawSelf()������
		plane.drawSelf(g);  //���ɻ�
		
		//�������е��ڵ�
		for(int i=0;i<shells.length;i++){
	//?/�����ڵ����draw����
			shells[i].draw(g);
			
			//�ɻ����ڵ�����ײ��⣡����
	//?/���������ࣨ�ڵ��ࣩ��getRact����
			boolean  peng = shells[i].getRect().intersects(plane.getRect());
			if(peng){
				plane.live = false;
				if(bao ==null){
					bao  = new Explode(plane.x, plane.y);
					endTime = new Date();
					//������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�������
					period = (int)((endTime.getTime()-startTime.getTime())/1000);
				}
	//��ը���е�draw()����
				bao.draw(g);
			}
			
			//��ʱ���ܣ�������ʾ
			if(!plane.live){
				g.setColor(Color.red);//����ͼ�������ĵĵ�ǰ��ɫ����Ϊָ����ɫ��
				Font   f  =  new Font("����", Font.BOLD, 50);//���������С��
				g.setFont(f);//����ͼ�������ĵ���������Ϊָ�����塣
				//ʹ�ô�ͼ�������ĵĵ�ǰ�������ɫ������ָ�� string �������ı���
				g.drawString("ʱ�䣺"+period+"��", (int)plane.x, (int)plane.y);//
			}
			
		}
		
		g.setColor(c);
	}	
	
	//�������Ƿ������ػ����ڣ�
//�ڲ��ࣺ�ػ�����
//��һ����̳�Thread��󣬾Ϳ����ڸ����и���run��������ʵ�ָ��̹߳��ܵĴ���д��run���������У�
//Ȼ�����Thread���е�start��������ִ���̣߳�������run()����.
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
	//?/repaint()��������֣�ע��Ϊʲô����ֱ��Ӧ�ã��ؼ���Ч����ʲô��
				repaint();		//�ػ�
				
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
		
	}	
//������̼������ڲ���
	class   KeyMonitor extends  KeyAdapter  {

		@Override
		public void keyPressed(KeyEvent e) {
	//���÷ɻ���addDirection����
			plane.addDirection(e);//���÷ɻ��ķ���
		}

		@Override
		public void keyReleased(KeyEvent e) {
	//���÷ɻ��ķ���
			plane.minusDirection(e);//���÷ɻ��ķ���
		}
		
		
	}
	/**
	 * ��ʼ������
	 */
//�����ʼ�����ڵ���ͨ�޲εķ���
	public  void  launchFrame(){
		this.setTitle("��ѧ��ѧԱ_����Գ��Ʒ");//����Frame��setTitle()��
		this.setVisible(true);//����Frame��setVisible()��
		this.setSize(Constant.GAME_WIDTH	, Constant.GAME_HEIGHT);//����window��setSize()
		this.setLocation(300, 300);//����window��setLocation()
		
		this.addWindowListener(new WindowAdapter() {//����window��addWindowListener()
			@Override//����wondowEvent��
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
//�����ػ����ڵ��ڲ���
		new PaintThread().start();	//�����ػ����ڵ��߳�//ʹ��PaintThread��
//����keyMonitor���̼����ڲ���
		addKeyListener(new KeyMonitor());   //���������Ӽ��̵ļ���//ʹ��keyMonitor�ࡣ
		
		
		//��ʼ��50���ڵ�
		for(int i=0;i<shells.length;i++){
			shells[i] = new Shell();
		}
		
	}
	//���µĴ���ͷ����������׾������;��ʲô���ر�����ô�����õģ�
	//�����Ϸ������˸�����⡣
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	public static void main(String[] args) {
	//��ʼ������
		MyGameFrame  f = new MyGameFrame();
		f.launchFrame();
	}
	
}
