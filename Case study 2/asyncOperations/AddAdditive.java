package asyncOperations;

import defaultPackage.Additive;

public class AddAdditive implements Runnable {
	Additive add;
	
	public AddAdditive(Additive add) {
		this.add = add;
	}
	
	public void run() {
		System.out.println("> Additives added: \n"
				+ add.sugar + " sugar cube(s)");
		if(add.milk) {
			System.out.println("Milk");	
		}
	}
}
