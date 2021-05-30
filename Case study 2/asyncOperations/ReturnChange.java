package asyncOperations;

public class ReturnChange implements Runnable {
	int price;
	int value;
	
	public ReturnChange(int value, int price) {
		this.price = price;
		this.value = value;
	}
	
	public void run() {
		if (value >= price) {
			System.out.println("> Returned change: " + (value - price));
		}else {
			System.out.println("> Returned change: " + value);
		}
	}
}
