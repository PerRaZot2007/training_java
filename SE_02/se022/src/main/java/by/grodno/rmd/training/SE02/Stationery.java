package by.grodno.rmd.training.SE02;

public abstract class Stationery {
	protected String type;
	protected double price;
	
	protected String getType() {
		return type;
	}
	
	protected double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Stationery type is " + type + ". Price: " + price;
	}	
}
