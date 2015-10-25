package by.grodno.rmd.training.atempt101;

import static by.grodno.rmd.training.atempt101.statics.Group.*;

public class MainClass {

	public static void main(String[] args) {
		
		Student rmd = new Student("Maksim", "Rakickij");
		Student filas =  new Student("Filip", "Zotov");
		
		group1.addStudent(rmd, 10d);
		group2.addStudent(rmd, 3);
		group1.addStudent(filas, 3d);
		
		rmd.showAllDisciplines();
		
		group1.sortGroupByRateDesc();
		group1.sortGroupByRateAsc();
		group2.removeStudent(0);
		
		rmd.showAllDisciplines();
	}

}
