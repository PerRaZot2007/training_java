package by.grodno.rmd.training;

import java.util.Random;
import java.util.Scanner;

public class MainClass4 {

	public static void main(String[] args) {
		Scanner ioS = new Scanner(System.in);
		int n = ioS.nextInt();
		
		int[] array = new int[2*n];
		
		Random rnd = new Random();
		for(int i =0;i<array.length;i++){
			array[i] = rnd.nextInt(30);
			System.out.print(array[i] + " ");
		}
		
		int max = 0;
		for(int i=0;i<n;i++){
			if(max < array[i] + array[2*n-1-i]){
				max = array[i] + array[2*n-1-i];
			}			
		}
		System.out.println("\nmax = "+max);
		
		ioS.close();
	}
}
