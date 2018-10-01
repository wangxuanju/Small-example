# 一、HTTP的协议
协议:
* 什么是协议:规定双方需要遵守的规则.

HTTP协议:
* 什么是HTTP协议:用来规定浏览器与服务器之前需要遵守的规则.

HTTP协议的作用：规范浏览器和服务器之间的数据传递.

HTTP协议的特点：
* 基于请求和响应的模型.
    * 必须先有请求后有响应.
    * 请求和响应必须成对出现.
* 默认的端口号是80.

HTTP协议的版本:
* 1.0	:每次响应后即刻关闭了连接.
* 1.1	:现在使用.不是每次响应后挂断,等待长时间以后没有请求会挂断.



# 二、HTTP协议的详解
## 请求部分
### 请求行

    * 提交方式:
        * 提交方式有很多,常用的GET和POST:
        * GET和POST的区别:
            * GET的提交的参数会显示到地址栏上,而POST不显示.
            * GET往往是有大小限制的,而POST没有大小的限制.
            * GET没有请求体,而POST有请求体.
    * 提交路径:
    * 协议版本:
    
### 请求头

    * 都是键值对的形式显示的.一般一个key对应一个value,也有个别的是一个key对应多个value.
    * User-Agent				:代表浏览器的类型. --- 文件下载:下载中文文件:IE使用URLEncodor进行编码,而Firefox使用Base64编码.
    * Referer				:代表的是网页的来源. --- 防盗链.
    * If-Modified-Since		:通常与响应中的头Last-Modified一起使用查找本地缓存.
### 请求体

    * 就是POST提交方式的提交的参数.
## 响应部分
###  响应行:
    * 协议版本
    * 状态码		：
        * 200	：成功
        * 302	：重定向
        * 304	：查找本地缓存
        * 404	：资源不存在
        * 500	：服务器内部错误
    * 状态码描述
### 响应头：键值对,一般一个key对应一个value,也有一个key对应多个value.
    * Last-Modified			:与请求中的If-Modified-Since一起使用查找本地缓存.
    * Content-Dispostion	:文件下载的使用使用的一个头信息.
    * Location				:重定向的跳转的路径.
    * Refresh				:定时刷新/定时跳转.
### 响应体:显示浏览器的页面的内容.

# 三、Servlet的概述
## 什么是Servlet:
* 就是一个运行在WEB服务器上的小的Java程序,用来接收和响应从客户端发送过来的请求,通常使用HTTP协议.
* Servlet就是SUN公司提供的一个动态网页开发技术.
## Servlet的作用：
* 用来处理从客户端浏览器发送的请求,并且可以对请求作出响应
## 使用Servlet：
* 编写一个类实现Servlet接口.
* 将编写的这个类配置到服务器中.
## Servlet的入门:
### 编写类：
public class ServletDemo1 implements Servlet{

	@Override
	/**
	 * 为用户处理请求和响应的方法.
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().println("Hello Servlet...");
	}
...
}
### 配置:
  <!-- 配置Servlet -->
  <servlet>
  	<!-- Servlet的名称 -->
  	<servlet-name>test1</servlet-name>
  	<!-- SErvlet的全路径 -->
  	<servlet-class>com.itheima.a_servlet.ServletDemo1</servlet-class>
  </servlet>
  
  <!-- Servlet的映射 -->
  <servlet-mapping>
  	<!-- Servlet的名称 -->
  	<servlet-name>test1</servlet-name>
  	<!-- Servlet的访问路径 -->
  	<url-pattern>/ServletDemo1</url-pattern>
  </servlet-mapping>
### 访问:
http://localhost:8080/day09/ServletDemo1

## 代码实现

步骤一：创建数据库和表

步骤二：创建包和类

步骤三：引入jar包

引入login的页面

编写Servlet-->Service-->DAO

## Servlet的生命周期:(*****)
### 生命周期:就是一个对象从创建到销毁的过程.
### Servlet生命周期:Servlet从创建到销毁的过程.
* 何时创建:用户第一次访问Servlet创建Servlet的实例
* 何时销毁:当项目从服务器中移除的时候，或者关闭服务器的时候.
### 用户第一次访问Servlet的时候,服务器会创建一个Servlet的实例,那么Servlet中init方法就会执行.任何一次请求服务器都会创建一个新的线程访问Servlet中的service的方法.在service方法内部根据请求的方式的不同调用doXXX的方法.(get请求调用doGet,post请求调用doPost).当Servlet中服务器中移除掉,或者关闭服务器,Servlet的实例就会被销毁,那么destroy方法就会执行.
### Servlet的相关的配置:
#### 启动时创建Servlet
Servlet默认是在第一次访问的时候创建的.现在让Servlet在服务器启动的时候创建好.进行对Servlet的配置:
在web.xml中在<servlet></servlet>标签中配置:
* <load-on-startup>2</load-on-startup>  --- 传入正整数,整数越小,被创建的优先级就越高.
#### url-pattern的配置
url-pattern配置方式共有三种:
1.完全路径匹配	：以 / 开始				例如:	/ServletDemo4 , /aaa/ServletDemo5 , /aaa/bbb/ServletDemo6
2.目录匹配		：以 / 开始 需要以 * 结束.	例如: /* ,/aaa/* ,/aaa/bbb/*
3.扩展名匹配		：不能以 / 开始 以 * 开始的. 例如: *.do , *.action 
***** 错误的写法	： /*.do

```java 有如下的配置:
  <servlet>
    <servlet-name>ServletDemo4</servlet-name>
    <servlet-class>com.itheima.a_servlet.ServletDemo4</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletDemo4</servlet-name>
    <url-pattern>/ServletDemo4</url-pattern>
  </servlet-mapping>

  <servlet>
    <servlet-name>ServletDemo5</servlet-name>
    <servlet-class>com.itheima.a_servlet.ServletDemo5</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletDemo5</servlet-name>
    <url-pattern>/*</url-pattern>
  </servlet-mapping>

  <servlet>
    <servlet-name>ServletDemo6</servlet-name>
    <servlet-class>com.itheima.a_servlet.ServletDemo6</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletDemo6</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>

如果访问地址:
http://localhost:8080/day09/ServletDemo4		:第一个
http://localhost:8080/day09/aaa.do				:第二个
*****　完全路径匹配 > 目录匹配 > 扩展名匹配
```








