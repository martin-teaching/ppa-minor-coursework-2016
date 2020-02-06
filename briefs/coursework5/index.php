
<?php 
	
	if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	function kToConfig($configurations ) {
		
		return $configurations[intval(substr($_POST['ext_user_username'], 1)) % count($configurations)];
		//return $configurations[intval(substr("k1464928", 1)) % count($configurations)];
		//return "Hello";
	}
	
	
?>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 5</title>
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

        <h4>PPA Assignment 5</h4>

		<h5>This coursework is designed to test the content from Weeks 1, 2, 3, 4, and 5.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>The total marks available for this assignment are 12.</p>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					We would like to create a simple simulation of an aeroplane travelling to various destinations.
					An aeroplane may travel to a single destination, which will cover a certain distance. It may
					also travel to multiple destinations over the course of a single day. Moreover, it can repeat
					its daily journeys over a number of days. After the aeroplane travels a certain distance, 
					it is a requirement for it to be inspected for repairs, as a safety precation. This process
					takes 7 days, during which time the aeroplane cannot fly.
					
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
					<li>
						The location, of a destination or an aeroplane (at any point in time), is specified via
						<span class="code">Coordinates</span>. This has an <span class="code">x</span>, which is the
						value along the x-axis (on a map) of the location, and similarly a <span class="code">y</span>,
						for the y-axis. These are both whole numbers. (1 mark)
					</li>
					<li>
						A <span class="code">Destination</span> represents the town or city that an aeroplane can
						travel to. It has a <span class="code">name</span> and
						<span class="code">coordinates</span>. (1 mark)
					</li>
					<li>
						An <span class="code">Aeroplane</span> has:
						<ul>
						<li>
							A <span class="code">name</span>.
						</li>
						<li>
							A <span class="code">coordinates</span>.
						</li>
						<li>
							A <span class="code">speed</span>,
						which specifies how far the aeroplane can move in one hour in both the x-axis and
						the y-axis.
						</li>
						
						<li>
							The <span class="code">totalDistance</span>
						that it has travelled. For simplicity, we will assume that the distance travelled
						by the aeroplane is the sum of the adjustments made to its x coordinate plus the 
						adjustments made to its y coordinate, across all of the journeys it has undertaken.
						We will not consider the true geometric distance covered.
						</li> 
						
						<li>
							A <span class="code">repairDistance</span>, which is the distance that the areoplane can travel before it must
							be taken away for 7 days to undergo repairs.
						</li>
						 
						</ul>
						(1 mark)
					</li>
					
					
					<li>
						An <span class="code">Aeroplane</span> can take a <span class="code">singleFlight</span> 
						which will attempt to move the aeroplane towards a supplied <span class="code">destination</span>.
						This will also calculate and return the distance travelled in this single journey.
						The aeroplane moves towards its destination as follows:
						<ol>
							<li>
								The aeroplane keeps moving towards the destination, changing its position every hour,
								until its x coordinate matches 
								the x coordinate of the of the destination, and its y coordinate matches the
								y coordinate of the destination.
							</li>
							<li>
								The x coordinate of the aeroplane is adjusted as follows. It will increase
								or decrease, depending on whether it is lower or higher, respectively, than the
								x coordinate of the destination. The aeroplane should never travel
								beyond the destination. Therefore, when the distance left to travel is less than the aeroplane's
								<span class="code">speed</span>, the x coordinate is increased by only the distance left to
								travel. Otherwise, the x coordinate is increased by the <span class="code">speed</span> of
								the aeroplane.
							<li>
								The y coordinate of the aeroplane is adjusted in the same way as the x coordinate. Therefore, the
								aim is to adjust the aeroplane's y coordinate to match the destination's y coordinate. Again, ensure that
								the aeroplane never travels beyond the destination.
							</li>
							<li>
								The total distance that the aeroplane has travelled (across all of its journeys) must be updated
								with the distance of this single journey. The single journey distance must also be returned.
							</li>
						</ol>
						A visualisation of an example journey made by the aeroplane can be found <a href="Plane.pdf">here</a>.
						To maximise your marks for this question, you must calculate the distance travelled by the plane programmatically, rather than mathematically.
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
					Create a class <span class="code">FlightSimulation</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				
				<ol>
					<li>
						Create a <span class="code">Destination</span> and name the variable holding it <i>destination1</i>.
						Set its attributes as follows:
						<ul>
							<li>
								the <span class="code">name</span> as <i><?php echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); ?></i>
							</li>
							<li>
								the <span class="code">x</span> coordinate as <i><?php echo kToConfig(array("40", "50", "95", "25", "10", "60", "70", "100", "110", "90", "120")); ?></i>
							</li>
							<li>
								the <span class="code">y</span> coordinate as <i><?php echo kToConfig(array("30", "20", "130", "85", "35", "75", "80", "45", "135", "55", "150")); ?></i>
							</li>
						</ul>
						
						(1 mark)
					</li>
					
					<li>
						Create a <span class="code">Destination</span> and name the variable holding it <i>destination2</i>.
						Set its attributes as follows:
						<ul>
							<li>
								the <span class="code">name</span> as <i><?php echo kToConfig(array("Dubai","Manchester","Kuala Lumpur","Lahore","Doha","Stockholm","Marrakesh","Istanbul","Muscat","Cairo","Lisbon")); ?></i>
							</li>
							<li>
								the <span class="code">x</span> coordinate as <i><?php echo kToConfig(array("90","60","70","110","15","85","20","145","5","10","50")); ?></i>
							</li>
							<li>
								the <span class="code">y</span> coordinate as <i><?php echo kToConfig(array("80","25","55","115","45","95","40","120","30","65","100")); ?></i>
							</li>
						</ul>
						
						(1 mark)
					</li>
					
					<li>
						Create a <span class="code">Destination</span> and name the variable holding it <i>destination3</i>.
						Set its attributes as follows:
						<ul>
							<li>
								the <span class="code">name</span> as <i><?php echo kToConfig(array("Male","Brasalia","Athens","Melbourne","Tokyo","New","York","Dhaka","Zanzibar","Manila","Dublin")); ?></i>
							</li>
							<li>
								the <span class="code">x</span> coordinate as <i><?php echo kToConfig(array("120","135","65","145","150","130","10","35","105","5","40")); ?></i>
							</li>
							<li>
								the <span class="code">y</span> coordinate as <i><?php echo kToConfig(array("100","115","75","105","125","140","30","90","25","95","60")); ?></i>
							</li>
						</ul>
						
						(1 mark)
					</li>
					
					<li>
						Create an <span class="code">Aeroplane</span> and name the variable holding it <i>aeroplane</i>.
						Set its attributes as follows:
						<ul>
							<li>
								the <span class="code">name</span> as <i><?php echo kToConfig(array("Concorde","Boeing 707","Boeing 747","Mustang","Wright Flyer","Air Force One","Spitfire","Airbus","Spirit","Gulfstream","Falcon")); ?></i>
							</li>
							<li>
								the <span class="code">x</span> coordinate as <i><?php echo kToConfig(array("40", "50", "95", "25", "10", "60", "70", "100", "110", "90", "120")); ?></i>
							</li>
							<li>
								the <span class="code">y</span> coordinate as <i><?php echo kToConfig(array("30", "20", "130", "85", "35", "75", "80", "45", "135", "55", "150")); ?></i>
							</li>
							<li>
								the <span class="code">speed</span> as <i><?php echo kToConfig(array("5","8","11","14","17","20","23","9","12","10","16")); ?></i>
							</li>
							<li>
								the <span class="code">totalDistance</span> as <i>0</i>
							</li>
							<li>
								the <span class="code">repairDistance</span> as <i><?php echo kToConfig(array("3500","4000","2150","4250","2000","1000","4900","1600","2550","3100","5000")); ?></i>
							</li>
						</ul>
						
						(1 mark)
					</li>
					
					<li>
						Make your aeroplane simulate its journeys in a single day, by doing the following:
						<ol>
							<li>
								Print the name of your aeroplane and the journey start destination (which is <span class="code">destination1</span>) and 
								the journey end destination, which is <span class="code">destination2</span>. Make your aeroplane take a single flight to 
								<span class="code">destination2</span>. Then, print this single journey's distance and the total distance travelled by your
								aeroplane. Finally, print your aeroplane's current location coordinates.
							</li>
							<li>
								Print the name of your aeroplane and the journey start destination (which is now <span class="code">destination2</span>) and 
								the journey end destination, which is <span class="code">destination3</span>. Make your aeroplane take a single flight to 
								<span class="code">destination3</span>. Then, print this single journey's distance and the total distance travelled by your
								aeroplane. Finally, print your aeroplane's current location coordinates.
							</li>
							<li>
								Print the name of your aeroplane and the journey start destination (which is now <span class="code">destination3</span>) and 
								the journey end destination, which is <span class="code">destination2</span>. Make your aeroplane take a single flight to 
								<span class="code">destination2</span>. Then, print this single journey's distance and the total distance travelled by your
								aeroplane. Finally, print your aeroplane's current location coordinates.
							</li>
							<li>
								Print the name of your aeroplane and the journey start destination (which is now <span class="code">destination2</span>) and 
								the journey end destination, which is <span class="code">destination1</span>. Make your aeroplane take a single flight to 
								<span class="code">destination1</span>. Then, print this single journey's distance and the total distance travelled by your
								aeroplane. Finally, print your aeroplane's current location coordinates.
							</li>
						</ol>
						(1 mark)
					</li>
						
					<li>
						Now, repeat the aeroplane's daily schedule of four single flights (as specified in the previous question) over 120 days. Guidelines for this are as follows:
						<ol>
							<li>
								Print the current day's number. Then, print the total distance travelled by the aeroplane up until the start of the day.
							</li>
							<li>
								Now make your aeroplane complete it's daily schedule of four single flights. However, the daily schedule should only begin if the
								aeroplane has not travelled so far a total distance that it needs to be sent for repairs. When the aeroplane does need to go
								for repairs, it must not take any flights for 7 days and its total distance travelled is reset to 0.
							</li>
							<li>
								Once the 120 days have been completed, print out the number of times that the aeroplane had to undergo repairs.
							</li>
							
						</ol>
						(2 marks)
					</li>
					
			</ol>
  
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		
		<p>Once completed, submit your assignment using the link marked `Assignment 5: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 5: Documentation Submission' on KEATS.</p>
		
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
