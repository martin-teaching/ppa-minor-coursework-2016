package assignment8;

import java.util.Scanner;

public class ShoppingTrip {

	public static void main(String[] args) {
		//Q2.1 - First part is to create the three products
		Product p1 = new Product("Diamond", 60);
		Product p2 = new Product("Crown Jewels", 40);
		Product p3 = new Product("Silver Locket", 100);
		
		//Q2.1 - Second part is to print the three product's details
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	
		//Q2.2  - first of four parts is to create the shop
		Shop shop = new Shop("Hidden Hideaway");
		
		//Q2.2 - second of  four parts is to add 125 coins into the shop's coinBox
		for(int i = 0; i < 125; i++){
			shop.addCoin(new GoldCoin());
		}
		
		//Q2.2 - third of four parts is to add the three declared products to the
		// shop's product list.
		shop.addProduct(p1);
		shop.addProduct(p2);
		shop.addProduct(p3);

		//Q2.2 - Fourth of four parts is to print the details of the shop
		System.out.println(shop + "coins in coinBox = " + shop.getCoinBox().size());
		
		//Q2.3 - First of three parts is to create the customer
		Customer customer = new Customer("Blackbeard");
		
		//Q2.3 - Second of three parts is to add coins to the customer's purse
		for (int i = 0; i < 100; i++) {
			customer.addCoin(new GoldCoin());
		}
		
		//Q2.3 - Third of three parts is to print the details of the customer
		System.out.println("Customer[name = " + customer.getName() + " , coins in purse = " + customer.getPurse().size() + "]");

		
		//Q2.4 - first of five parts is to welcome the user.
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("Hello " + customer.getName() + "! Welcome to " + shop.getName());
		System.out.println("Today, we have an exciting range of rare and mysterious products, please have a browse...");

		//Q2.4 - second of five parts is to keep presenting the entire products list, repeatedly until they enter
		// "exit"
		while (!in.equals("exit")) {
			
			System.out.println(shop);
			System.out.println("Your shopping basket contains: " + customer.getShoppingBasket());
			System.out.println("Your purse contains: " + customer.getPurse().size());
			System.out.println("Enter 'add product' add a product to your shopping basket. "
					+ "Or, enter 'remove product' to remove a product from your "
					+ "shopping list. Or, enter 'purchase' to buy all " + "the items in your shopping basket. "
					+ "Of course, you may leave the shop by entering 'exit'.");
			
			input = in.nextLine();
			
			//Q2.4 - more on second of five parts where we stop the loop when 'exit' is entered. 
			if (input.equalsIgnoreCase("exit")) {
				
				System.out.println("See you next time, goodbye!");
				in.close();
				break;
				
			}
			//Q2.4 - third part of five where we add a product to the shop's products.
			//We must search for the product in the shop before we can add it to the shopping basket.
			else if (input.equalsIgnoreCase("add product")) {
				
				System.out.println("Enter the name of the product you wish to add to the shopping basket");
				input = in.nextLine();
				Product p = shop.searchProduct(input);
				
				if (p != null) {
					
					System.out.println("Product Found! Added " + p.getName() + " to shopping basket.");
					customer.addToShoppingBasket(p);
					
				} else {
					
					System.out.println("Sorry, that product was not found. Please try again");
					
				}

			} 
			//Q2.4 - fourth part of five where we remove an element from the customer's shopping basket,
			// then add it back into the shop's products.
			//We must search for the product in the shopping basket before we can remove it from the
			// shopping basket.
			else if (input.equalsIgnoreCase("remove product")) {
				
				System.out.println("Enter the name of the product you wish to remove from the shopping basket");
				input = in.nextLine();
				Product p = customer.searchShoppingList(input);
				
				if (p != null) {
					
					System.out.println("Product Found! Removed " + p.getName() + " from shopping basket.");
					customer.removeFromShoppingList(p);
					shop.addProduct(p);
					
				} else {
					
					System.out.println("Sorry, that product was not found. Please try again");
					
				}

			} 
			//Q2.4 - five out of five parts, where the products in the shopping basket are bought.
			else if (input.equalsIgnoreCase("purchase")) {
				
				System.out.println("Buying products");
				
				if (customer.purchaseProducts(shop)) {
					
					System.out.println("purchase success!");
					//System.out.println("Your total spend at this shop is : " + shop.getTotalSpend(customer));
					
				} else {
					
					System.out.println("purchase failure... do you have enough coins in your purse?");
					
				}
			}
			else {
				
				System.out.println("Sorry, input not recognised. Please try again.");
			}

		}

	}
}
