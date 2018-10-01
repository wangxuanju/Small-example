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
http://localhost:8080/day09/aaa.do				:第二个
*****　完全路径匹配 > 目录匹配 > 扩展名匹配
```
## 登录成功以后5秒钟跳转到另一个页面.
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
## 记录网站的登录成功的人数.
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
## ServletConfig:了解.获得Servlet的配置信息.
String getServletName();		---获得Servlet在web.xml中配置的name的值.

String getInitParameter(String name);	---获得Servlet的初始化参数的.

Enumeration getInitParameterNames();		---获得所有Servlet的初始化参数的名称.

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

# 三、requet&response
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
## 步骤分析：
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

# 四、Cookie&Session












