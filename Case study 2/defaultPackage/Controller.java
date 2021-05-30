package defaultPackage;

import asyncOperations.AddAdditive;
import asyncOperations.FillCoffee;
import asyncOperations.FillWater;
import asyncOperations.HeatWater;

public class Controller {
	Hardware hd;
	
	public Controller(Hardware hd) {
		this.hd = hd;
	}
	
	public Coffee makeCoffee(Additive add) throws InterruptedException {
		hd.fillWater = new FillWater(hd.water);
		hd.add = new AddAdditive(add);
		hd.fillCoffee = new FillCoffee();
		
		Thread fillW = new Thread(hd.fillWater);
		Thread fillC = new Thread(hd.fillCoffee);
		Thread addA = new Thread(hd.add);
		
		fillC.run();
		fillW.run();
		addA.run();
		
		return new Coffee(true);
	}
	
	public Tea makeTea() throws InterruptedException {
		hd.fillWater = new FillWater(hd.water);
		
		Thread fillW = new Thread(hd.fillWater);
		
		fillW.run();
		
		return new Tea(true);
	}
	
	public void heatWater() {
		hd.heatWater = new HeatWater(hd.water);
		
		Thread heat = new Thread(hd.heatWater);
		
		heat.run();
	}
}
