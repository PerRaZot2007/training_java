package by.grodno.rmd.training.SE02;

public class OtherStationery extends Stationery {
	
	public enum otherTypes {
		PROTRACTOR,
		PENCIL_SHARPENER,
		ERASER,
		PAPER_KNIFE
	}
	
	public OtherStationery(String newType, double price) {
		type = newType;
		this.price = price;
	}
	
	public OtherStationery(otherTypes other, double price) {
		this.type = other.toString();
		this.price = price;
	}
}
