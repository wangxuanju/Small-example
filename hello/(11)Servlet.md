<!-- GFM-TOC -->
* [一、HTTP的协议](#一http的协议)
* [二、HTTP协议的详解](#二http协议的详解)
    * [请求部分](#请求部分)
    * [响应部分](#响应部分)
* [三、Servlet的概述](#三servlet的概述)
    * [什么是Servlet](#什么是servlet)
    * [Servlet的作用](#servlet的作用)
    * [使用Servlet](#使用servlet)
    * [Servlet的入门](#servlet的入门)
    * [代码实现](#代码实现)
    * [Servlet的生命周期](#servlet的生命周期)
    * [登录成功以后5秒钟跳转到另一个页面](#登录成功以后5秒钟跳转到另一个页面)
    * [记录网站的登录成功的人数](#记录网站的登录成功的人数)
    * [ServletConfig](#servletconfig)
* [四、requet&response](#四requet&response)
    * [Response](#response)
    * [Request](#request)
    * [response处理中文乱码](#response处理中文乱码)
    * [文件下载](#文件下载)
    * [步骤分析](#步骤分析)
    * [网站的注册的功能的实现](#网站的注册的功能的实现)
* [五、Cookie&Session](#五cookie&session)
    * [记录用户的上次登陆访问时间](#记录用户的上次登陆访问时间)
    * [Cookie技术的使用](#cookie技术的使用)
    * [JSP的简单概述](#jsp的简单概述)
    * [JSP的执行过程](#jsp的执行过程)
    * [Cookie的常用API](#cookie的常用api)
<!-- GFM-TOC -->
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
## 什么是Servlet
* 就是一个运行在WEB服务器上的小的Java程序,用来接收和响应从客户端发送过来的请求,通常使用HTTP协议.
* Servlet就是SUN公司提供的一个动态网页开发技术.
## Servlet的作用
* 用来处理从客户端浏览器发送的请求,并且可以对请求作出响应
## 使用Servlet
* 编写一个类实现Servlet接口.
* 将编写的这个类配置到服务器中.
## Servlet的入门
### 编写类
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

## Servlet的生命周期
### 生命周期:就是一个对象从创建到销毁的过程.
### Servlet生命周期:Servlet从创建到销毁的过程.
* 何时创建:用户第一次访问Servlet创建Servlet的实例
* 何时销毁:当项目从服务器中移除的时候，或者关闭服务器的时候.
###### 用户第一次访问Servlet的时候,服务器会创建一个Servlet的实例,那么Servlet中init方法就会执行.任何一次请求服务器都会创建一个新的线程访问Servlet中的service的方法.在service方法内部根据请求的方式的不同调用doXXX的方法.(get请求调用doGet,post请求调用doPost).当Servlet中服务器中移除掉,或者关闭服务器,Servlet的实例就会被销毁,那么destroy方法就会执行.
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
http://localhost:8080/day09/aaa.do			:第二个
*****　完全路径匹配 > 目录匹配 > 扩展名匹配
```
## 登录成功以后5秒钟跳转到另一个页面
### 使用Http协议中的Refresh头信息
Refresh之前已经介绍可以定时页面跳转.需要使用程序设置头信息才可以.
### response中设置响应头
```java
addHeader(String name,String value);		--- 针对一个key对应多个value的响应头.
    * addDateHeader(String name,long date);
    * addIntHeader(String name,int value);

 setHeader(String name,String value);		--- 针对一个key对应一个value的响应头.
    * setDateHeader(String name,long date);
    * setIntHeader(String name,int value);

例如:头信息: xxx:aaa
    * addHeader(“xxx”,”bbb”);		-->xxx:aaa,bbb
    * setHeader(“xxx”,”bbb”);		-->xxx:bbb
```
```java    //在登录成功后的代码上,定时的跳转.
public class UserRefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 解决向页面输出中文的乱码问题!!!
			response.setContentType("text/html;charset=UTF-8");
			// 1.接收表单提交的参数.
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 2.封装到实体对象中.
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			// 3.调用业务层处理数据.
			UserService userService = new UserService();
		
			User existUser = userService.login(user);
			// 4.根据处理结果显示信息(页面跳转).
			if(existUser == null){
				// 登录失败
				response.getWriter().println("<h1>登录失败:用户名或密码错误！~</h1>");
			}else{
				// 登录成功
				// response.getWriter().println("Login Success...");
				response.getWriter().println("<h1>登录成功!您好:"+existUser.getNickname()+"</h1>");
				response.getWriter().println("<h3>页面将在5秒后跳转！</h3>");
				response.setHeader("Refresh", "5;url=/day09/demo5-refresh/index.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
```
```java    //使用JS控制读秒的效果.
<script type="text/javascript">
	var time = 5;
	window.onload = function(){
		setInterval('changeTime()',1000);
	}
	
	function changeTime(){
		time--;
		document.getElementById("s1").innerHTML = time;
	}
</script>
```
## 记录网站的登录成功的人数
需求:登录成功后,5秒后跳转到某个页面,在页面中显示您是第x位登录成功的用户.
```java      //登录代码的Servlet
public class UserCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 初始化一个变量count的值为0.
		int count = 0;
		// 将这个值存入到ServletContext中.
		this.getServletContext().setAttribute("count", count);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			// 1.接收表单提交的参数.
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 2.封装到实体对象中.
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			// 3.调用业务层处理数据.
			UserService userService = new UserService();
		
			User existUser = userService.login(user);
			// 4.根据处理结果显示信息(页面跳转).
			if(existUser == null){
				// 登录失败
				response.getWriter().println("<h1>登录失败：用户名或密码错误!</h1>");
			}else{
				// 登录成功
				
				// 记录次数:
				int count = (int) this.getServletContext().getAttribute("count");
				count++;
				this.getServletContext().setAttribute("count", count);
				
				response.getWriter().println("<h1>登录成功:您好:"+existUser.getNickname()+"</h1>");
				response.getWriter().println("<h3>页面将在5秒后跳转!</h3>");
				response.setHeader("Refresh", "5;url=/day09/CountServlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得Count的值。
		response.setContentType("text/html;charset=UTF-8");
		int count = (int) this.getServletContext().getAttribute("count");
		response.getWriter().println("<h1>您是第"+count+"位登录成功的用户！</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```
## ServletConfig
了解.获得Servlet的配置信息
```jav
String getServletName();		---获得Servlet在web.xml中配置的name的值.

String getInitParameter(String name);	---获得Servlet的初始化参数的.

Enumeration getInitParameterNames();		---获得所有Servlet的初始化参数的名称.
```
### ServletContext:重要
#### ServletContext的作用:
##### 用来获得全局初始化参数.
#####用来获得文件的MIME的类型.
##### 作为域对象存取数据.
ServletContext是一个域对象.
    * 作用范围:整个web工程.
    * 创建:服务器启动的时候,tomcat服务器为每个web项目创建一个单独ServletContext对象.
    * 销毁:服务器关闭的时候,或者项目从服务器中移除的时候.

##### 用来读取web项目下的文件.

# 四、requet&response
## Response
通过response设置状态码：setStatus(int status);

通过response设置响应头：setHeader(String name,String value);,setIntHeader(String name,int value),setDateHeader(String name,long date);

通过response设置响应体：getOutputStream(),getWriter();

response的其他的API:
     * sendRedirect(String path);
     
response输出中文的乱码问题:
     * 字节流输出中文:
         * 设置浏览器的字符集编码.   response.setHeader(“Content-Type”,”text/html;charset=UTF-8”);
         * 设置输出内容的字节数组的字符集编码.		“”.getBytes(“UTF-8”);
     * 字符流输出中文:
         * 设置浏览器字符集编码.		response.setHeader(“Content-Type”,”text/html;charset=UTF-8”);
         * 设置response的缓冲区的编码.		response.setCharacterEncoding(“UTF-8”);
	 
response完成了文件下载功能:

## Request
### 使用request获得客户机的信息.
getRemoteAddr(),getMethod(),getRequestURI(),getRequestURL()

### 获得请求参数:
getParameter(),getParameterValues(),getParameterMap();

### 作为域对象存取数据:
setAttribute(),getAttribute(),removeAttribute();

### 接收参数的中文乱码的处理:
    * GET	:new String(“”.getBytes(“ISO-8859-1”),”UTF-8”)
    * POST	:request.setCharacterEncoding(“UTF-8”);
    
### request何时创建和销毁的?
    * 创建:从客户端向服务器发送请求.那么服务器创建一个request对象.
    * 销毁:服务器为这次请求作出了响应之后,服务器就会销毁request对象.
    * 作用范围:一次请求.
    
## response处理中文乱码
### 字节流：
设置浏览器默认打开编码
response.setHeader("Content-Type", "text/html;charset=UTF-8");

中文转成字节数组编码
response.getOutputStream().write("王守义".getBytes("UTF-8"));

### 字符流:
设置response的缓冲区的编码
response.setCharacterEncoding("UTF-8");

设置浏览器默认打开的编码.
response.setHeader("Content-Type", "text/html;charset=UTF-8");

response.setContentType("text/html;charset=UTF-8");相当于上面两句
## 文件下载
### 一种:超链接方式.（不推荐）
    * <a href=”aa.zip”>下载</a>
    * <a href=”1.jpg”>下载</a>
### 二种:手动编码方式完成文件下载
    * 设置两个头和一个流:
    * Content-Type:文件MIME的类型.
    * Content-Dispostion:
    * 文件的输入流:
## 步骤分析
之前的登录案例已经存在

登录成功跳转的页面上提供一组链接

当点击下载的链接之后,提交到Servlet

设置两个头和一个流
```java //在页面中提供一组下载的链接：
	response.getWriter().println("<h2>手动编码方式下载</h2>");
	response.getWriter().println("<a href='/WEB10/downloadServlet?filename=a.bmp'>a.bmp</a><br/>");
	response.getWriter().println("<a href='/WEB10/downloadServlet?filename=WEB01.zip'>WEB01.zip</a>");

2.编写DownloadServlet：
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  接收参数：
		 *  设置两个头和一个流：
		 *  文件输入流和响应的输出流对接：
		 */
		// 接收参数：get乱码  new String("中文".getBytes("ISO-8859-1"),"UTF-8");
		String filename = request.getParameter("filename");
		System.out.println(filename);
		
		// 设置两个头和一个流:
		// 设置Content-Type头
		String fileType = this.getServletContext().getMimeType(filename);
		response.setContentType(fileType);
		// 设置Content-Disposition:
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		// 设置文件的输入流：
		String path = this.getServletContext().getRealPath("/download/"+filename); // 
		InputStream is = new FileInputStream(path);
		OutputStream os = response.getOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while((len = is.read(b))!=-1){
			os.write(b, 0, len);
		}
		is.close();
	}
```
```java   //中文文件名下载：中文文件在不同的浏览器中编码方式不同：
IE			：URL编码
Firefox		:Base64编码

if(agent.contains("Firefox")){
			// 火狐浏览器
			filename = base64EncodeFileName(filename);
		}else{
			// IE，其他浏览器
			filename = URLEncoder.encode(filename, "UTF-8");
		}

public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
```
## 网站的注册的功能的实现
### 请求对象-request对象
获得客户机信息:
* getMethod();			---获得请求方式.
* getQueryString();		---获得请求路径后的参数.
* getRemoteAddr();		---获得客户机的IP地址.
* getRequestURI();		---获得请求的路径
* getRequestURL();		---获得请求的路径
* getContextPath();		---获得工程名
### 步骤分析：
步骤一：设计注册页面:
步骤二：点击页面中的注册的按钮:提交到Servlet中.
步骤三：在Servlet中接收参数：
步骤四：封装实体中.
步骤五：调用业务层.处理数据.
步骤六：根据处理的结果做出响应.
```java   
1.创建数据库
create database web10;
use web10;
create table user(
	id int primary key auto_increment,
	username varchar(20),
	password varchar(20),
	email varchar(20),
	name varchar(20),
	sex varchar(10),
	birthday date,
	hobby varchar(50)
);

2.接收参数：
* request.getParameter(String name);
* request.getParameterValues(String name);
* request.getParamaterMap();

3.参数接收中的乱码处理.
POST乱码处理：
* <form method=”post”>的时候,这种提交才是POST提交.其他的都是get.
* POST方式提交的参数在请求体中.request对象在后台接收参数.request对象有缓存区.默认缓冲区的编码ISO-8859-1.
* 处理方式：设置request的缓冲区的编码.
    * request.setCharacterEncoding(“UTF-8”);
    
GET方式乱码处理:
* GET方式提交的参数会在地址栏上显示 在请求行的路径后面.浏览器就会对路径进行一次编码.将编码后内容取出来.再进行一次编码.
* 处理方式：
     * 修改服务器提交的编码.
     * 采用URLEncoder 和 URLDecoder类对中文进行编码和解码.
     * 使用String类的构造方法:
         username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);

4.数据的封装：BeanUtils.(内省技术)
```
### 转发和重定向的区别:
#### 重定向
response.sendRedirect(String path); -- 完成重定向
#### 转发
request.getRequestDispatcher(String path).forward(request,response);
#### 区别
1.转发的地址栏不变的.重定向的地址栏发生变化的.

2.转发是一次请求一次响应,重定向是两次请求两次响应.

3.request域对象存取的值在转发中是有效的,在重定向无效的.

4.转发的路径不需要加工程名.重定向的路径需要加工程名.
#### 使用转发和重定向对登录的功能优化:
使用request域保存一个值:在一次请求范围内有效的.

登录失败就可以保存一个错误信息到request中在动态页面中取出这个值${msg}

# 五、Cookie&Session
## 记录用户的上次登陆访问时间
### 需求:
用户登录完成后,显示您是第x位访问的用户,您的上次访问时间是:yyyy-MM-dd.

* 如果第一次访问的话，只显示您是第x位用户.

* 如果不是第一次访问的话,显示您是第x位访问的用户,您的上次访问时间是:yyyy-MM-dd.
### 会话技术
#### 什么是会话
用户打开一个浏览器访问页面,访问网站的很多页面,访问完成后将浏览器关闭的过程称为是一次会话.

#### 常见的会话技术

* Cookie	:将数据保存到客户端浏览器.

* Session	:将数据保存到服务器端.

#### 为什么使用会话技术?
* 私有的数据,购物信息数据保存在会话技术中.
参见图一和图二
使用会话技术:

## Cookie技术的使用
向浏览器保存数据:
HttpServletResponse有一个方法:
* void addCookie(Cookie cookie);
获得浏览器带过来的Cookie:
HttpServletRequest有一个方法:
* Cookie[] getCookies();
创建一个Cookie对象:
* Cookie(String name,String value);

## JSP的简单概述
什么是JSP	:Java Server Pages(Java服务器端页面).JSP = Java代码 + HTML的元素 + JSP内置东西
SUN公司为什么推出JSP动态网页开发技术:
* SUN公司推出的Servlet技术进行动态网页开发.发现Servlet自身有不足没有办法与ASP,PHP技术竞争.想在动态网页中输出表单.在Servlet中获得PrintWriter out = response.getWriter();
* out.println(“<form action=’’ method=’’>”);
* out.println(“</form>”);
* SUN又推出了动态的网页开发技术就是JSP.

## JSP的执行过程
* JSP会被翻译成Servlet,编译成class进行执行的.
JSP的嵌入Java代码:JSP的脚本元素
* <%!    %>:翻译成类中的成员部分. 定义变量,定义方法,定义类.Servlet是线程不安全的,尽量少在类中定义成员属性！！
* <%     %>:翻译成类的service方法内部的内容. 定义变量,定义类,直接写代码块.
* <%=    %>:翻译成service方法内部的out.print();
```java
步骤分析:
【步骤一】：准备登陆的案例.
【步骤二】：在统计人数的Servlet中.判断是否是第一次访问.
【步骤三】：根据是否是第一次显示不同的信息，同时将当前的时候保存到Cookie中.
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer count = (Integer) this.getServletContext().getAttribute("count");
                //response.getWriter().println("<h1>现在网站被访问的次数为:"+count+"</h1>");
		
		/**
		 * 获得浏览器中带过来的所有的Cookie信息,从数组中查找有没有指定名称的Cookie
		 * 判断用户是否是第一次访问:(从数组中没有找到指定名称的Cookie)
		 * * 如果是第一次:显示欢迎,记录当前访问的时间存入到Cookie中.
		 * * 如果不是第一次:显示欢迎,上一次访问时间,同时记录当前访问的时间存入到Cookie中。
		 */
		// 获得浏览器带过来的所有的Cookie:
		Cookie[] cookies = request.getCookies();
		// 从数组中查找指定名称的Cookie:
		Cookie cookie = CookieUtils.findCookie(cookies, "lastVisit");
		// 判断是否是第一次:
		if(cookie == null){
			// 第一次访问
			response.getWriter().println("您是第"+count+"位访客!");
		}else{
			// 不是第一次
			Long l = Long.parseLong(cookie.getValue());
			Date d = new Date(l);
			response.getWriter().println("您是第"+count+"位访客! 上次访问时间是:"+d.toLocaleString());
		}
		// 创建一个Cookie对象:
		Cookie c = new Cookie("lastVisit",""+System.currentTimeMillis());
		// 保存到浏览器端:
		response.addCookie(c);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
```
## Cookie的常用API
### Cookie的常用的API
```java
* getName();
* getValue();
* setDomain(String domain); -- 设置Cookie的有效域名. //  www.baidu.com  music.baidu.com
* setPath(String path); -- 设置Cookie的有效路径.
* setMaxAge(int maxAge); -- 设置Cookie的有效时间.
```
### Cookie的分类有关:
* 会话级别的Cookie:默认的Cookie.关闭浏览器Cookie就会销毁.
* 持久级别的Cookie:可以设置Cookie的有效时间.那么关闭浏览器Cookie还会存在. 手动销毁持久性Cookie. setMaxAge(0)---前提是有效路径必须一致.
```java      //记录用户的商品浏览记录
步骤分析:
【步骤一】：在登录完成后，显示商品列表页面.
【步骤二】：为商品列表页面做一些准备工作.
【步骤三】：点击某个商品,将商品ID传递一个Servlet.
【步骤四】：在Servlet中:判断是否是第一次浏览商品
【步骤五】：如果是第一次：将商品的ID存入到Cookie中即可.
【步骤六】：如果不是第一次：判断该商品是否已经浏览了.
【步骤七】：如果浏览器过.删除之前元素,将该元素添加到最前面.
【步骤八】：如果没有浏览过该商品.判断最大长度，没有超过限制,直接加到最前,如果已经超过限制,删除最后一个，将其插入到最前.
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * * 接收商品id.
		 * * 接收从客户端带过来的所有Cookie.
		 * * 从Cookie的数组中查找指定名称的Cookie.
		 * * 判断是否是第一次浏览商品:
		 *     * 第一次浏览商品
		 *        * 直接将商品的ID存入到Cookie.
		 *        * 将Cookie回写到浏览器.
		 *     * 不是第一次浏览商品 1-2
		 *        * 判断当前的商品是否已经在浏览记录.
		 *            * 已经存在: 2-1 移除当前元素，将当前元素添加到最开始.
		 *            * 没在浏览记录中: 
		 *                * 判断是否已经超过了最大长度:如果超过 2-1-3:删除最后一个 将当前元素添加到最前面.
		 *                * 没有超过:直接将该元素添加到最前位置.
		 *        * 将转换的id的值存入到Cookie,回写浏览器.
		 */
		// 接收id:
		String id = request.getParameter("id");
		// 获得所有的Cookie的信息:
		Cookie[] cookies = request.getCookies();
		// 判断是否是第一次:
		Cookie cookie = CookieUtils.findCookie(cookies, "history");
		if(cookie == null){
			// 第一次浏览商品
			Cookie c = new Cookie("history",id);
			c.setPath("/day11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}else{
			// 不是第一次浏览
			// 判断选择的商品是否已经在浏览记录中 2-1
			String value = cookie.getValue();
			String[] ids = value.split("-");
			// 将数组变为集合：
			LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
			if(list.contains(id)){
				// 之前浏览过该商品
				list.remove(id); // 1-2-3
				list.addFirst(id);
			}else{
				// 没有浏览过该商品.
				if(list.size() >=3 ){
					// 超过3个
					list.removeLast();
					list.addFirst(id);
				}else{
					// 没到3个.
					list.addFirst(id);
				}
			}
			// 将list中的元素取出,使用-连接上保存到Cookie,写回浏览器.
			StringBuffer sb = new StringBuffer();
			for(String s:list){
				sb.append(s).append("-");
			}
			String sValue = sb.toString().substring(0,sb.length()-1);
			System.out.println(sValue);
			// 存入到Cookie中
			Cookie c = new Cookie("history",sValue);
			c.setPath("/day11");
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}
		
		request.getRequestDispatcher("/demo2/product_info.htm").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
```
```java        //清空浏览记录
删除持久性的Cookie:
public class ClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("history",null);
		cookie.setPath("/day11");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		response.sendRedirect("/day11/demo2/product_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
```
### 将商品添加到购物车
```java
步骤分析:
【步骤一】：点击加入购物车提交到Servlet
【步骤二】：在Servlet将购物的商品存入到Session中.
【步骤三】：可以创建一个Map集合用于保存购物信息Map的key可以是商品的名称,Map的value是数量.
【步骤四】：在购物车页面中显示Map中的数据就可以.
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收商品名称:
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		// 创建Map集合用于保存购物信息.Map<String,Integer> Map的key是商品的名称 value是购买的数量.
		Map<String,Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(map == null){
			map = new LinkedHashMap<String,Integer>();
		}
		// 判断购物车中是否已经买了该商品.
		if(map.containsKey(name)){
			// map中已经有该商品:// * 如果购物车中已经有该商品: 获得到Map中该商品的数量+1。 存回到Map集合中.
			Integer count = map.get(name);
			count++;
			map.put(name, count);
		}else{
			// map中没有该商品.// * 如果购物车中没有改商品: 将商品添加到Map集合中 数量1.
			map.put(name, 1);
		}
		
		
		// * 将Map集合保存到session中.
		request.getSession().setAttribute("cart", map);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<h3><a href='/day11/demo2/product_list.jsp'>继续购物</a> | <a href='/day11/demo2/cart.jsp'>去结算</a></h3>");
	}
```
### 进行一次性验证码的校验
需求：在登录的页面中，需要有一个验证码的校验.
```java
步骤分析:
【步骤一】：生成验证码,将生成验证码的随机的4个字母或数字保存到session中.
【步骤二】：在页面中输入验证码值,点提交.
【步骤三】：在Servlet中从表单中获得验证码从session中获得一个验证码.
【步骤四】：比对两个验证码值是否一致.
【步骤五】：将session中保存的验证码清空.
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 校验验证码程序:
		String code1 = request.getParameter("code");
		String code2 = (String) request.getSession().getAttribute("code");
		request.getSession().removeAttribute("code");
		if(!code1.equalsIgnoreCase(code2)){
			request.setAttribute("msg", "验证码输入错误！");
			request.getRequestDispatcher("/demo2/login.jsp").forward(request, response);
			return ;
		}
   ...
}

//使用JS控制图片切换:
 <script type="text/javascript">
 	function changeImg(){
 		document.getElementById("img1").src="/day11/CheckImgServlet?time="+new Date().getTime();
 	}
 </script>
```
