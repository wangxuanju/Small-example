package com;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("header")
public class StrightHeader implements Header {
	@Value("${color}")
	private String color;
	@Value("${size}")
	private int size;
	
	@PostConstruct
	public void init(){
		System.out.println("init the header");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("destroy the header");
		
	}
	
	
	
	
	@Override
	public void doWork() {
		System.out.println("Do work with stright header");

	}

	@Override
	public String getInfo() {
		
		return "StrightHeader:color" + color + "size=" + size;
	}

}
