package se026with027;

import java.util.ArrayList;

import se026with027.Annotations.SubmarineAnnotation;
import se026with027.Annotations.SubmarineConstructAnnotation;
import se026with027.Annotations.SubmarineFieldAnnotation;
import se026with027.Annotations.SubmarineMethodAnnotation;


@SubmarineAnnotation(name = "SubMarineClass")
public class NuclearSubMarine {
	@SubmarineFieldAnnotation(name = "name")
	private String name;
	
	private NuclearEngine engine;
	private ArrayList<NuclearMissile> missiles;
	private double currentDepth;
	private boolean isWorking;

	@SubmarineConstructAnnotation(constructor = "defaultConstructor")
	public NuclearSubMarine(String name, double fuelTankSize, int missilesCount) {
		this.name = name;
		engine = new NuclearEngine(fuelTankSize);
		missiles = new ArrayList<NuclearMissile>();
		while (missilesCount != 0) {
			missiles.add(new NuclearMissile());
			missilesCount--;
		}
	}
	
	@SubmarineMethodAnnotation(name = "diveMethod")
	public void diveSubMarine(double depth) {
		if (isWorking) {
			engine.workOfEngine(0, depth);
		}
		else {
			System.out.println("SubMarine" + name + " isn't working now. Please launch engine first.");
		}
	}

	public void launchSubMarine() {
		engine.startEngine();
		isWorking = true;
	}

	public void moveSubMarine(double distance) {
		if (isWorking) {
			engine.workOfEngine(distance, currentDepth);
		} else {
			System.out.println("SubMarine" + name + " isn't working now. Please launch engine first.");
		}
	}

	public void openFire(String someObject) {
		try {
			missiles.get(missiles.size()-1).launchMissile();
			missiles.get(missiles.size()-1).destroyObject(someObject);
			missiles.remove(missiles.size()-1);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("You don't have any missiles.");
		}
	}

	public void showInformation(){
		System.out.printf("Submarine %s have %s missiles. Current Fuel = %s. FuelTankSize = %s\n", name, missiles.size(), engine.getRemainingFuel(), engine.getFuelTankSize());
	}
	
	public void stopSubMarine() {
		engine.stopEngine();
		isWorking = false;
	}

	public void tankUp(double addedMass) {
		if ((engine.getRemainingFuel() + addedMass) <= engine.getFuelTankSize()) {
			engine.setRemainingFuel(addedMass);
		} else {
			System.out.println("You can't add fuel more than fuelTankSize. Current Fuel is = "
					+ engine.getRemainingFuel() + ". FuelTankSize = " + engine.getFuelTankSize());
		}
	}

	private class NuclearEngine {
		private double remainingFuel;
		private double fuelTankSize;

		public NuclearEngine(double fuelTankSize) {
			this.fuelTankSize = fuelTankSize;
			remainingFuel = fuelTankSize;
		}

		public double getFuelTankSize() {
			return fuelTankSize;
		}

		public double getRemainingFuel() {
			return remainingFuel;
		}

		public void setRemainingFuel(double addedFuel) {
			remainingFuel += addedFuel;
		}

		public void startEngine() {
			System.out.println("Engine is started");
		}

		public void stopEngine() {
			System.out.println("Engine is stopped");
		}

		public void workOfEngine(double distance, double depth) {
			if ((remainingFuel - (distance * 0.17 + (currentDepth +depth) * 0.3)) >= 0) {
				currentDepth += depth;
				remainingFuel -= (distance * 0.17 + depth * 0.3);
				System.out.println("Remaining Fuel = " + remainingFuel);
			} else {
				System.out.println("Not enough fuel");
			}
		}

	}
	
	private class NuclearMissile {
		
		public void destroyObject(String s) {
			System.out.println(s + " is destroyed.");
		}

		public void launchMissile(){
			System.out.println("Missile is Launched");
		}
	}
}
