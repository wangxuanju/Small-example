package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Header header = context.getBean("header",StrightHeader.class);
		System.out.println(header.getInfo());
		 header.doWork();
		
		ScrewDriver screwDriver = context.getBean("screwDriver",ScrewDriver.class);
	    screwDriver.use();
		
		((ConfigurableApplicationContext)context).close();
	}

}
