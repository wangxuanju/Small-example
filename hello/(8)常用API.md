# 一、API概述
API(Application Programming Interface) : 应用程序编程接口

Java API指的就是JDK中提供的各种功能的Java类

## 使用API步骤:
A:打开帮助文档
B:点击显示，找到索引，看到输入框
C:你要学习什么内容，你就在框框里面输入什么内容
	  举例：Random
D:看包
java.lang包下的类在使用的时候是不需要导包的
E:看类的描述
	Random类是用于生成随机数的类
F:看构造方法
```java
	  Random():无参构造方法
		Random r = new Random();\
```
G:看成员方法
```java
	   public int nextInt(int n):产生的是一个[0,n)范围内的随机数
```
		调用方法：
			看返回值类型：人家返回什么类型，你就用什么类型接收
			看方法名：名字不要写错了
			看形式参数：人家要几个参数，你就给几个，人家要什么数据类型的，你就给什么数据类型的
```java
			        int number = r.nextInt(100);
```
# 二、Scanner与String类







# 三、StringBuilder类
