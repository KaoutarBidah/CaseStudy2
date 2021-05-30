package asyncOperations;

import defaultPackage.Water;

public class FillWater implements Runnable {
	Water water;
	
	public FillWater(Water water) {
		this.water = water;
	}
	
	public void run() {
		water.warm = false;
		System.out.println("> Water filled");
	}
}
