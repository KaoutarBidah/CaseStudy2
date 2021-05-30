package defaultPackage;
import java.util.Scanner;

import asyncOperations.ReturnChange;

public class CoffeeMachine {
	
	static Water water = new Water();
	static Hardware hd = new Hardware(water);
	static Controller ct = new Controller(hd);
	
	public static void main(String[] args) {
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		
		Coffee coffee;
		Tea tea;
		
		int value = 0;
		int price = 0;
		int sugar = 0;
		Additive add;
		ReturnChange change;
		
		while(!choice.equals("turnoff")) {
			
			//Getting coins from client
			System.out.println("> Insert coins: ");
			choice = scanner.nextLine();
			try
			{
			   value = Integer.parseInt(choice);
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("> Invalid value!");
				continue;
			}
			
			//Choosing Beverage			
			System.out.println("> Choose your beverage:\n1.Coffee (10)\n2.Tea (5)");
			choice = scanner.nextLine();
			
			if (choice.equals("1")) { // Coffee
				//Returning Change
				price = 10;
				change = new ReturnChange(value,price);
				Thread thread = new Thread(change);
				thread.run();
				
				if(value >= 10) {
					
					//Choosing additives
					add = new Additive();
					
					System.out.println("> How many sugar cubes? : ");
					choice = scanner.nextLine();
					try
					{
					   sugar = Integer.parseInt(choice);
					}
					catch (NumberFormatException nfe)
					{
						System.out.println("> Invalid value!");
						continue;
					}
					add.sugar = sugar;
					
					System.out.println("1.Milk\n2.No milk");
					choice = scanner.nextLine();
						if(choice.equals("1")) {
							add.milk = true;
						}else if(choice.equals("2")){
							add.milk = false;
						}else {
							System.out.println("> Invalid choice!");
							continue;
						}
						
					//Making coffee
					try {
						coffee = ct.makeCoffee(add);
						if(coffee.coffeeOK) {
							System.out.println("> Here is you coffee!");
						}
						ct.heatWater();
					} catch (InterruptedException e) {
						System.out.println("> Couldn't make coffee!");
					}
					
				}else {
					System.out.println("> Coffee costs 10!");
				}
				
			}else if(choice.equals("2")) {// Tea
				//Returning Change
				price = 5;
				change = new ReturnChange(value,price);
				Thread thread = new Thread(change);
				thread.run();
				
				//Making tea
				try {
					tea = ct.makeTea();
					if(tea.teaOK) {
						System.out.println("> Here is your tea!");
					}
					ct.heatWater();
				} catch (InterruptedException e) {
					System.out.println("> Couldn't make tea!");
				}
				
			}else {
				System.out.println("> Invalid choice! Try again");
			}
		}
		scanner.close();
	}

}
