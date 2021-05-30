package defaultPackage;

import asyncOperations.AddAdditive;
import asyncOperations.FillCoffee;
import asyncOperations.FillWater;
import asyncOperations.HeatWater;

public class Hardware {
	Water water;
	FillCoffee fillCoffee;
	HeatWater heatWater;
	FillWater fillWater;
	AddAdditive add;
	
	public Hardware(Water water) {
		this.water = water;
	}
	
}
