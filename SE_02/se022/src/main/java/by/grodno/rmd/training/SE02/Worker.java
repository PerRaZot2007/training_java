package by.grodno.rmd.training.SE02;

import java.util.ArrayList;

public class Worker {
	private String firstName;
	private String surName;
	private ArrayList<Stationery> stationeryList;
	private double overallPrice;

	public Worker(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
		this.stationeryList = new ArrayList<Stationery>();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void addStationery(Stationery stat) {
		stationeryList.add(stat);
	}

	public Stationery getStationery(int id) {
		try {
			return stationeryList.get(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Wrong stationery-ID");
		}
		return null;
	}

	public void removeStationery(int id) {
		try {
			System.out.println(stationeryList.get(id).getType() + " was removed.");
			stationeryList.remove(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Nothing to remove. Stationery list for " + firstName + " " + surName + " contains only "
					+ stationeryList.size() + " item(s).");
		}
	}

	public void showAllStationerys() {
		if (!stationeryList.isEmpty()) {
			for (Stationery s : stationeryList) {
				System.out.println(s.toString());
			}
		} else {
			System.err.println("Nothing to show");
		}
	}

	public double getOverallPrice() {
		for (Stationery s : stationeryList) {
			overallPrice += s.getPrice();
		}
		return overallPrice;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getSurName();
	}

}
