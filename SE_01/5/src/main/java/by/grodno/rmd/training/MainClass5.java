package by.grodno.rmd.training;

import java.util.Scanner;

public class MainClass5 {

	public static void main(String[] args) {
		Scanner ioS = new Scanner(System.in);
		int n = ioS.nextInt();
		int[][] array = new int[n][n];
		
		for(int i =0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				if(i==j || (array.length-1-i)==j){
					array[i][j] = 1;
					array[array.length -1 -i][j] = 1;
					System.out.print(array[i][j]);
				}
				else {
					array[i][j] = 0;
					System.out.print(array[i][j]);
				}				
			}
			System.out.println(" ");
		}
		
		ioS.close();
	}

}
