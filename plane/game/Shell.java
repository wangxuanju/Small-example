package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * �ڵ���
 * @author ���
 *
 */
//�ڵ��࣬�����޲εĹ��췽����
//����draw����
//����Graphics��getColor������setColor������fillOval������
//
public class Shell   extends  GameObject {
	
	double  degree;
	
	public  Shell(){
		x = 200;
		y = 200;
		width=10;
		height = 10;
		speed = 3;
		degree = Math.random()*Math.PI*2;//�ڵ�ײǽ��Ƕȵ���;Math.random()������һ��[0��1)֮����������
	}
	
	public  void   draw(Graphics  g){
		Color   c =  g.getColor();
		g.setColor(Color.YELLOW);//�ڵ���ɫ��Ϊ��ɫ��
		
		g.fillOval((int)x,(int) y, width, height);//���ڵ������ɫ��
		
		//�ڵ���������Ƕ�ȥ��
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		
		if(x<0||x>Constant.GAME_WIDTH-width){//�����߽磬�ڵ����ܳ����ҽ�
			degree  = Math.PI - degree;
		}
		if(y<30||y>Constant.GAME_HEIGHT-height){//�ڵ����ܳ����±߽�
			degree  = - degree;
		}
		g.setColor(c);//��������ɫ֮�����һ��ȡ��
	}
	
}
