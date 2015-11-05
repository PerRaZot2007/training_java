package by.grodno.rmd.training.se041;

import java.util.Date;
import java.util.HashMap;

public class Test {

	public static void main(String[] str) {

		HashMap<String, Integer> hM = new HashMap<String, Integer>();

		hM.put("public", 0);
		hM.put("Stationery", 0);
		hM.put("void", 0);
		hM.put("double", 0);

		System.out.println(hM.get("void"));

		ByteIO b = new ByteIO();
		/*b.getTextFromFile("d:\\NewbiePack.java");

		Date d = new Date();
		long a1 = d.getTime();
		System.out.println(b.getCountInLine("class", b.getText().toString()));
		Date d1 = new Date();
		long a2 = d1.getTime();
		System.out.println(a2 - a1);
		b.setText("d:\\file.txt");

		String[] str2 = b.getText().toString().split("\\s");
		for (int i = 0; i < str2.length; i++) {
			if(hM.containsKey(str2[i])){
				hM.put(str2[i], hM.get(str2[i]) + 1);
			}
		}
		
		System.out.println(hM.values());*/
		b.getCountOfKeyWords("d:\\NewbiePack.java", "d:\\test.txt");
		
	}

}
