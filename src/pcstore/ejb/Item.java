package pcstore.ejb;

public class Item {
	private int Id;
	private String Name;
	private double Price;
	private int Stock;
	private String Description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Item(int id, String name, double price, int stock, String description) {
		super();
		Id = id;
		Name = name;
		Price = price;
		Stock = stock;
		Description = description;
	}
	

}
