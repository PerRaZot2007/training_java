package by.grodno.rmd.trainingse021;

import by.grodno.rmd.trainingse021.Pen.penTypes;

public class TestMain {

	public static void main(String[] args) {
		Pen pen = new Pen("tukzar1", "black", penTypes.CAPILLARY_PEN);
		Pen pen1 = new Pen("Tkzar1", "purple", penTypes.CAPILLARY_PEN);
		String str;
		System.out.println(pen.getInkPercentage());
		for(int i = 0;i<100; i++){
			str = pen.write("newStringTestMyInkEnd iiiiiiiiiiiiiii");
			System.out.println(pen.getInkPercentage());
		}
		
		pen.changeInk();
		System.out.println(pen.write("test our Ink"));
		
		//pen.setTypeOfPen(penTypes.BALL_PEN);
		System.out.println(pen.toString());
		
		pen1.writeInConsole("some string to test ink");
		System.out.println(pen1.toString());
		
		System.out.println("Pens is equal? " + pen1.equals(pen));
		
		System.out.println(pen1.hashCode() + " and " + pen.hashCode());
		System.out.println("Hash of pens is equal? " + (pen1.hashCode() == pen.hashCode()));
		
		Pen pen2 = pen1;
		System.out.println(pen1.hashCode() + " and " + pen2.hashCode());
		System.out.println("Hash of pens is equal? " + (pen2.hashCode() == pen1.hashCode()));
	}

}
