package by.grodno.rmd.training.SE03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import by.grodno.rmd.training.SE03.OtherStationery.otherTypes;

public class NewbiePack {

	private ArrayList<Stationery> newbieStationeries;
	private boolean completeCheck;
	private int count;

	public NewbiePack() {
		this.newbieStationeries = new ArrayList<Stationery>();
	}

	public void addStationery(Stationery stat) {
		if (newbieStationeries.size() < 7) {
			newbieStationeries.add(stat);
		} else {
			System.err.println("NewbiePack is full");
		}

	}

	public Stationery getStationery(int id) {
		try {
			return newbieStationeries.get(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Wrong stationery-ID");
		}
		return null;
	}

	public void removeStationery(int id) {
		try {
			System.out.println(newbieStationeries.get(id).getType() + " was removed.");
			newbieStationeries.remove(id);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Nothing to remove or wrong id.");
		}
	}

	public void showAllStationeries() {
		if (!newbieStationeries.isEmpty()) {
			for (Stationery s : newbieStationeries) {
				System.out.println(s.toString());
			}
		} else {
			System.err.println("Nothing to show");
		}
	}

	private boolean checkNewbiePack() {
		if (havePen() && havePencil() && havePaper() && haveRuler()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean havePen() {
		completeCheck = false;
		count = 0;
		while (!completeCheck && count < newbieStationeries.size()) {
			if (newbieStationeries.get(count) instanceof Pen) {
				completeCheck = true;
			}
			count++;
		}
		return completeCheck;
	}

	private boolean havePencil() {
		completeCheck = false;
		count = 0;
		while (!completeCheck && count < newbieStationeries.size()) {
			if (newbieStationeries.get(count) instanceof Pencil) {
				completeCheck = true;
			}
			count++;
		}
		return completeCheck;
	}

	private boolean havePaper() {
		completeCheck = false;
		count = 0;
		while (!completeCheck && count < newbieStationeries.size()) {
			if (newbieStationeries.get(count) instanceof Paper) {
				completeCheck = true;
			}
			count++;
		}
		return completeCheck;
	}

	private boolean haveRuler() {
		completeCheck = false;
		count = 0;
		while (!completeCheck && count < newbieStationeries.size()) {
			if (newbieStationeries.get(count) instanceof Ruler) {
				completeCheck = true;
			}
			count++;
		}
		return completeCheck;
	}

	public void createNewbiePack() {
		Scanner ioS = new Scanner(System.in);
		boolean end = false;
		System.out.print("Create your newbiePack. Newbie pack must contain Pen, Paper, Pencil, Ruler."
				+ " Newbie pack may contain only 7 items.");
		do {
			System.out.println("Do something: \n1. Add Item;\n2. Remove Item;\n3. Show Item(s)"
					+ "\n4. Finish work with newbiePack");
			switch (ioS.nextInt()) {
			case 1: {
				System.out.println("What stationery you wont to add?: \n1. Paper;\n2. Pen;\n3. Pencil" + "\n4. Ruler"
						+ "\n5. Scissors" + "\n6. OtherStationery");
				switch (ioS.nextInt()) {

				case 1: {
					System.out.println("Enter price of stationery");
					addStationery(new Paper(ioS.nextInt()));
					break;
				}
				case 2: {
					System.out.println("Enter price of stationery");
					addStationery(new Pen(ioS.nextInt()));
					break;
				}
				case 3: {
					System.out.println("Enter price of stationery");
					addStationery(new Pencil(ioS.nextInt()));
					break;
				}
				case 4: {
					System.out.println("Enter price of stationery");
					addStationery(new Ruler(20, ioS.nextInt()));
					break;
				}
				case 5: {
					System.out.println("Enter price of stationery");
					addStationery(new Scissors(ioS.nextInt()));
					break;
				}
				case 6: {
					System.out.println("Enter price of stationery");
					addStationery(new OtherStationery(otherTypes.ERASER, ioS.nextInt()));
					break;
				}
				default: {
					System.err.println("Wrong number");
					break;
				}
				}
				break;
			}
			case 2: {
				System.out.print("Enter id");
				removeStationery(ioS.nextInt());
				break;
			}
			case 3: {
				showAllStationeries();
				break;
			}
			case 4: {
				if (checkNewbiePack()) {
					end = true;
					System.out.println("Well done. You create a newbiePack. This newbiePack contains: ");
					showAllStationeries();
				} else {
					System.err.println("NewbiePack isn't done. Newbie pack must contain Pen, Paper, Pencil, Ruler.");
				}
				break;
			}
			default: {
				System.err.println("You choose wrong operation!!!");
				break;
			}
			}
		}

		while (!end);
		ioS.close();
	}
	
	public void sortByPrice() {
		Comparator<Stationery> com = new Comparator<Stationery>(){
			@Override
			public int compare(Stationery s0, Stationery s1) {
				return s0.getPrice() - s1.getPrice();
			}			
		};
		newbieStationeries.sort(com);
	}
	
	public void sortByType() {
		Comparator<Stationery> com = new Comparator<Stationery>() {
			@Override
			public int compare(Stationery s0, Stationery s1) {
				return s0.getType().compareTo(s1.getType());
			}
		};
		newbieStationeries.sort(com);
	}
	
	public void sortByPriceandType() {
		Comparator<Stationery> com = new Comparator<Stationery>() {
			@Override
			public int compare(Stationery s0, Stationery s1) {
				if(s0.getType().compareTo(s1.getType()) == 0) {					
					return s0.getPrice() - s1.getPrice();
				}
				else {
					return s0.getType().compareTo(s1.getType());
				}
			}			
		};
		newbieStationeries.sort(com);
	}
}
