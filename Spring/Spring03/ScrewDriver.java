package com;

public class ScrewDriver {
	private Header header;
	
	public void setHeader(Header header){
		this.header = header;
		
	}
	
	public void use(){
		System.out.println("Use header:" + header.getInfo());
	    header.doWork();
	    
	}
	

}
