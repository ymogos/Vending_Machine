package vendingMachine;

public interface Calculator {
	int calculateTotal(CoinBundle enteredCoins);
	CoinBundle calculateChange(int amountMoneyToReturn);

}
