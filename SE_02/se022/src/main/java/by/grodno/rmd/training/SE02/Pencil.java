package by.grodno.rmd.training.SE02;

public class Pencil extends Stationery {
	
	public enum pencilTypes{
		COLORED_PENCIL_WITH_ERASER,
		COLORED_PENCIL_WITHOUT_ERASER,
		PENCIL_WITH_ERASER,
		PENCIL_WITHOUT_ERASER;	
		
		
	}
	
	public int getById(){
		return pencilTypes.values().length;
		
	}
	public Pencil(double price) {
		type = pencilTypes.PENCIL_WITHOUT_ERASER.toString();
		this.price = price;
	}
	
	public Pencil(pencilTypes type, double price) {
		this.type = type.toString();
		this.price = price;
	}
	
}
