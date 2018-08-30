package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
//飞机类继承物体类,定义带参的构造方法
//定义drawSelf方法、addDirection方法、minusDirection方法。
//引用Graphics中的drawImage()方法。
////引用Image中的getWidth()方法getHeight()方法
//引用KeyEvent中的getKeyCode()类。
//KeyEvent.VK_LEFT等四个常量。
public class Plane  extends GameObject {
	boolean  left,up,right,down;
	
	boolean  live = true;  
	//当飞机live时按键来调整位置
	//GameObject也有drawSelf方法
	public  void  drawSelf(Graphics  g){
		if(live){
				g.drawImage(img, (int)x,(int) y, null);//引用Graphics中的drawImage()方法。
				
				if(left){
					x -=speed;
				}
				if(right){
					x += speed;
				}
				if(up){
					y -=speed;    //y = y-speed;
				}
				if(down){
					y += speed;
			}
		}else{
			
		}
		
		
		
	}
	
	public  Plane(Image  img, double x, double y){
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = 3;
		this.width = img.getWidth(null) ;//引用Image中的getWidth()方法
		this.height = img.getHeight(null);//引用Image中的getHeight()方法
		
	}
	
	//按下某个键，增加相应的方向
	public  void   addDirection(KeyEvent  e){//引用KeyEvent中的getKeyCode()类。
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	//按下某个键，取消相应的方向
		public  void   minusDirection(KeyEvent  e){
			switch (e.getKeyCode()) {//KeyEvent的getKeyCode方法。
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;
			}
		}
	
	
}
