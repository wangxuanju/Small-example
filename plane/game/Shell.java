package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * @author 高淇
 *
 */
//炮弹类，定义无参的构造方法。
//定义draw方法
//定义Graphics的getColor方法、setColor方法、fillOval方法。
//
public class Shell   extends  GameObject {
	
	double  degree;
	
	public  Shell(){
		x = 200;
		y = 200;
		width=10;
		height = 10;
		speed = 3;
		degree = Math.random()*Math.PI*2;//炮弹撞墙后角度调整;Math.random()：产生一个[0，1)之间的随机数。
	}
	
	public  void   draw(Graphics  g){
		Color   c =  g.getColor();
		g.setColor(Color.YELLOW);//炮弹颜色设为黄色。
		
		g.fillOval((int)x,(int) y, width, height);//给炮弹填充颜色。
		
		//炮弹沿着任意角度去飞
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		
		if(x<0||x>Constant.GAME_WIDTH-width){//调整边界，炮弹不能出左右界
			degree  = Math.PI - degree;
		}
		if(y<30||y>Constant.GAME_HEIGHT-height){//炮弹不能出上下边界
			degree  = - degree;
		}
		g.setColor(c);//设置完颜色之后，最后一步取消
	}
	
}
