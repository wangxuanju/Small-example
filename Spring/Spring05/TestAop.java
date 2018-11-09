package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Caculator caculator = context.getBean("caculator",Caculator.class);
		System.out.println(caculator.add(1, 1));
		System.out.println(caculator.sub(5, 1));
		((ConfigurableApplicationContext)context).close();
		
	}

}
