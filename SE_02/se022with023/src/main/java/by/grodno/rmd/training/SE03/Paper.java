package by.grodno.rmd.training.SE03;

public class Paper extends Stationery {
	
	public enum paperFormat {
		A0_PAPER, A1_PAPER, A2_PAPER, A3_PAPER, A4_PAPER, A5_PAPER, DEFAULT_FORMAT_PAPER		
	}
	
	public Paper(int price) {
		type = paperFormat.DEFAULT_FORMAT_PAPER.toString();
		this.price = price;
	}
	
	public Paper(paperFormat type, int price){
		this.type = type.toString();
		this.price = price;
	}
}
