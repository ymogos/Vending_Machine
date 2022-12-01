package vendingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTesting {

	@Test
	void calculateTotal() {
		SimpleCalculator cal = new SimpleCalculator();
		int[] enteredCoins = {10,15,20,25};
		int total = cal.calculateTotal(new CoinBundle(enteredCoins));
		assertEquals(total,90);
	}
	@Test
	void calculateChange() {
		SimpleCalculator cal = new SimpleCalculator();
		CoinBundle change=cal.calculateChange(53);
		assertEquals(change.number25CentsCoins,2);
		assertEquals(change.number1CentsCoins,3);
	}

}
