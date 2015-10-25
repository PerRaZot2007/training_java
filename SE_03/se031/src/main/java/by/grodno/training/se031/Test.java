package by.grodno.training.se031;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sp =  new SimpleDateFormat("dd-MM-yyyy : hh-mm - ");
		
		String s = "dd-MM-yyyy : hh-mm - ";
		
		if(sp.toPattern() == s)
		{
			System.out.println("some");
		}
		
		System.out.println(s);
		in.close();
	}

}
