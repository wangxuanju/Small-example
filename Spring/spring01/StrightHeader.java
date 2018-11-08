package com;

import java.util.Map;

public class StrightHeader implements Header {
	private String color;
	private int size;
    
	public StrightHeader(String color,int size){
		this.color = color;
		this.size = size;
		
	}
	
	/*
	public StrightHeader(Properties props){
		this.color = color;
		this.size = size;
		
	}
	*/
	/*
	//也可以设置为list或set等；修改的同时Beans.xml也需要修改;
	public StrightHeader(Map<String,String> paras){
		this.color = paras.get("color");
		this.size = Integer.valueOf(paras.get("size"));
		
	}
	*/
	
	@Override
	public void doWork() {
		System.out.println("Do work with stright header");

	}

	@Override
	public String getInfo() {
		
		return "StrightHeader:color" + color + "size=" + size;
	}

}
