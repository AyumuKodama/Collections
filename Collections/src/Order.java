
public class Order {
	private String menuItem;
	private String customerName;
	private int prepTime;
	
	public Order(String item, String name, int time) {
		menuItem = item;
		customerName = name;
		prepTime = time;
	}
	
	public String item() {
		return menuItem;
	}
	
	public String name() {
		return customerName;
	}
	
	public int time() {
		return prepTime;
	}
}
