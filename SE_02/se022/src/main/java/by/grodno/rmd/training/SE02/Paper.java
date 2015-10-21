package by.grodno.rmd.training.SE02;

public class Paper extends Stationery {
	
	public enum paperFormat {
		A0_PAPER, A1_PAPER, A2_PAPER, A3_PAPER, A4_PAPER, A5_PAPER, DEFAULT_FORMAT_PAPER		
	}
	
	public Paper(double price) {
		type = paperFormat.DEFAULT_FORMAT_PAPER.toString();
		this.price = price;
	}
	
	public Paper(paperFormat type, double price){
		this.type = type.toString();
		this.price = price;
	}
}
