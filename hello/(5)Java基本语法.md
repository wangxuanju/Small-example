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
























# 二、数组









# 三、方法
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




