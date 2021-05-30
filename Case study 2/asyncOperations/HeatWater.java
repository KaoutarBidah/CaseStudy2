package asyncOperations;

import defaultPackage.Water;

public class HeatWater implements Runnable {
	Water water;
	
	public HeatWater(Water water) {
		this.water = water;
	}
	
	public void run() {
		if(!water.warm) {
			water.warm = true;
			System.out.println("> Water heated");
		}
	}
}
