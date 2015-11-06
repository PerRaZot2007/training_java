package by.grodno.rmd.training.se041withSe042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class CharIO {
	private StringBuilder text = new StringBuilder();
	private JavaWord jW = new JavaWord();
	private char[] separatorsArray = { ',', '.', ';', ':', '\'', '\"', ']', '[', '{', '}', '(', ')', '<', '>' };


	private void getTextFromFile(String filePath) {
		try (BufferedReader fileIn = new BufferedReader(new FileReader(filePath))) {
			String s;
			while ((s = fileIn.readLine()) != null) {
				for (int i = 0; i < separatorsArray.length; i++) {
					s=s.replace(separatorsArray[i], ' ');
				}
				text.append(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(text);
	}

	private void setTextInFile(String filePath) {
		for (String s : jW.getMap().keySet()) {
			jW.getOutputWords().add(s + " " + jW.getMap().get(s) + "\n");
		}
		
		Comparator<String> com =  new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		};
		
		jW.getOutputWords().sort(com);
		
		try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(filePath))) {
			for (int i = 0; i < jW.getOutputWords().size(); i++) {
				fileOut.write(jW.getOutputWords().get(i));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCountOfKeyWords(String filePathIn, String filePathOut){
		getTextFromFile(filePathIn);
		String[] str = text.toString().split("\\s");
		for (int i = 0; i < str.length; i++) {
			if(jW.getMap().containsKey(str[i])) {
				jW.getMap().put(str[i], jW.getMap().get(str[i])+1);
			}
		}
		System.out.println(jW.getMap().values());
		System.out.println();
		
		setTextInFile(filePathOut);
	}

	/*private Pattern pat;
	private Matcher mat;

	 Integer getCountInLine(String keyWord, String readingString) {
		pat = Pattern.compile(keyWord);
		mat = pat.matcher(readingString);
		int count = 0;
		while (mat.find()) {
			count++;
		}

		return Integer.valueOf(count);
	}*/
}
