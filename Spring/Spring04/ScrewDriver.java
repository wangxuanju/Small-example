package com;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class ScrewDriver {
	//二者有不同的应用场景，深究
	//@Autowired
	@Resource
	private Header header;
	
	

	
	public void use(){
		System.out.println("Use header:" + header.getInfo());
	    header.doWork();
	    
	}
	

}
