package vendingMachine;

import java.io.IOException;

public interface VendingMachine {
	void displayProducts();
	void selectProduct(int product);
	void displayEnterCoinMessage();
	void enterCoins(int... coins) throws NoItemInventoryException,InsufficientFundsException;
	void displayChangeMessage();
	void loadProducts() throws IOException;
	Product getProdct(int productSelected);
    void  writeToFile() throws IOException;
	
}


