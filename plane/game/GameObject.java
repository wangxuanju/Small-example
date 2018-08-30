package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏物体的父类
 * @author 高淇
 *
 */
//游戏物体的父类，定义一个无参的构造方法和两个带参的构造方法
//定义一个drawSelf方法
//重点：定义public Rectangle getRect方法。 Rectangle的使用；Rectangle的Rectangle方法
//Graphics的使用;Graphics的drawImage方法、
//Image的使用
//
public class GameObject {
	  Image  img;
	  double  x,y;
	   int   speed;
	  int  width, height;
	
	public  void  drawSelf(Graphics  g){
		g.drawImage(img, (int)x,(int) y, null);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	public GameObject() {
	}
	
	/**
	 * 返回物体所在的矩形。便于后续的碰撞检测
	 * @return
	 */
	public  Rectangle   getRect(){
		return  new Rectangle((int)x, (int)y, width, height);
	}
	
	
}
