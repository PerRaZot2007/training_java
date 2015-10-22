package by.grodno.rmd.training.SE03;

public class Scissors extends Stationery {
	
	public enum scissorsTypes {
		SCISSORS_FOR_PAPER,
		SCISSOR_FOR_METAL
	}
	
	public Scissors(int price) {
		type = scissorsTypes.SCISSORS_FOR_PAPER.toString();
		this.price = price;
	}
	
	public Scissors(scissorsTypes type, int price) {
		this.type = type.toString();
		this.price = price;
	}
}
