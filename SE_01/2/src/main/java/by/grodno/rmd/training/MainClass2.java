package by.grodno.rmd.training;

import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {
		Scanner ioS = new Scanner(System.in);
		int n = ioS.nextInt(); //размерность массива
		int[] array = new int[n]; //инициализация массива
		
		System.out.print("С использованием цикла for ");
		for(int i=0; i<array.length;i++ ){
			array[i] = (i+1)*2;
			if(i%2!=0){
				array[i]=array[i]*array[i-1];
			}
			System.out.print(array[i]+ " ");
		}
		System.out.print("\nС использованием цикла while ");
		int k = 0;
		while(k<array.length) {
			array[k] = (k+1)*2;
			if(k%2!=0){
				array[k]=array[k]*array[k-1];
			}
			System.out.print(array[k]+ " ");
			k++;
		}
		
		System.out.print("\nС использованием цикла do while ");
		k =0;		
		do {
			array[k] = (k+1)*2;
			if(k%2!=0){
				array[k]=array[k]*array[k-1];
			}
			System.out.print(array[k]+ " ");
			k++;
		}		
		while (k<array.length);
		ioS.close();
	}

}
