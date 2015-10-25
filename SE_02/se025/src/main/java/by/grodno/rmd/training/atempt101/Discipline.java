package by.grodno.rmd.training.atempt101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Discipline<T extends Number> {
	public enum disciplineTypes {
		ALGEBRA, ENGLISH, FUNCTIONAL_ANALYSIS, GEOMETRY, INFORMATHIC, MATHEMATIC_ANALYSIS, OPTIMIZATION_MEHTODS, PSYHOLOGY
	}

	private String name;
	private ArrayList<Student> studentList;
	private ArrayList<T> rateList;

	public Discipline(disciplineTypes name) {
		this.name = name.toString();
		studentList = new ArrayList<Student>();
		rateList = new ArrayList<T>();
	}

	public void addStudent(Student newStudent, T rate) {
		if (!studentList.contains(newStudent)) {
			studentList.add(newStudent);
			rateList.add(rate);
		} else {
			System.out.printf("%s %s is already added to %s group.", newStudent.getFirstName(), newStudent.getSurName(),
					name);
		}
	}

	public void showAllStudents() {
		for (Student s : studentList) {
			System.out.println(s);
		}
	}

	public void removeStudent(int id) {
		try {
			studentList.remove(id);
			rateList.remove(id);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Wrong Id");
		}
	}

	public void sortGroupByName() {

	}

	public void sortGroupByRateDesc() {
		Student temp;
		T tmp;
		for (int i = 0; i < rateList.size(); i++) {
			for (int j = 1; j < rateList.size(); j++) {

				if (rateList.get(j).doubleValue() > rateList.get(j - 1).doubleValue()) {
					tmp = rateList.get(j);
					rateList.set(j, rateList.get(j - 1));
					rateList.set(j - 1, tmp);
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j - 1));
					studentList.set(j - 1, temp);
				}
			}
		}
		for (int i = 0; i < rateList.size(); i++) {
			System.out.println(
					studentList.get(i).getFirstName() + " " + studentList.get(i).getSurName() + " " + rateList.get(i));
		}
	}

	public void sortGroupByRateAsc() {
		Student temp;
		T tmp;
		for (int i = 0; i < rateList.size(); i++) {
			for (int j = 1; j < rateList.size(); j++) {

				if (rateList.get(j).doubleValue() < rateList.get(j - 1).doubleValue()) {
					tmp = rateList.get(j);
					rateList.set(j, rateList.get(j - 1));
					rateList.set(j - 1, tmp);
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j - 1));
					studentList.set(j - 1, temp);
				}
			}
		}
		for (int i = 0; i < rateList.size(); i++) {
			System.out.println(
					studentList.get(i).getFirstName() + " " + studentList.get(i).getSurName() + " " + rateList.get(i));
		}
	}

	public boolean containStudent(Student existStudent) {
		if (studentList.contains(existStudent)) {
			return true;
		} else {
			return false;
		}
	}

	public T getRating(Student currentStudent) {
		int id;
		if (studentList.contains(currentStudent)) {
			id = studentList.indexOf(currentStudent);
			return rateList.get(id);
		} else {
			return null;
		}

	}

	@Override
	public String toString() {
		return "Discipline " + name;
	}

}
