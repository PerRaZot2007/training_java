package by.grodno.rmd.training.SE02;

public class Pen extends Stationery {
	
	public enum penTypes{
		GEL_PEN,
		CAPILLARY_PEN,
		BALL_PEN,
		DEFAULT_PEN
	}
	
	public Pen(double price) {
		type = penTypes.DEFAULT_PEN.toString() ;
		this.price = price;		
	}
	 
	public Pen(penTypes type, double price){
		this.type = type.toString();
		this.price = price;
	}
	
	
	
}
