package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;

/*
 * ��ը��
 */
//��ը��,һ�����εĹ��췽�����Զ����draw�����;�̬����顣
//����GameUtil���е�getImage()����
//Graphics��ʹ��;Graphics��drawImage������
//
//
public class Explode {
	double x, y;
	int count;
	//��ը��λ�ã���Ϊ��̬��ʼ���顣
	static Image[] imgs = new Image[16];//���ѵ㣿����
	static {
		for (int i = 0; i < 16; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");//����GameUtil���е�getImage()������
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