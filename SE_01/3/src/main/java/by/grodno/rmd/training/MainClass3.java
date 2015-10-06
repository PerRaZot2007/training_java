package by.grodno.rmd.training;

import java.util.Scanner;

public class MainClass3 {

	public static void main(String[] args) {
		Scanner ioS = new Scanner(System.in);
		double a  = ioS.nextDouble();
		double b = ioS.nextDouble();
		double h = ioS.nextDouble();
		//double x = ioS.nextDouble();
		double F = 0.0D;
		
		for(double i=a; i<b; i=i+h) {
			F = Math.tan(2*i) -3;
			System.out.print(i*2 + " || " + F+"\n");
		}
		
		ioS.close();
	}

}
