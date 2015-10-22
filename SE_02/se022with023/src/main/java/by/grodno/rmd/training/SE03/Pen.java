package by.grodno.rmd.training.SE03;

public class Pen extends Stationery {
	
	public enum penTypes{
		GEL_PEN,
		CAPILLARY_PEN,
		BALL_PEN,
		DEFAULT_PEN
	}
	
	public Pen(int price) {
		type = penTypes.DEFAULT_PEN.toString() ;
		this.price = price;		
	}
	 
	public Pen(penTypes type, int price){
		this.type = type.toString();
		this.price = price;
	}
	
	
	
}
