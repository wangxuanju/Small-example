package com;

public class StrightHeader implements Header {
	private String color;
	private int size;
    
	public StrightHeader(String color,int size){
		this.color = color;
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
