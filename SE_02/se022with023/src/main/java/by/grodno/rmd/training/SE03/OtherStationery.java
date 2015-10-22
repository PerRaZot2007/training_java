package by.grodno.rmd.training.SE03;

public class OtherStationery extends Stationery {
	
	public enum otherTypes {
		PROTRACTOR,
		PENCIL_SHARPENER,
		ERASER,
		PAPER_KNIFE
	}
	
	public OtherStationery(String newType, int price) {
		type = newType;
		this.price = price;
	}
	
	public OtherStationery(otherTypes other, int price) {
		this.type = other.toString();
		this.price = price;
	}
}
