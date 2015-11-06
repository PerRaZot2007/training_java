package by.grodno.rmd.training.se041withSe042;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;

public class ByteIO {
	private StringBuilder text = new StringBuilder();
	private JavaWord jW = new JavaWord();
	private char[] separatorsArray = { ',', '.', ';', ':', '\'', '\"', ']', '[', '{', '}', '(', ')', '<', '>' };

	private boolean isSeparator(char symbol) {
		boolean check = false;
		for (int i = 0; i < separatorsArray.length; i++) {
			if (symbol == separatorsArray[i]) {
				check = true;
			}
		}
		return check;
	}

	private void getTextFromFile(String filePath) {
		try (FileInputStream fileIn = new FileInputStream(filePath)) {
			int i = -1;
			while ((i = fileIn.read()) != -1) {
				if(!isSeparator((char) i )) {
					text.append((char) i);
				}
				else {
					text.append(' ');
				}
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
		
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			fileOut.write(jW.getOutputWords().toString().getBytes(), 0, jW.getOutputWords().toString().length());
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
