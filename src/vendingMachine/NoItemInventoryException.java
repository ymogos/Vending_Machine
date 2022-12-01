package vendingMachine;

public class NoItemInventoryException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NoItemInventoryException(String message) {
		super(message);
	}
}