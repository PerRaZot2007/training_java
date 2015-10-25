package by.grodno.rmd.training.atempt101.statics;

import by.grodno.rmd.training.atempt101.Discipline;
import by.grodno.rmd.training.atempt101.Discipline.disciplineTypes;

public class Group {
	public static Discipline<Double> group1 = new Discipline<Double>(disciplineTypes.ALGEBRA);
	public static Discipline<Integer> group2 = new Discipline<Integer>(disciplineTypes.ENGLISH);
	public static Discipline<Double> group3 = new Discipline<Double>(disciplineTypes.FUNCTIONAL_ANALYSIS);
	public static Discipline<Double> group4 = new Discipline<Double>(disciplineTypes.GEOMETRY);
	public static Discipline<Float> group5 = new Discipline<Float>(disciplineTypes.INFORMATHIC);
	public static Discipline<Double> group6 = new Discipline<Double>(disciplineTypes.MATHEMATIC_ANALYSIS);
	public static Discipline<Double> group7 = new Discipline<Double>(disciplineTypes.OPTIMIZATION_MEHTODS);
	public static Discipline<Integer> group8 = new Discipline<Integer>(disciplineTypes.PSYHOLOGY);

	public static Discipline<? extends Number>[] allGroups = new Discipline[8];

	static {
		allGroups[0] = group1;
		allGroups[1] = group2;
		allGroups[2] = group3;
		allGroups[3] = group4;
		allGroups[4] = group5;
		allGroups[5] = group6;
		allGroups[6] = group7;
		allGroups[7] = group8;
	}

}
