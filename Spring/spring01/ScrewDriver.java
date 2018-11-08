public class ScrewDriver {
	private Header header;
	
	public ScrewDriver(Header header){
		this.header = header;
	}
	
	public void use(){
		System.out.println("Use header:" + header.getInfo());
	    header.doWork();
	    
	}
	

}
