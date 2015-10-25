package by.grodno.rmd.training.atempt101;

import java.util.ArrayList;
import static by.grodno.rmd.training.atempt101.statics.Group.allGroups;


public class Student {
	private String firstName;
	private String surName;	
	private ArrayList<String> currentDisciplines;
	
	public Student(String firstName, String surName) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.currentDisciplines = new ArrayList<String>();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void showAllDisciplines(){
		getDisciplinesForStudent(allGroups);
		for(String s: currentDisciplines) {
			System.out.println(s);
		}
	}

	@Override
	public String toString() {
		return firstName + " " + surName;
	}

	private void getDisciplinesForStudent(Discipline<? extends Number> ... args0){
		currentDisciplines.clear();		
		for(Discipline<? extends Number> d : args0) {
			if(d.containStudent(this)) {
				currentDisciplines.add(d.toString() +" "+d.getRating(this));
			}
		}
	}
}
