package vendingMachine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TextBasedVendingMachine implements VendingMachine {

	private int selectedProduct;
	private CoinBundle change;
	private ArrayList<Product> products= new ArrayList<Product>();
	@Override
	public void displayProducts() {
		System.out.println("===========================================");
		System.out.println("      WELCOME TO THE VENDING MACHINE      ");
		System.out.println("===========================================");
		
		System.out.println("          PRODUCTS AVAILABLE         ");
		System.out.println("                                            ");
		
		for(Product product: products) {
			
			System.out.println("     " + product.getId()+" "+product.getName()+" - Price:"+product.getPrice()+"  "+"Quantity: "+product.getQuantity());
		
		}
		System.out.println("                                                 ");
		System.out.println("Please select your product: ");
		
	}
	
	@Override
	public void selectProduct(int product) {
		this.selectedProduct = product;
		
	}
	
	@Override
	public void displayEnterCoinMessage() {
		System.out.println("                                                                               ");
		System.out.println("Please enter coins as follows: ");
		System.out.println("num of 1 cents coins,num of 5 cents coins,num of 10cents coins, num of 25cents coins");
		System.out.println("                                                                               ");
		System.out.println("Example: if you would like to enter 2 ten cents coins: 0,0,2,0,");
		System.out.println("Please enter coins:");
		
	}
	
	public  Product getProdct(int productSelected) {
		for(Product product: products) {
			if(productSelected == product.getId()) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void enterCoins(int... coins) throws NoItemInventoryException, InsufficientFundsException {
	   Calculator calculator = new SimpleCalculator();
	   Product product = getProdct(this.selectedProduct);
	   if(product.getQuantity()<=0)
		   throw new NoItemInventoryException("item is out of stock");
	   product.setQuantity(product.getQuantity()-1);
	   int total = calculator.calculateTotal(new CoinBundle(coins));
	   if(total< product.getPrice())
		   throw new InsufficientFundsException("the coins inserted is not enough");
	   int changeAmount = total - product.getPrice();
	   this.change = calculator.calculateChange(changeAmount);
		
	}

	@Override
	public void displayChangeMessage() {
		System.out.println("                                                                ");
		System.out.println("Your change is: "+ change.getTotal()+"cents splitted as follows: ");
	
		System.out.println("   25 cents coins: "+ change.number25CentsCoins);
		System.out.println("   10 cents coins: "+ change.number10CentsCoins);
		System.out.println("   5 cents coins: "+ change.number5CentsCoins);
		System.out.println("   1 cents coins: "+ change.number1CentsCoins);
		
	}

	@Override
	public void loadProducts() throws IOException{
		
			try {
		    
			String fileName= "C:\\Users\\miyom\\Desktop\\Test\\VendingMachine\\src\\vendingMachine\\Stock.txt";
			File prodfile = new File(fileName);
			FileReader fr= new FileReader(prodfile);
			BufferedReader  br = new BufferedReader(fr);
			String lines = br.readLine();
			int id=0;
			while(lines!=null) {
				String [] linePerLine= lines.split(",");
				lines= br.readLine();
				id++;
				
				Product product = new Product(id,linePerLine[0],Integer.parseInt(linePerLine[1]),Integer.parseInt(linePerLine[2]));
			
				products.add(product);
			 }
			   
			}catch(FileNotFoundException e) {
			   e.printStackTrace();
			}
	}
	
public  void  writeToFile() throws IOException  {
		
		try {
			
			String fileName= "C:\\Users\\miyom\\Desktop\\Test\\VendingMachine\\src\\vendingMachine\\Stock.txt";
		File dvdfile = new File(fileName);
		FileWriter fw= new FileWriter(dvdfile);
		BufferedWriter  bw = new BufferedWriter(fw);
		
		
		for(Product pro: products) {
			
			String linePerPro= "";
			linePerPro = pro.getName()+","
			             + pro.getPrice()+","
					     + pro.getQuantity()+"\n";
			bw.append(linePerPro);
		}
		
		   bw.flush();
		   bw.close();
		   
		}catch(FileNotFoundException e) {
		   e.printStackTrace();
		}

	}



}
