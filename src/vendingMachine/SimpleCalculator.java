package vendingMachine;

public class SimpleCalculator implements Calculator {

	@Override
	public int calculateTotal(CoinBundle enteredCoins) {
		return enteredCoins.getTotal();
	}

	@Override
	public CoinBundle calculateChange(int amountMoneyToReturn) {
		CoinBundle change = new CoinBundle(new int[4]);
		int remainingAmount = amountMoneyToReturn;
		
		
		
		change.number25CentsCoins = remainingAmount / 25;
		remainingAmount = remainingAmount % 25;
		
		change.number10CentsCoins = remainingAmount / 10;
		remainingAmount = remainingAmount % 10;
		
		change.number5CentsCoins = remainingAmount / 5;
		remainingAmount = remainingAmount % 5;
		
		change.number1CentsCoins = remainingAmount ;
		
		return change;
	}

}
