package assignment2;

public class CalorieTracker {
	
	public static void main(String[] args){
		/*
		 * Question 2.1
		 */
		Person person = new Person();
		System.out.println(person.getCalories());
        
		/*
		 * Question 2.2.1
		 */
		Dish butteredToast= new Dish();
        butteredToast.setCalories(150);
         
        Dish omelette= new Dish();
        omelette.setCalories(500);
         
        Dish banana= new Dish();
        banana.setCalories(50);
        
        Meal omeletteBreakfast= new Meal();
        omeletteBreakfast.setStarter(butteredToast);
        omeletteBreakfast.setMain(omelette);
        omeletteBreakfast.setDessert(banana);
        
        person.eat(omeletteBreakfast);
        System.out.println(person.getCalories());
        
        /*
		 * Question 2.2.2
		 */
      
        Dish potatoGratin= new Dish();
        potatoGratin.setCalories(320);
         
        Dish pie= new Dish();
        pie.setCalories(570);
         
        Dish gelato= new Dish();
        gelato.setCalories(110);
         
        Meal pieLunch= new Meal();
        pieLunch.setStarter(potatoGratin);
        pieLunch.setMain(pie);
        pieLunch.setDessert(gelato);
         
        person.eat(pieLunch);
        System.out.println(person.getCalories());
        
        /*
		 * Question 2.2.3
		 */
         
        Dish potatoWedges= new Dish();
        potatoWedges.setCalories(150);
         
        Dish pizza= new Dish();
        pizza.setCalories(650);
         
        Dish cheesecake= new Dish();
        cheesecake.setCalories(210);
         
        Meal pizzaDinner= new Meal();
        pizzaDinner.setStarter(potatoWedges);
        pizzaDinner.setMain(pizza);
        pizzaDinner.setDessert(cheesecake);
        
        person.eat(pizzaDinner);
        System.out.println(person.getCalories());
        
        /*
         * Question 2.3
         * 
         */
        int minutes = 710;
        person.walk(minutes);
        System.out.println(minutes);
	}

}
