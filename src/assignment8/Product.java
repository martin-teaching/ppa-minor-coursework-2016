package assignment8;
//Q1.2 - All of this is for Q1.2.
public class Product {
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}

	public String toString() {
		return "Product[name=" + name + ", " + "price=" + price + "]";
	}
}
