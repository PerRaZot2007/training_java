package by.grodno.rmd.trainingse021;

import javax.print.attribute.standard.MediaSize.Other;

public class Pen {
	public enum penTypes{
		BALL_PEN, GEL_PEN, CAPILLARY_PEN, TYPE_OF_PEN_NOT_SET
	}	
	
	private String manufacturer;
	private String penColor;
	private double size;
	private double inkPercentage;
	private penTypes typeOfPen;
	
	public Pen(){
		manufacturer = getManufacturer();
		penColor = getPenColor();
		size = getSize();
		typeOfPen = getTypeOfPen();
		size = 1.0d;
		inkPercentage = 100.0d;
	}
	
	public Pen(String manufacturer, String penColor, penTypes typeOfPen) {
		this.manufacturer = manufacturer;
		this.penColor = penColor;
		this.typeOfPen =typeOfPen;
		size = 1.0d;
		inkPercentage = 100.0d;
	}
	
	public Pen(String manufacturer, String penColor, penTypes typeOfPen, double size) {
		this.manufacturer = manufacturer;
		this.penColor = penColor;
		this.size = size;
		this.typeOfPen =typeOfPen;
		inkPercentage = 100.0d;
	}
	
	public penTypes getTypeOfPen() {
		if(typeOfPen == null){
			return penTypes.TYPE_OF_PEN_NOT_SET;
		}
		else {
			return typeOfPen;
		}
	}
	public void setTypeOfPen(penTypes typeOfPen) {
		this.typeOfPen = typeOfPen;
	}
	
	public String getManufacturer() {
		if (manufacturer == null) {
			return manufacturer = "Manufacturer isn't set";
		}
		else{
			return manufacturer;
		}
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getPenColor() {
		if(penColor==null){
			return penColor = "Color isn't set";
		}
		else {
			return penColor;
		}
	}
	public void setPenColor(String penColor) {
		this.penColor = penColor;
	}
	
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	
	public double getInkPercentage(){
		return inkPercentage;
	}
	
	private String tempStr;
	public String write(String tempStr){
		
		if(inkPercentage >= tempStr.length()*0.07 ){
			inkPercentage -= tempStr.length() * 0.07;
			return tempStr;
		}
		else {
			System.out.println("Not enough ink");
			return null;
		}
	}
	
	public void writeInConsole(String tempStr) {
		if(inkPercentage >= tempStr.length()*0.07 ){
			inkPercentage -= tempStr.length() * 0.07;
			System.out.println(tempStr);
		}
		else {
			
			System.out.println("Not enough ink");
			
		}
	}
	
	public void changeInk(){
		this.inkPercentage = 100.0d;
	}

	@Override
	public String toString() {
		return "" + typeOfPen +" from manufacturer: " + manufacturer + "; with " + penColor + " ink and size " + size + " mm. Current ink = "
				+ inkPercentage+"%";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer.toLowerCase() == null) ? 0 : manufacturer.toLowerCase().hashCode());
		result = prime * result + ((penColor.toLowerCase() == null) ? 0 : penColor.toLowerCase().hashCode());
		long temp;
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeOfPen == null) ? 0 : typeOfPen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.toLowerCase().equals(other.manufacturer.toLowerCase()))
			return false;
		if (penColor == null) {
			if (other.penColor != null)
				return false;
		} else if (!penColor.toLowerCase().equals(other.penColor.toLowerCase()))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		if (typeOfPen != other.typeOfPen)
			return false;
		return true;
	}
	
	

}