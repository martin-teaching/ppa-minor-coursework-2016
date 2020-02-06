
<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	//function kToConfig($configurations ) {
		
	//	return $configurations[intval(substr($_POST['ext_user_username'], 1)) % count($configurations)];
		//return $configurations[intval(substr("k1464928", 1)) % count($configurations)];
		//return "Hello";
	//}
	
	
?>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 8</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="https://fonts.googleapis.com/css?family=Fira+Sans" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">

</head>
<body>

  <!-- Primary Page Layout
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <div class="container">

    <div class="row">

      <div class="one-half column" style="margin-top: 5%">

        <h4>PPA Assignment 8</h4>

		<h5>This coursework is designed to test the content from Weeks 1-5 and 7-9.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>The total marks available for this assignment are 22.</p>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					After obtaining a fortune of gold coins from their treasure hunt, our pirate has now
					docked at a port and is headed into town
					to purchase products from a shop. Once inside
					the shop, the customer can view the products in stock at the shop, add products to their
					shopping basket or remove products from their shopping basket. Finally, they can purchase all the
					products in their shopping basket, which transfers the money to the shop and then transfers ownership of the
					products to the customer. 
					
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
					<li>
						All financial transactions use <span class="code">GoldCoin</span>s, specified
						in the previous coursework.
						(1 mark)
					</li>
					<li>
						A <span class="code">Product</span> has a <span class="code">name</span> and a 
						<span class="code">price</span>, indicating how many whole gold coins are required to
						be exchanged in order to purchase the product. When we create an instance of this class,
						we should be able to provide values to these fields. Furthermore, there should be a default
						String representation of objects of this class using standard conventions, e.g.,
						"ClassName"["field1name"="field1value", "field2name=field2value", ...repeat for all fields...]. 
						(1 mark)
					</li>
					<li>
						A <span class="code">Shop</span> has a <span class="code">name</span>,
						and a number of collections of elements,
						specified below, for which you must select the appropriate data structure.
						When we create an object of this class, we should be able to specify a value
						for the <span class="code">name</span>
						and the collections should be initialised.  The collections are as follows:
						
						<ol> <!--
							<li>
							<span class="code">allowedCustomerNames</span> which contains the 
							name of each of the customers allowed to enter the shop. The shop
							has a policy of not allowing duplicate names in this collection,
							and orders the collection alphabetically. In the shop, there is 
							the ability to <span class="code">addAllowedCustomerName</span> to
							this collection. Furthermore, there is the ability to 
							<span class="code">searchAllowed</span> which takes a supplied
							name and returns a result indicating whether a customer with
							that name was found in this collection.(2 marks)			
							</li> -->
							<li>
							<span class="code">products</span> which contains the 
							<span class="code">Product</span>s that are currently in stock and
							available for purchase. Duplicates are allowed in this collection, because
							the shop deals very few, but rare and high value, products.
							In the shop, there is the ability to <span class="code">addProduct</span>
							to this collection, using
							a supplied <span class="code">Product</span>. There is also the ability
							to <span class="code">removeProduct</span> from the collection, which takes a supplied
							<span class="code">Product</span>, removes it from the collection and returns
							a positive result if the product was succesfully removed. Finally, it is
							possible to <span class="code">searchProduct</span>, which takes a supplied
							product name and returns the <span class="code">Product</span> with that name in this collection.
							(2 marks)		
							</li>		
							<li>
							<span class="code">coinBox</span> which contains the 
							<span class="code">GoldCoin</span>s that are currently in the box of
							money stored at the shop. The shop prefers to index each coin in their coin box.
							A <span class="code">GoldCoin</span> can be
							deposited into the box via the ability <span class="code">addGoldCoin</span>.
							 (2 marks)
							</li>
						
							
							
						</ol>
					</li>
					<li>
						A <span class="code">Customer</span> is the entity that can browse the shop and buy products. 
						It has a <span class="code">name</span> and a number of collections, detailed below. You must
						identify the appropriate data structure to use for each collection.
						When we create an instance of this class, we should
						be able to pass a value for the name as well as initialise the following collections that are also
						attributes of this class:
						<ol>
							<li>
							<span class="code">shoppingBasket</span> which contains the 
							<span class="code">Product</span>s that the customer has selected as the ones
							they intend to purchase. A customer can <span class="code">addToShoppingBasket</span>,
							which takes a supplied <span class="code">Product</span> and adds it to this collection, or 
							<span class="code">removeFromShoppingBasket</span>, which also takes a supplied 
							<span class="code">Product</span> but removes it from this collection and then returns
							a positive result (or negative if the product was not found). Finally,
							a customer can <span class="code">searchShoppingBasket</span>, which takes a supplied
							name of a product and retrieves the product with that name from the shopping basket.  (2 marks)
							</li>
							<li>
							<span class="code">ownedProducts</span> which contains the 
							<span class="code">Product</span>s that the customer owns currently.
							A customer can <span class="code">addOwnedProduct</span>,
							which takes a supplied <span class="code">Product</span> and adds it to this collection.
							(2 marks)
							</li>
							<li>
							<span class="code">purse</span> which contains the 
							<span class="code">GoldCoin</span>s that the customer currently possesses.
							A customer can <span class="code">addCoin</span>,
							which takes a supplied <span class="code">GoldCoin</span> and adds it to this collection.
							(2 marks)
							</li>
						</ol>
					</li>
			<!--	<li>
						The shop has the ability to 
						<span class="code">checkEntry</span>, which takes a supplied <span class="code">Customer</span>
						and <span class="code">password</span>, and returns a positive reults only if the
						customer's name exists in the 
						(1 mark)
					</li>
			-->
					<li>
						The <span class="code">Shop</span> has one last collection:
						 <span class="code">customerTotalSpend</span> which associates the name
							of a customer with the total amount of gold coins that they have spent
							in the shop, over multiple transactions. The Shop has the ability
							to <span class="code">updateTotalSpend</span>, which takes a supplied
							<span class="code">Customer</span> and an amount of coins, then updates
							the total spend associated with that customer's name by adding on the
							supplied amount of coins.
							(2 marks)
					</li>
					<li>
						Lastly for the <span class="code">Shop</span>, ensure that it can be converted by default
						into a String representation, which presents the name of the shop and all the details of each
						product currently in stock.	(1 mark)			
					</li>
					<li>
						Lastly for the <span class="code">Customer</span>, it can <span class="code">purchaseProducts</span>,
						which takes a supplied <span class="code">Shop</span> and purchases the items in the current
						shopping basket. This returns either a positive or negative result to indicate whether
						the transaction went through successfully. This works as follows:
						<ol>
							<li>
								The total cost of the shopping basket is calculated. If this is <i>higher</i> than
								the amount of coins in the customer's <span class="code">purse</span>, then the purchase fails and a negative
								result is returned. Otherwise the purchase continues. 
							</li>
							<li>
								The required number of coins are transferred, one by one,
								from the customer's <span class="code">purse</span> to the shop's
								<span class="code">coinBox</span>. 
							</li>
							<li>
								The products in the shopping basket are transferred to the user's 
								<span class="code">ownedProducts</span> and then the shopping basket
								is emptied.
							</li>
							<li>
								The customer's total overall spend in the shop is then updated with the spend undertaken
								in this transaction. A positive result is then returned.
							</li>
						</ol>
						(2 marks)
					</li>
					
						
				</ol>
						<?php 
							//echo kToConfig($_POST, array("Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu")); 
						?>
					
					<!--
					<li>
						In the <span class="code">MarkScheme</span> class, create a method
						<span class="code">convertMarksToClassification</span>, which will convert a total number of mark obtained in an 
						<span class="code">ExamAttempt</span> into a degree grade classification, which is returned. 
						The guidelines for this method are as follows:
						<ol>
							<li>A total number of obtained mark that is greater than a provided <span class="code">firstBoundary</span>
							is awarded a (numerical) classification of 1.1</li>
							<li>A total number of obtained mark that is greater than a provided <span class="code">upperSecondBoundary</span>
							is awarded a (numerical) classification of 2.1</li>
							<li>A total number of obtained mark that is greater than a provided <span class="code">lowerSecondBoundary</span>
							is awarded a (numerical) classification of 2.2</li>
							<li>Any other number of mark is awarded a (numerical) classification of 0.0</li>
						</ol>
						(2 mark)
						
					</li>
					
					
					
					<li>
						In the class <span class="code">MarkScheme</span>, create a method <span class="code">markExamAttempt</span>, to which an
						<span class="code">ExamAttempt</span> is passed and which returns the total number of mark obtained for this ExamAttempt.
						Marking an <span class="code">ExamAttempt</span> records the mark awarded for each question, as well as the total mark 
						awarded for the entire <span class="code">ExamAttempt</span>. The guidelines for marking each question in an 
						<span class="code">ExamAttempt</span> are as follows:
						 <ol>
							<li>For question 1, the attempted answer the correct answer, in order to award 1 mark. Otherwise,
								a mark of 0 will be awarded for this question. (1 mark) </li>
							<li>
								For question 2, the attempted answer must match the correct precise value for question 2, in order to award
								two mark. Otherwise, the attempted answer must be between the range of the minimum and maximum acceptable
								values, in order to award 1 mark. Othwerwise, a mark of 0 will be awarded for this question.
								(2 mark).
							
							</li>
							<li>
								For question 3, the attempted answer must match the correct answer, in order to award 1 mark. Otherwise,
								a mark of 0 will be awarded for this question. (1 mark)
							</li>
							<li>
								For question 4, the selection for each option in the attempted answer must match the selection for each each
								option in the correct answer, in order to award 1 mark. Otherwise, a mark of 0 will be awarded for this question. (1 mark)
							</li>
							
						 </ol>
					</li>
				</ol>
				-->
				<li> 
					Create a class <span class="code">ShoppingTrip</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				
				<ol>
					<li>
						Create the following products, then print their details to the terminal:
						<ul>
						<li>
							Product 1:
								<ul>
									<li>
										the <span class="code">name</span> as <i>Diamond</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
									<li>
										the <span class="code">price</span> as <i>40</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
								</ul>
						</li>
						<li>
							Product 2:
								<ul>
									<li>
										the <span class="code">name</span> as <i>Crown Jewels</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
									<li>
										the <span class="code">price </span> as <i>100</i>
										<i><?php //echo kToConfig(array("40", "50", "95", "25", "10", "60", "70", "100", "110", "90", "120")); 
										?></i>
									</li>
								</ul>
						
						</li>
						<li>
							Product 3:
								<ul>
									<li>
										the <span class="code">name</span> as <i>Silver Locket</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
									<li>
										the <span class="code">price</span> as <i>60</i>
										<i><?php //echo kToConfig(array("40", "50", "95", "25", "10", "60", "70", "100", "110", "90", "120")); 
										?></i>
									</li>
								</ul>
						</li>
						</ul>
							(1 mark)
					</li>
				
					<li>
						Create a shop. Give it the name 'Hidden Hideaway' and put 125 gold coins in its coin box.
						Add the products to from the previous question to the shop's products. Print
						the shop's details to the terminal, including its name, the number of gold coins in 
						the coin box and its products. (1 mark)
					</li>
					<li>
						Create a customer, give them the name 'BlackBeard' and give them 100 gold coins. Print their details 
						to the terminal. 
						(1 mark)
					</li>
					
					<li>
						Create the main shopping visit using the following guidelines:
						<ul>
							<li>
								The first output should be an introductory message to the user (assuming the 
								user takes the role of the customer), welcoming	them to the shop.
							</li>
							<li>
								Next, repeatedly present the products in the shop, the shopping basket
								and the total number of coins in the customer's wallet to the user.
								The user should be asked for their input each time the code repeats.
								The code should stop repeating when the user enters 'exit'. 
							</li>
							<li>
								If the user enters 'add product', they should then be prompted to input
								the name of a product from the shops product list, which should then
								be added to their shopping basket. This product must also be removed
								from the shop's products.
							</li>
							<li>
								If the user enters 'remove product', they should be prompted to input the name
								of the product which they wish to remove from their shopping basket. The entered
								product should then be removed from their shopping basket and added back into the
								shop's products.
							</li>
							<li>
								If the user enters 'purchase', all the products in the shopping basket must be
								purchased.
							</li>
							
						</ul>
						
						(2 marks)
					</li>
					
			</ol>
  
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		
		<p>Once completed, submit your assignment using the link marked `Assignment 8: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 8: Documentation Submission' on KEATS.</p>
		
		<p>Students who do not submit documentation along with their code, or vice-versa, will receive a mark of zero.</p>
			
		<p>Any submitted code or documentation that is found to be unduly similar to the code or documentation submitted by any other student(s), will result in a penalty for those involved.</p> 
		
		<p>Provisional mark for your code will be released on KEATS within one week of submission. Final assignment grades will be submitted to the exam board at the end of the semester, and will take into consideration the quality of your documentation and the quality of the comments written into your code directly.</p> 
		
		<p>For all other queries, see the Support section on KEATS, specifically the document marked `Introduction'.</p>
  
      </div>
  
    </div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
