
<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	function kToConfig($configurations ) {
		
		return $configurations[intval(substr('k1192121', 1)) % count($configurations)];
		//return $configurations[intval(substr('k1464928', 1)) % count($configurations)];
		
	}
	
	
?>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 2</title>
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

        <h4>PPA Assignment 2</h4>

		<h5>This coursework is designed to test the content from Topics 1, 2, 3 and 4.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					A person wishes to track their total calorie intake. This total is affected by two
					things: eating and walking. In addition, they have decided to follow a meal plan,
					offering a finite selection of meals which they can consume. 
				</i>
			</p>
			
        	<ol> 
				
				<li> Model this scenario based on the following requirements: </li>
				
				<ol>
				
					<li>
						Create a class to represent a <span class="code">Person</span>. A person has
						a total number of <span class="code">calories</span> which they have consumed,
						which starts with zero.
						(1 mark)
					</li>
					
					<li>
						Create a class to represent a <span class="code">Meal</span>, which consists
						of three things:
						a starter <span class="code">Dish</span>,
						a main <span class="code">Dish</span>
						and a dessert <span class="code">Dish</span>.
						Each <span class="code">Dish</span> has a number of
						<span class="code">calories</span>	it provides when
						consumed. (2 marks)
						<?php 
							//echo kToConfig($_POST, array("Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu")); 
						?>
					</li>
					
					<li>
						In the class <span class="code">Meal</span>, create a method
						<span class="code">calculateCalories</span> which returns the total calories in
						a meal.	(1 mark)
					</li>
					
					<li> 
						A person can <span class="code">eat</span> a meal, which results in the total
						calories being added to the person's total calories consumed. (1 mark)
					</li>
					
					<li>
						A person can burn calories by going for a <span class="code">walk</span>.
						Assume that this burns	calories at the rate of 1 calorie per
						<span class="code">minute</span>. (1 mark)
					</li>
				</ol>
				
				<li> Create a class <span class="code">CalorieTracker</span>, which can be compiled and run from the command line. Use this class to do the following (in order), using the functions of your <span class="code">Person</span> class: </li>
				
				<ol>
					
					<li>Create a person and print their total number of calories. (1 mark)</li>
					
					<li>
						Use the list of meals from the bottom of the page to complete the following tasks:
					</li>
					
					<ol>
					
						<li>Make the person eat the meal with the <i>lowest</i> calories. Then, print the total calories in this meal and print the new total calories of the person. (1 mark)</li>
						
						<li>Make the person eat the meal with <i>1000</i> calories. Then, print the total calories in this meal and print the new total calories of the person. (1 mark)</li>
						
						<li>Make the person eat the meal with the <i>highest</i> calories. Then, print the total calories in this meal and print the new total calories of the person. (1 mark)</li>
					</ol>
					
					<li>
						Finally, make your person go for a walk until their total calorie intake reaches
						2000. This will require your person to walk for a certain number of minutes. After
						the walk, print	this number of minutes. (1 mark)
					</li>
					
					<!--
					<li>
						Print the word ``
						<?php
							//echo kToConfig($_POST, array("Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu")); 
						?>''. (1 mark)</li>
					
					<li>
						Print the number greater than 
						<?php
							//echo kToConfig($_POST, array("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")); 
						?>. (1 mark)</li>
					-->
					
				
				
				
			</ol>
  
        </p>
		<!--
		<figure>
			<img src="images/menu.png" alt="The list of meals." width="250">
			<figcaption>Figure 1 - The list of meals.</figcaption>
		</figure> 
		
		<p style="font-style: italic;">Assignment brief by Dr. Asad Ali.</p>
		-->
		
		<h6>
		Meals List:
		</h6>
		<ul>
			<li><b>Omelette Breakfast</b></li>
			<ul>
				<li>
					<b>Starter:</b> Toast [<?php echo kToConfig(array("140", "100", "250", "200", "250", "350", "90", "130", "110", "150"));?> calories]
				</li>
				<li>
					<b>Main:</b> Omelette [<?php echo kToConfig(array("300", "500", "650", "600", "500", "715", "250", "365", "425", "535"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Banana [<?php echo kToConfig(array("120",	"90",	"100",	"130",	"115",	"125",	"95",	"110",	"140",	"150"));?> calories]
				</li>
			</ul>
			
			<li><b>Pancake Breakfast</b></li>
			<ul>
				<li>
					<b>Starter:</b> Fruit Yoghurt [<?php echo kToConfig(array("90", "80", "120", "100", "180", "170", "160", "60", "150", "110"));?> calories]
				</li>
				<li>
					<b>Main:</b> Pancakes [<?php echo kToConfig(array("400", "350", "650", "500", "750", "685", "705", "300", "800", "480"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Strawberries [<?php echo kToConfig(array("100",	"80", "120", "60", "90", "135", "135", "105", "170", "100"));?> calories]
				</li>
			</ul>
			<li><b>Halloumi Lunch</b></li>
			<ul>
				<li>
					<b>Starter:</b> Tomato Soup [<?php echo kToConfig(array("60", "35", "150", "40", "70", "120", "75", "130", "110", "100"));?> calories]
				</li>
				<li>
					<b>Main:</b> Halloumi Wrap [<?php echo kToConfig(array("560", "450", "720", "250", "445", "510", "430", "780", "630", "610"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Baklava [<?php echo kToConfig(array("170",	"130", "250", "150", "250", "370", "175", "350", "220", "200"));?> calories]
				</li>
			</ul>
			<li><b>Pie Lunch</b></li>
			<ul>
				<li>
					<b>Starter:</b> Potato Gratin [<?php echo kToConfig(array("320", "400", "170", "220", "280", "285", "330", "180", "250", "240"));?> calories]
				</li>
				<li>
					<b>Main:</b> Pie [<?php echo kToConfig(array("570", "460", "280", "335", "600", "480", "750", "290", "600", "560"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Gelato [<?php echo kToConfig(array("110", "250", "115", "220", "120", "150", "220", "160", "305", "200"));?> calories]
				</li>
			</ul>
			<li><b>Chow Mein Dinner</b></li>
			<ul>
				<li>
					<b>Starter:</b> Samosa [<?php echo kToConfig(array("320", "300", "250", "450", "150", "350", "330", "260", "222", "211"));?> calories]
				</li>
				<li>
					<b>Main:</b> Chow Mein [<?php echo kToConfig(array("630", "600", "450", "680", "400", "450", "555", "605", "515", "470"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Doriyaki [<?php echo kToConfig(array("110", "100", "120", "220", "105", "145", "190", "135", "175", "198"));?> calories]
				</li>
			</ul>
			<li><b>Pizza Dinner</b></li>
			<ul>
				<li>
					<b>Starter:</b> Potato Wedges [<?php echo kToConfig(array("310", "105", "180", "240", "140", "100", "200", "360", "210", "185"));?> calories]
				</li>
				<li>
					<b>Main:</b> Pizza [<?php echo kToConfig(array("650", "350", "450", "500", "350", "350", "600", "640", "455", "709"));?> calories]
				</li>
				<li>
					<b>Dessert:</b> Cheesecake [<?php echo kToConfig(array("210", "400", "255", "260", "250", "220", "125", "200", "335", "240"));?> calories]
				</li>
			</ul>
		</ul>
		
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, submit your assignment using the link marked `Assignment 2: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 2: Documentation Submission' on KEATS.</p>
		
		<p>Students who do not submit documentation along with their code, or vice-versa, will receive a mark of zero.</p>
			
		<p>Any submitted code or documentation that is found to be unduly similar to the code or documentation submitted by any other student(s), will result in a penalty for those involved.</p> 
		
		<p>Provisional marks for your code will be released on KEATS within one week of submission. Final assignment grades will be submitted to the exam board at the end of the semester, and will take into consideration the quality of your documentation and the quality of the comments written into your code directly.</p> 
		
		<p>For all other queries, see the Support section on KEATS, specifically the document marked `Introduction'.</p>
  
      </div>
  
    </div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
