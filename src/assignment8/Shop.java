package assignment8;

import java.util.ArrayList;
import java.util.TreeMap;

public class Shop {
	
	//Q1.3 - The 'name' field is for Q1.3. 
	//A 'getName' method will be for Q1.3 also
	private String name;
	
	//Q1.3.1 - The 'products' field is for Q1.3.1.
	//An add, remove and search method for this will be for it Q1.3.1 too.
	private ArrayList<Product> products;
	
	//Q1.3.2 - The 'coinBox' field is for Q1.3.2.
	//An add method for this will be for it Q1.3.2 too.
	private ArrayList<GoldCoin> coinBox;
	
	/*
	 * Q1.5 - The following field is for Q1.5.
	 * Some methods further down will also be for it.
	 */
	private TreeMap<String, Integer> customerTotalSpend;
	
	//Q1.3 - Constructor required by the question
	public Shop(String name) {
		this.name = name;
		this.products = new ArrayList<Product>();
		this.coinBox = new ArrayList<GoldCoin>();
		this.customerTotalSpend = new TreeMap<String, Integer>();
	}
	
	/*
	 * Q1.3.1 - the add element method.
	 * One of three methods required for the collection
	 */
	public void addProduct(Product product) {
		products.add(product);
	}

	/*
	 * Q1.3.1 - the remove element method.
	 * Two of three methods required for the collection
	 */
	public boolean removeProduct(Product product) {
		return products.remove(product);
	}
	
	/*
	 * Q1.3.1 - the search element method.
	 * Three of three methods required for the collection
	 */
	public Product searchProduct(String name) {
		for (Product p : products) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}	
	
	//Q1.3.2 - the add element method for Q1.3.2. 
	//One of one method required for the collection.	
	public void addCoin(GoldCoin coin) {
		coinBox.add(coin);
	}
	
	//Q1.5 - the updateTotalSpend method. 
	//One of one method required for this collection.
	public void updateTotalSpend(Customer customer, int cost) {
		Integer previousAmount = customerTotalSpend.get(customer.getName());
		if(previousAmount == null){
			customerTotalSpend.put(customer.getName(), cost);
		}
		else{
			customerTotalSpend.put(customer.getName(), previousAmount + cost);
		}
	}
	
	//Q1.6 - the toString method for Shop.
	public String toString() {
		return "Shop: " + name + ". The following products are in stock:" + products;
	}

	//This method is not specified in the brief, but it is assumed that
	//students will know it is needed.
	public ArrayList<Product> getProducts() {
		return products;
	}

	//This method is also not specified in the brief, but again it is assumed
	//that students will know it is needed.
	public String getName() {
		return name;
	}
	
	public ArrayList<GoldCoin> getCoinBox(){
		return coinBox;
	}
	
}
