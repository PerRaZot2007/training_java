package by.grodno.rmd.training.se041withSe042;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JavaWord {
	private String filePath = "d:\\java.txt";
	private StringBuilder inputWords = new StringBuilder();
	private ArrayList<String> outputWords = new ArrayList<String>();
	private HashMap<String, Integer> javaKeyWords = new HashMap<String, Integer>();
	
	public JavaWord(){
		getKeyWordsFromFile(filePath);
		setKeyWords();
	}
	
	private void getKeyWordsFromFile(String filePath) {
		try (FileInputStream fileIn = new FileInputStream(filePath)) {
			int i = -1;
			while ((i = fileIn.read()) != -1) {
				if(((char) i)!= '\r' ) {
					inputWords.append((char)i);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setKeyWords(){
		String[] str = inputWords.toString().split("\n");
		for (int i = 0; i < str.length; i++) {
			javaKeyWords.put(str[i], 0);
		}
	}
	
	public HashMap<String, Integer> getMap(){
		return javaKeyWords;
	}
	
	public ArrayList<String> getOutputWords(){
		return outputWords;
	}
}
