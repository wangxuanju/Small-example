package cn.sxt.game;

import java.awt.Color;//提供用于颜色空间的类。
import java.awt.Font;//提供与字体相关的类和接口。
import java.awt.Frame;//Frame 是带有标题和边框的顶层窗口。
import java.awt.Graphics;//是所有图形上下文的抽象基类，允许应用程序在组件（已经在各种设备上实现）以及闭屏图像上进行绘制。
import java.awt.Image;//提供创建和修改图像的各种类。
import java.awt.event.KeyAdapter;//接收键盘事件的抽象适配器类。
import java.awt.event.KeyEvent;//表示组件中发生键击的事件。
import java.awt.event.WindowAdapter;//接收窗口事件的抽象适配器类。
import java.awt.event.WindowEvent;//指示窗口状态改变的低级别事件。
import java.util.Date;//包含 collection 框架、遗留的 collection 类、事件模型、日期和时间设施、国际化和各种实用工具类

/**
 * 飞机游戏的主窗口
 * @author 高淇
 *
 */
//游戏主窗口，定义pain方法、launchFrame方法、update方法。
//Graphics的drawImage方法、setFont方法、drawString方法
//Frame的setTitle方法、setVisible方法、setSize方法、setLocation方法
//内部类PaintThread和KeyMonitor
//Image的getGraphics方法。
//当一个类继承Thread类后，就可以在该类中覆盖run方法，将实现该线程功能的代码写入run（）方法中，
//然后调用Thread类中的start（）方法执行线程，即调用run()方法.
public class MyGameFrame  extends  Frame {
	
	Image   planeImg  = GameUtil.getImage("images/plane.png");//GameUtil的getImage方法
	Image   bg  = GameUtil.getImage("images/bg.jpg");
	
	Plane   plane = new Plane(planeImg,250,250);
	Shell[]   shells = new Shell[50];
	
	Explode   bao ;//声明爆炸对象
	//计时功能
	Date  startTime = new Date();
	Date  endTime;
	int period;   //游戏持续的时间
	
	@Override
//paint方法
//为什么会自动被调用？？？
	public void paint(Graphics g) {		//自动被调用。  g相当于一只画笔
		Color   c =  g.getColor();// 获取此图形上下文的当前颜色。
		g.drawImage(bg, 0, 0, null);//bg图片为背景图片。绘制指定图像中当前可用的图像。
	//调用飞机类中的drawSelf()方法。
		plane.drawSelf(g);  //画飞机
		
		//画出所有的炮弹
		for(int i=0;i<shells.length;i++){
	//?/调用炮弹类的draw方法
			shells[i].draw(g);
			
			//飞机和炮弹的碰撞检测！！！
	//?/调用物体类（炮弹类）的getRact方法
			boolean  peng = shells[i].getRect().intersects(plane.getRect());
			if(peng){
				plane.live = false;
				if(bao ==null){
					bao  = new Explode(plane.x, plane.y);
					endTime = new Date();
					//返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
					period = (int)((endTime.getTime()-startTime.getTime())/1000);
				}
	//爆炸类中的draw()方法
				bao.draw(g);
			}
			
			//计时功能，给出提示
			if(!plane.live){
				g.setColor(Color.red);//将此图形上下文的当前颜色设置为指定颜色。
				Font   f  =  new Font("宋体", Font.BOLD, 50);//设置字体大小。
				g.setFont(f);//将此图形上下文的字体设置为指定字体。
				//使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。
				g.drawString("时间："+period+"秒", (int)plane.x, (int)plane.y);//
			}
			
		}
		
		g.setColor(c);
	}	
	
	//帮助我们反复的重画窗口！
//内部类：重画窗口
//当一个类继承Thread类后，就可以在该类中覆盖run方法，将实现该线程功能的代码写入run（）方法中，
//然后调用Thread类中的start（）方法执行线程，即调用run()方法.
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
	//?/repaint()方法很奇怪，注意为什么可以直接应用，关键是效果是什么？
				repaint();		//重画
				
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
		
	}	
//定义键盘监听的内部类
	class   KeyMonitor extends  KeyAdapter  {

		@Override
		public void keyPressed(KeyEvent e) {
	//调用飞机的addDirection方法
			plane.addDirection(e);//调用飞机的方法
		}

		@Override
		public void keyReleased(KeyEvent e) {
	//调用飞机的方法
			plane.minusDirection(e);//调用飞机的方法
		}
		
		
	}
	/**
	 * 初始化窗口
	 */
//定义初始化窗口的普通无参的方法
	public  void  launchFrame(){
		this.setTitle("尚学堂学员_程序猿作品");//调用Frame的setTitle()类
		this.setVisible(true);//调用Frame的setVisible()类
		this.setSize(Constant.GAME_WIDTH	, Constant.GAME_HEIGHT);//调用window的setSize()
		this.setLocation(300, 300);//调用window的setLocation()
		
		this.addWindowListener(new WindowAdapter() {//调用window的addWindowListener()
			@Override//调用wondowEvent类
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
//调用重画窗口的内部类
		new PaintThread().start();	//启动重画窗口的线程//使用PaintThread类
//调用keyMonitor键盘监听内部类
		addKeyListener(new KeyMonitor());   //给窗口增加键盘的监听//使用keyMonitor类。
		
		
		//初始化50个炮弹
		for(int i=0;i<shells.length;i++){
			shells[i] = new Shell();
		}
		
	}
	//以下的代码和方法都不明白具体的用途是什么，特别是怎么被调用的？
	//解决游戏界面闪烁的问题。
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	public static void main(String[] args) {
	//初始化窗口
		MyGameFrame  f = new MyGameFrame();
		f.launchFrame();
	}
	
}
