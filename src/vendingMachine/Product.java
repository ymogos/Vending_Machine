package vendingMachine;

public class Product {

	private int id;
	private String name;
	private int price;
	private int quantity;
	
	Product(int id,String name, int price, int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return this.id;
	}
	
	public int getPrice() {
		return this.price;
	}
	public int getQuantity() {
	   return this.quantity;
	}
	

}
