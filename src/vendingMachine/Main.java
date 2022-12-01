/*a.Vending machine displays a welcome message.
 * It asks the user to select a product.
 * Machine ask the user to enter coins
 * Machine calculates amount enter by user
 * It calculates the change
 * It calculates minimum number of coins
 * It displays message with the change
 */

package vendingMachine;
import java.io.IOException;
import java.util.Scanner;


public class Main {
public static void main(String[] args) throws IOException, InsufficientFundsException, NoItemInventoryException  {

	Scanner sc = new Scanner(System.in);

	
	VendingMachine vendingMachine = new TextBasedVendingMachine();
	vendingMachine.loadProducts();
	char choice='n';
	do {
	
	try {
		vendingMachine.displayProducts();
	String selectedProduct = sc.nextLine();
	int selectProduct = Integer.parseInt(selectedProduct);
	vendingMachine.selectProduct(selectProduct);
	Product pro = vendingMachine.getProdct(selectProduct);
	if(pro.getQuantity()<=0)
	   throw new NoItemInventoryException("item is out of stock");
	System.out.println("You selected Product "+pro.getName() + " and the cost is "+ pro.getPrice());
	
		vendingMachine.displayEnterCoinMessage();
		String userEnteredCoins = sc.nextLine();
		
		int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
	vendingMachine.enterCoins(enteredCoins);
	vendingMachine.displayChangeMessage();
	System.out.println("do you want to continue y/n?");
    choice = sc.next().charAt(0);
	sc.nextLine();
	}catch(NoItemInventoryException e) {
		System.out.println("                                                 ");
		System.out.println(e.getMessage());
	}catch(InsufficientFundsException e) {
		System.out.println("                                                 ");
		System.out.println(e.getMessage());
		System.out.println("do you want to try again Y/N?");
	    choice = sc.next().charAt(0);
	}
	
	}while(choice=='y' || choice=='Y');
	vendingMachine.writeToFile();
}
}
