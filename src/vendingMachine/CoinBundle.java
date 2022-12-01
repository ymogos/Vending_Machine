package vendingMachine;

public class CoinBundle {

	public int number1CentsCoins;
	public int number5CentsCoins;
	public int number10CentsCoins;
	public int number25CentsCoins;
	
	
	public CoinBundle(int... enteredCoins) {
		this.number1CentsCoins = enteredCoins[0];
		this.number5CentsCoins = enteredCoins[1];
		this.number10CentsCoins = enteredCoins[2];
		this.number25CentsCoins = enteredCoins[3];
		
	}
	
	public int getTotal() {
		int total = 0;
		total = total + this.number1CentsCoins*1;
		total = total + this.number5CentsCoins*5;
		total = total + this.number10CentsCoins*10;
		total = total + this.number25CentsCoins*25;
		
		return total;
	}
}
