package com;

import java.util.Map;

public class StrightHeader implements Header {
	private String color;
	private int size;
    public void setColor(String color){
    	this.color = color;
    	
    }
    public void setSize(int size){
    	this.size = size;
    	
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
