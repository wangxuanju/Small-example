# 一、Random
## 产生随机数的类---Random:
 作用：–用于产生一个随机数
 
•使用步骤(和Scanner类似)

–导包

•import java.util.Random;

–创建对象

•Random r = new Random();

–获取随机数

•int number = r.nextInt(10);

•产生的数据在0到10之间，包括0，不包括10。

•括号里面的10是可以变化的，如果是100，就是0-100之间的数据
```java
import java.util.Random;
import java.util.Scanner;
/*
 * 猜数字小游戏案例
 *		系统产生一个1-100之间的随机数，请猜出这个数据是多少。
 * 分析：
 * 		A:系统产生一个随机数1-100之间的。
 * 			int number = r.nextInt(100) + 1;
 * 		B:键盘录入我们要猜的数据
 * 			用Scanner实现
 *		C:比较这两个数据(用if语句)
 *			大了：给出提示大了
 *			小了：给出提示小了
 *			猜中了：给出提示，恭喜你，猜中了
 *		D:多次猜数据，而我们不知道要猜多少次，怎么办呢?
 *			while(true) {循环的内容}
 */
public class RandomTest {
	public static void main(String[] args) {
		// 系统产生一个随机数1-100之间的。
		Random r = new Random();
		int number = r.nextInt(100) + 1;

		while(true){
			// 键盘录入我们要猜的数据
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你要猜的数字(1-100)：");
			int guessNumber = sc.nextInt();
	
			// 比较这两个数据(用if语句)
			if (guessNumber > number) {
				System.out.println("你猜的数据" + guessNumber + "大了");
			} else if (guessNumber < number) {
				System.out.println("你猜的数据" + guessNumber + "小了");
			} else {
				System.out.println("恭喜你,猜中了");
				break;
			}
		}
	}
}
```
# 二、数组
## 动态初始化:
初始化时只指定数组长度，由系统为数组分配初始值

格式：数据类型[] 数组名 = new 数据类型[数组长度];

数组长度其实就是数组中元素的个数。
```java
/*
 * 定义格式：
 * 		A:数据类型[] 数组名;
 * 		B:数据类型 数组名[];
 * 举例：
 * 		A:int[] a; 定义一个int类型的数组，数组名是a
 * 		B:int a[]; 定义一个int类型的变量，变量名是a数组
 * 
 * 数组初始化：
 * 		A:所谓初始化，就是为数组开辟内存空间，并为数组中的每个元素赋予初始值
 * 		B:我们有两种方式对数组进行初始化
 * 			a:动态初始化	只指定长度，由系统给出初始化值
 * 			b:静态初始化	给出初始化值，由系统决定长度
 * 
 * 动态初始化：
 * 		数据类型[] 数组名 = new 数据类型[数组长度];
 */
public class ArrayDemo {
	public static void main(String[] args) {
		//数据类型[] 数组名 = new 数据类型[数组长度];
		int[] arr = new int[3];
		/*
		 * 左边：
		 * 		int:说明数组中的元素的数据类型是int类型
		 * 		[]:说明这是一个数组
		 * 		arr:是数组的名称
		 * 右边：
		 * 		new:为数组分配内存空间
		 * 		int:说明数组中的元素的数据类型是int类型
		 * 		[]:说明这是一个数组
		 * 		3:数组的长度，其实就是数组中的元素个数
		 */
	
	}
}
```
### 静态初始化
初始化时指定每个数组元素的初始值，由系统决定数组长度
```java
/*
 * 静态初始化的格式：
 * 		数据类型[] 数组名 = new 数据类型[]{元素1,元素2,...};
 * 
 * 		简化格式：
 * 			数据类型[] 数组名 = {元素1,元素2,...};
 * 
 * 		举例：
 * 			int[] arr = new int[]{1,2,3};
 * 
 * 		简化后：
 * 			int[] arr = {1,2,3};
 */
public class ArrayDemo2 {
	public static void main(String[] args) {
		//定义数组
		int[] arr = {1,2,3};
		
		//输出数组名和元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
```
## 三、数组的内存分配
### JVM内存划分
Java程序在运行时，需要在内存中的分配空间。为了提高运算效率，就对空间进行了不同区域的划分，因为每一片区域都有特定的处理数据方式和内存管理方式。

栈 存储局部变量

堆 存储new出来的东西

方法区 (面向对象进阶讲)

本地方法区 (和系统相关)

寄存器 (给CPU使用)
### 一个数组的内存图
定义一个数组，输出数组名及元素。然后给数组中的元素赋值，再次输出数组名及元素
```java
/*
 * 需求：定义一个数组，输出数组名及元素。然后给数组中的元素赋值，再次输出数组名及元素。
 */
public class ArrayTest {
	public static void main(String[] args) {
		//定义一个数组
		int[] arr = new int[3];
		
		//输出数组名及元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		//给数组中的元素赋值
		arr[0] = 100;
		arr[2] = 200;
		
		//再次输出数组名及元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
```
### 两个数组的内存图
```java
/*
 * 需求：定义两个数组，分别输出数组名及元素。然后分别给数组中的元素赋值，分别再次输出数组名及元素。
 */
public class ArrayTest2 {
	public static void main(String[] args) {
		//定义两个数组
		int[] arr = new int[2];
		int[] arr2 = new int[3];
		
		//分别输出数组名及元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(arr2);
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		//然后分别给数组中的元素赋值
		arr[1] = 100;
		
		arr2[0] = 200;
		arr2[2] = 300;
		
		//再次输出数组名及元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(arr2);
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
	}
}
```
### 两个数组指向同一个地址的内存图
```java
/*
 * 需求：定义两个数组，先定义一个数组，赋值，输出。然后定义第二个数组的时候把第一个数组的地址赋值给第二个数组。
 * 然后给第二个数组赋值，再次输出两个数组的名及元素。
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		// 先定义一个数组，赋值，输出
		int[] arr = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		// 然后定义第二个数组的时候把第一个数组的地址赋值给第二个数组
		int[] arr2 = arr;
		// 然后给第二个数组赋值
		arr2[0] = 111;
		arr2[1] = 222;
		arr2[2] = 333;

		// 再次输出两个数组的名及元素
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr2);
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
	}
}
```
## 二维数组格式
定义格式

数据类型[][] 数组名;

数据类型 数组名[][]; 不推荐

数据类型[] 数组名[]; 不推荐

初始化方式

数据类型[][] 变量名 = new 数据类型[m][n];

数据类型[][] 变量名 = new 数据类型[][]{{元素…},{元素…},{元素…}};

简化版格式：数据类型[][] 变量名 = {{元素…},{元素…},{元素…}};
```java
public class ArrayArrayTest {
	public static void main(String[] args) {
		// 定义二维数组
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 二维数组中的一维数组名称：二维数组名[索引]
		// arr[0] 其实就是二维数组中的第一个一维数组的名称
		// arr[1] 其实就是二维数组中的第二个一维数组的名称
		// arr[2] 其实就是二维数组中的第三个一维数组的名称

		// for (int x = 0; x < arr[0].length; x++) {
		// System.out.println(arr[0][x]);
		// }

		// System.out.println("hello");
		// System.out.println("world");
		// System.out.print("hello");
		// System.out.print("world");

		/*
		// 第一个一维数组的元素
		for (int x = 0; x < arr[0].length; x++) {
			System.out.print(arr[0][x] + "  ");
		}
		System.out.println();

		// 第二个一维数组的元素
		for (int x = 0; x < arr[1].length; x++) {
			System.out.print(arr[1][x] + "  ");
		}
		System.out.println();

		// 第三个一维数组的元素
		for (int x = 0; x < arr[2].length; x++) {
			System.out.print(arr[2][x] + "  ");
		}
		System.out.println();
		*/
		
//		for(int y=0; y<3; y++) {
//			for (int x = 0; x < arr[y].length; x++) {
//				System.out.print(arr[y][x] + "  ");
//			}
//			System.out.println();
//		}
		
		for(int y=0; y<arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				System.out.print(arr[y][x] + "  ");
			}
			System.out.println();
		}

	}
}
```
# 四、方法
##   方法重载
```java  //方法重载练习之比较数据是否相等
/*
 * 需求：比较两个数据是否相等。参数类型分别为两个byte类型，两个short类型，两个int类型，两个long类型，
 *     并在main方法中进行测试
 */
public class MethodTest {
	public static void main(String[] args) {
		// 调用
		System.out.println(compare(10, 20));
		System.out.println("-------------");
		System.out.println(compare((byte)10, (byte)20));
		System.out.println("-------------");
		System.out.println(compare((short)10, (short)20));
		System.out.println("-------------");
		//System.out.println(compare((long)10, (long)20));
		System.out.println(compare(10L, 20L));
	}

	// 两个byte类型的
	public static boolean compare(byte a, byte b) {
		System.out.println("byte");
		// 第一种写法
		// boolean flag = a==b?true:false;
		// return flag;
		// 第二种写法
		// boolean flag = a == b;
		// return flag;
		// 第三种写法
		return a == b;
	}

	// 两个short类型的
	public static boolean compare(short a, short b) {
		System.out.println("short");
		return a == b;
	}

	// 两个int类型的
	public static boolean compare(int a, int b) {
		System.out.println("int");
		return a == b;
	}

	// 两个long类型的
	public static boolean compare(long a, long b) {
		System.out.println("long");
		return a == b;
	}
}
```
## 方法中参数传递
### 方法的形式参数为基本数据类型
方法的参数是基本类型的时候：
  		形式参数的改变不影响实际参数。
  形式参数：用于接收实际数据的变量
  实际参数：实际参与运算的变量
```java
public class ArgsDemo {
	public static void main(String[] args) {
		// 定义变量
		int a = 10;
		int b = 20;
		System.out.println("a:" + a + ",b:" + b);// a:10,b:20
		change(a, b);
		System.out.println("a:" + a + ",b:" + b);// a:10,b:20
	}

	public static void change(int a, int b) { // a=10,b=20
		System.out.println("a:" + a + ",b:" + b);// a:10,b:20
		a = b; // a=20;
		b = a + b;// b=40;
		System.out.println("a:" + a + ",b:" + b);// a:20,b:40
	}

}
```
## 方法的形式参数为引用数据类型
```java
/*
 * 方法的参数是引用类型：
 * 		形式参数的改变直接影响实际参数
 */
public class ArgsDemo2 {
	public static void main(String[] args) {
		// 定义数组
		int[] arr = { 1, 2, 3, 4, 5 };
		// 遍历数组
		for (int x = 0; x < arr.length; x++) {
			System.out.println(arr[x]);
		}
		System.out.println("----------------");
		change(arr);
		for (int x = 0; x < arr.length; x++) {
			System.out.println(arr[x]);
		}
	}

	public static void change(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			// 如果元素是偶数，值就变为以前的2倍
			if (arr[x] % 2 == 0) {
				arr[x] *= 2;
			}
		}
	}
}
```

## 方法操作数组
### 方法的练习之数组遍历
需求：把遍历数组改进为方法实现，并调用方法
```java
/*
 * 需求：把遍历数组改进为方法实现，并调用方法
 */
public class MethodTest {
	public static void main(String[] args) {
		// 定义数组
		int[] arr = { 11, 22, 33, 44, 55 };

		// 遍历
		// for (int x = 0; x < arr.length; x++) {
		// System.out.println(arr[x]);
		// }
		
		//用方法改进
		//printArray(arr);
		
		//这一次虽然可以，但是我觉得格式不好看，能不能打印成下面的格式呢?
		//[元素1, 元素2, 元素3, ...]
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for(int x=0; x<arr.length; x++){
			if(x==arr.length-1){
				System.out.println(arr[x]+"]");
			}else {
				System.out.print(arr[x]+", ");
			}
		}
	}
	
	/*
	 * 两个明确：
	 * 		返回值类型：void
	 * 		参数列表：int[] arr
	 */
//	public static void printArray(int[] arr) {
//		for(int x=0; x<arr.length; x++){
//			System.out.println(arr[x]);
//		}
//	}
}
```
### 方法的练习之数组获取最值
需求：把获取数组最值改进为方法实现，并调用方法
```java
/*
 * 需求：把获取数组最值改进为方法实现，并调用方法
 */
public class MethodTest2 {
	public static void main(String[] args) {
		// 定义数组
		int[] arr = { 34, 67, 10, 28, 59 };
		
		//获取数组中的最大值
		// //定义参照物
		// int max = arr[0];
		// //遍历，依次比较，大的留下来
		// for(int x=1; x<arr.length; x++) {
		// if(arr[x] > max) {
		// max = arr[x];
		// }
		// }
		
		//用方法改进
		int max = getMax(arr);
		System.out.println("max:"+max);
		
		//获取数组中的最小值，用方法实现
		int min = getMin(arr);
		System.out.println("min:"+min);
		
	}
	
	//获取数组中的最小值的方法
	public static int getMin(int[] arr) {
		int min = arr[0];
		
		for(int x=1; x<arr.length; x++) {
			if(arr[x] < min) {
				min = arr[x];
			}
		}
		
		return min;
	}
	
	/*
	 * 两个明确：
	 * 		返回值类型：int
	 * 		参数列表：int[] arr
	 */
	public static int getMax(int[] arr) {
		int max = arr[0];
		
		for(int x=1; x<arr.length; x++) {
			if(arr[x] > max) {
				max = arr[x];
			}
		}
		
		return max;
	}
}
```
# 五、其它
## 三种循环的区别
### 区别概述
虽然可以完成同样的功能，但是还是有小区别：

do…while循环至少会执行一次循环体。

for循环和while循环只有在条件成立的时候才会去执行循环体

for循环语句和while循环语句的小区别：

使用区别：控制条件语句所控制的那个变量，在for循环结束后，就不能再被访问到了，而while循环结束还可以继续使用，如果你想继续使用，就用while，否则推荐使用for。原因是for循环结束，该变量就从内存中消失，能够提高内存的使用效率。
## continue的作用：
单层循环对比break，然后总结两个的区别

break  退出当前循环

continue  退出本次循环

## 键盘录入的基本步骤
### 键盘录入数据概述
我们目前在写程序的时候，数据值都是固定的，但是实际开发中，数据值肯定是变化的，所以，把数据改进为键盘录入，提高程序的灵活性。

键盘录入数据的步骤:

A:导包(位置放到class定义的上面)
	import java.util.Scanner;
B:创建对象
	Scanner sc = new Scanner(System.in);
C:接收数据
	int x = sc.nextInt();
	
```java
import java.util.Scanner;
/*
 * 键盘录入三个数据，获取这三个数据中的最大值
 */
public class ScannerTest3 {
	public static void main(String[] args) {
		// 创建对象
		Scanner sc = new Scanner(System.in);

		// 接收数据
		System.out.println("请输入第一个数据：");
		int a = sc.nextInt();

		System.out.println("请输入第二个数据：");
		int b = sc.nextInt();

		System.out.println("请输入第三个数据：");
		int c = sc.nextInt();

		// 如何获取三个数据的最大值
		int temp = (a > b ? a : b);
		int max = (temp > c ? temp : c);

		System.out.println("max:" + max);
	}
}
```
