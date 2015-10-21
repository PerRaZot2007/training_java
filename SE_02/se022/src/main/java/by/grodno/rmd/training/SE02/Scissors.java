package by.grodno.rmd.training.SE02;

public class Scissors extends Stationery {
	
	public enum scissorsTypes {
		SCISSORS_FOR_PAPER,
		SCISSOR_FOR_METAL
	}
	
	public Scissors(double price) {
		type = scissorsTypes.SCISSORS_FOR_PAPER.toString();
		this.price = price;
	}
	
	public Scissors(scissorsTypes type, double price) {
		this.type = type.toString();
		this.price = price;
	}
	
}
