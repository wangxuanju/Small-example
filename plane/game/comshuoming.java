//封装的原则！
//GameObject游戏物体的父类
//各种构造方法，有参的和无参的;
//普通方法
//引入的三个类
//import java.awt.Graphics;//import java.awt.Image;//import java.awt.Rectangle;


//Shell炮弹类
//无参的构造方法
//Graphics g;g.getColor();
//g.setColor(Color.YELLOW);//g.fillOval((int)x,(int) y, width, height);
//普通带参的构造方法


//Plane飞机类
//带参的构造方法和普通方法
//java.awt.event.KeyEvent;
//g.drawImage()方法


//Explode爆炸类
//静态类，有参的构造方法，普通方法
//静态类的作用时加载图片
//


//GameUtil图片路径存储(可能);
//无参的构造方法和普通方法
//java.awt.image;//java.net.URL;
//


//MyGameFrame游戏窗口类
//Image   planeImg  = GameUtil.getImage("images/plane.png");//导入图片
//Image   bg  = GameUtil.getImage("images/bg.jpg");
//Plane   plane = new Plane(planeImg,250,250);飞机类背景图片设为250*250;
//Shell[]   shells = new Shell[50];炮弹类为一个数组
//Explode   bao ;//声明爆炸对象;
//普通的有参方法
//匿名内部类


//Constant常数类便于调节某些值
//public static final int GAME_WIDTH = 500;公共静态的值。
//引用JDK中的类，是为了使用其中的方法。
//总结：1.应用外部类，为了使用其中的方法（作用是实现什么功能）
//2自己编写的类中定义构造方法和普通方法，是为了能被同一包中的mian方法调用。
//3某些类中存在的常数，便于方便的修改和使用。
//4主函数中使如何调用同一包下其它类的
//
//4看别人程序中的构造方法和普通方法是怎么编写的；看程序中变量是如何设置的。怎样使用异常，输入输出的。
//5看程序中怎么实现调用包中的图片，
