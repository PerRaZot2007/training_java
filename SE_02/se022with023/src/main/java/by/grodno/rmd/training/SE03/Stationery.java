package by.grodno.rmd.training.SE03;

public abstract class Stationery {
	protected String type;
	protected int price;
	
	protected String getType() {
		return type;
	}
	
	protected int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Stationery type is " + type + ". Price: " + price;
	}	
}
