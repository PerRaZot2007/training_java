package se032;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Questions {
	private ResourceBundle bundleQ;
	private ResourceBundle bundleA;
	private Locale loc;
	private ArrayList<String> questions;
	private ArrayList<String> answers;
	
	
	public Questions(Locale loc){
		this.loc = loc;
		questions = new ArrayList<String>();
		answers = new ArrayList<String>();
		choseLanguage(false);
	}
	
	public void choseLanguage(boolean chose){
		if(chose){
			questions.clear();
			answers.clear();
			bundleQ = ResourceBundle.getBundle("questions_ru",loc);
			bundleA = ResourceBundle.getBundle("answer_ru",loc);
			
			for (int i = 1; i <= bundleQ.keySet().size(); i++) {
				questions.add(bundleQ.getString(Integer.valueOf(i).toString()));
				answers.add(bundleA.getString(Integer.valueOf(i).toString()));
			}
		}
		else {
			questions.clear();
			answers.clear();
			bundleQ = ResourceBundle.getBundle("questions_en",loc);
			bundleA = ResourceBundle.getBundle("answer_en",loc);
			
			for (int i = 1; i <= bundleQ.keySet().size(); i++) {
				questions.add(bundleQ.getString(Integer.valueOf(i).toString()));
				answers.add(bundleA.getString(Integer.valueOf(i).toString()));
			}
		}
	}
	
	public void showAllQuestion(){
		for(String s: questions) {
			System.out.println(s);
		}
	}
	
	public void showAnswer(int id) {
		try {
			System.out.println(answers.get(id-1));
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("Wrong ID");
		}
	}
}
