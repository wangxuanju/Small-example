package game;

import java.awt.Graphics;
import java.awt.Image;

/*
 * 爆炸类
 */
//爆炸类,一个带参的构造方法。自定义的draw方法和静态代码块。
//调用GameUtil类中的getImage()方法
//Graphics的使用;Graphics的drawImage方法、
//
//
public class Explode {
	double x, y;
	int count;
	//爆炸的位置，设为静态初始化块。
	static Image[] imgs = new Image[16];//重难点？？？
	static {
		for (int i = 0; i < 16; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");//调用GameUtil类中的getImage()方法。
			imgs[i].getWidth(null);
		}
	}

	

	public void draw(Graphics g) {
		if (count <= 15) {
			g.drawImage(imgs[count], (int) x, (int) y, null);
			count++;
		}
	}

	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
