# 一、Eclipse断点调试
## Eclipse断点调试概述
Eclipse的断点调试可以查看程序的执行流程和解决程序中的bug
## Eclipse断点调试常用操作:
	 A:什么是断点：
		 就是一个标记，从哪里开始。
	 B:如何设置断点：
		 你想看哪里的程序，你就在那个有效程序的左边双击即可。
	 C:在哪里设置断点：
		 哪里不会点哪里。
		 目前：我们就在每个方法的第一条有效语句上都加。
	 D:如何运行设置断点后的程序：
		 右键 -- Debug as -- Java Application
	 E:看哪些地方：
		 Debug：断点测试的地方
			 在这个地方，记住F6，或者点击也可以。一次看一行的执行过程。
		 Variables：查看程序的变量变化
		 ForDemo：被查看的源文件
		 Console：控制台
	 F:如何去断点：
		 再次双击即可
		 找到Debug视图，Variables界面，找到Breakpoints，并点击，然后看到所有的断点，最后点击那个双叉。
# 二、基础语法的练习
## 循环,if和switch练习
```java
import java.util.Scanner;
public class Test2 {
	public static void main(String[] args) {
		// 键盘录入一个月份,用Scanner实现
		Scanner sc = new Scanner(System.in);

		// 接收数据
		System.out.println("请输入月份(1-12)：");
		int month = sc.nextInt();
   //通过case穿透现象改进代码
		switch(month) {
		case 1:
		case 2:
		case 12:
			System.out.println("冬季");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("春季");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏季");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋季");
			break;
		default:
				System.out.println("你输入的月份有误");
				break;
		}
	}
}
```
## 求数组中满足要求的元素和
```java
 * 需求：
 * (1)定义一个int类型的一维数组，内容为{171,72,19,16,118,51,210,7,18}
 * (2)求出该数组中满足要求的元素和。
 * 		要求：求和的元素的个位和十位不能包含7,并且只能为偶数。
 * 
 * 分析：
 * 		A:定义一个int类型的一维数组
 * 		B:定义一个求和变量
 * 		C:遍历数组，获取到数组中的每一个元素
 * 		D:判断该元素是否满足如下要求，如果是就累加，否则，不搭理它
 * 			x%2==0
 * 			x%10 != 7
 * 			x/10%10 !=7
 * 		E:输出结果
 */
public class Test5 {
	public static void main(String[] args) {
		//定义一个int类型的一维数组
		int[] arr = {171,72,19,16,118,51,210,7,18};
		
		//定义一个求和变量
		int sum = 0;
		
		//遍历数组，获取到数组中的每一个元素
		for(int x=0; x<arr.length; x++) {
			if((arr[x]%10 != 7) && (arr[x]/10%10 != 7) && (arr[x]%2 == 0)) {
				sum += arr[x];
			}
		}
		
		System.out.println("sum:"+sum);
	}
}
```

























