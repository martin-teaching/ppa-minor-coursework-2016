package assignment8;
import java.util.ArrayList;

public class Customer {
	//Q1.4 - the 'name' field required for Q1.4.
	//A 'getName' field will be included for it, further down.
	private String name;
	
	//Q1.4.1 - the shoppingBasket collection.
	//An add, remove and search method will be provided for it,
	//further down.
	private ArrayList<Product> shoppingBasket;
	
	//Q1.4.2 - the ownedProducts collection.
	//An add method will be provided for it, further down.
	private ArrayList<Product> ownedProducts;
	
	//Q1.4.3 - the purse collection.
	//An add and remove method will be provided for it, further down.
	private ArrayList<GoldCoin> purse;

	//Q1.4 - the required constructor.
	public Customer(String name) {
		
		this.name = name;
		this.shoppingBasket = new ArrayList<Product>();
		this.ownedProducts = new ArrayList<Product>();
		this.purse = new ArrayList<GoldCoin>();
	}
	
	//Q1.4.1 - the add method for shoppingBasket
	//One of three methods for this collection
	public void addToShoppingBasket(Product product) {
		shoppingBasket.add(product);
	}
	
	//Q1.4.1 - the remove method for shoppingBasket
	//Two of three methods for this collection
	public boolean removeFromShoppingList(Product p) {
		return shoppingBasket.remove(p);
	}
	
	//Q1.4.1 - the search method for shoppingBasket
	//Three of three methods for this collection
	public Product searchShoppingList(String name) {
		for (Product p : shoppingBasket) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	//Q1.4.2 - the add method for ownedProducts
	//One of one methods for this collection
	public void addOwnedProduct(Product product){
		ownedProducts.add(product);
	}
	
	//Q1.4.3 - the add method for purse
	//One of one methods for this collection
	public void addCoin(GoldCoin coin) {
		purse.add(coin);
	}
	
	//Q1.7 - the purchaseProducts method.
	public boolean purchaseProducts(Shop shop) {
		//Q1.7.1 - first part which calculates the total price
		//of the basket.
		int totalCost = 0;
		for (Product p : shoppingBasket) {
			totalCost += p.getPrice();
		}
		
		//Q1.7.1 - second part which only continues with the purchase
		//if the customer has enough coins in their purse.
		if (purse.size() < totalCost) {
			return false;
		} else {
			
			//Q1.7.2 transfer the required amount of coins to shop
			for (int i = 0; i < totalCost; i++) {
				shop.addCoin(purse.remove(purse.size() - 1));
			}
			
			//Q1.7.3 - first part is to transfer the products from
			// shopping basket to owned products.
			ownedProducts.addAll(shoppingBasket);
			
			//Q1.7.3 - second part is to empty the shopping basket
			shoppingBasket.clear();
			
			//Q1.7.4 update the total spend of this customer and
			//return true
			shop.updateTotalSpend(this, totalCost);
			return true;
			
		}
	}

	//This method is not specified in the brief, but it is assumed that
	//students will know it is needed.
	public ArrayList<GoldCoin> getPurse() {
		return purse;
	}
	
	//This method is not specified in the brief, but it is assumed that
	//students will know it is needed.
	public String getName() {
		return name;
	}
	
	//This method is not specified in the brief, but it is assumed that
	//students will know it is needed.
	public ArrayList<Product> getShoppingBasket() {
		return shoppingBasket;
	}

	

}
