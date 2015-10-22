package by.grodno.rmd.training.SE03;

public class Ruler extends Stationery {
	
	private int length;
	
	public Ruler(int length, int price){
		this.length = length;
		this.price = price;
	}
	
	@Override
	public String getType(){
		return "Ruler";
	}
	
	@Override 
	public String toString(){
		return "Stationery type is Ruler. Ruler lenght = " + length+ ". Price: " + price;
	}
	
}
