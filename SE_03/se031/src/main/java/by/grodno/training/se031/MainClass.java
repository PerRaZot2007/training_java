package by.grodno.training.se031;

import java.util.Scanner;


public class MainClass {
	
	public static void main(String[] args) {
		CrazyLoggerRMD crz = new CrazyLoggerRMD(new StringBuilder());
		Scanner ioS = new Scanner(System.in);
		boolean notEnd = true;
		do {
			System.out.println("1. Add Information; 2. Find Information; 3. ShowAllInformation; 4. Exit.");
			switch (ioS.nextInt()) {
			case 1: {
				
				crz.addInformation(ioS.next());
				break;
			}
			case 2: {
				crz.findInfoByMessage(ioS.next());
				break;
			}

			case 3: {
				crz.showAllInfo();
				break;
			}

			case 4: {
				notEnd = false;
				break;
			}

			default: {
				System.err.println("Wrong operation");
			}
			}
		} while (notEnd);
		
		ioS.close();
	}
}