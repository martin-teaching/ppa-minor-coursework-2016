
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
  <title>PPA Assignment 3</title>
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

        <h4>PPA Assignment 3</h4>

		<h5>This coursework is designed to test the content from Topics 1, 2, 3, 4 and 5.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					We would like to create a simple simulation of a car race around a race track.
					There is an average time, in seconds, that all cars take to complete a lap around the track.
					The total time each individual car takes to complete a single lap is affected
					by the attributes of the car and the conditions of the race track. During a race,
					we would like to know who the leader is at the end of each lap. At the end, we 
					would like to know the winner.
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements (note that you should use the <span class="code">int</span>
					data type for variables which store an amount of seconds):
				</li>
				
				<ol>
				
					<li>
						Create a class to represent a <span class="code">RaceTrack</span>.
						A race track has an <span class="code">averageLapTime</span>, given in seconds, which is the average time
						it takes for any car to complete one single lap around the track. A race track also has a flag
						<span class="code">isRaining</span>, indicating if it is currently raining. When we create an object of this
						class, we should be able to supply values to these attributes.
						(1 mark)
					</li>
					
					
					<li>
						Create a class to represent a <span class="code">Car</span>. When we create an object of this class,
						we should be able to supply values for the following attributes:
						<ol>
							<li>an <span class="code">id</span> number to identify the car,</li>
							<li>a <span class="code">fuel</span> level, given in integer units with a maximum of 100,</li>
							<li>a <span class="code">lowFuelBoost</span>, which is the amount of seconds in one lap that a car goes faster when it's fuel level is low,</li>
							<li>a <span class="code">highFuelSlowdown</span>, which is the amount of seconds in one lap that a car goes slower when it's fuel level is high,</li>
							<li>a <span class="code">fuelConsumptionPerLap</span>, given in integer units, to indicate how much fuel a car uses up per lap,
							<li>a <span class="code">pitStopTime</span>, which is the amount of seconds it takes for the car to complete a pit stop (to refuel the car),</li>
							<li>a <span class="code">rainSlowdown</span>, which is the amount of seconds that a car slows down in one lap when it is raining,
							<li>a <span class="code">totalTime</span>, which is the total amount of seconds the car has taken during an <i>entire</i> race, and which starts at zero.</li>
						</ol>
						(1 mark)
						<?php 
							//echo kToConfig($_POST, array("Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu")); 
						?>
					</li>
					
					
					<li>
						In the <span class="code">RaceTrack</span> class, create a method
						<span class="code">determineRaceLeader</span>, which determines and
						returns the car (out of the three cars) that is the leader of the race.
						(2 marks)
						
					</li>
					
					
					
					
					<li>
						In the class <span class="code">Car</span>, create a method <span class="code">completeLap</span>, which returns
						the total time, in seconds, that the car takes to complete one lap around a provided race track.
						This total lap time must be calculated using the following guidelines:
						 <ol>
							<li>The base time for one lap is the race track's average lap time. (1 mark) </li>
							<li>
								When the fuel level is above 50 units, the car is heavier and therefore, goes slower in this lap
								by the amount of seconds specified by <span class="code">highFuelSlowdown</span>. Otherwise, the car 
								goes faster in this lap by the amount of seconds specified by <span class="code">lowFuelBoost</span> 
								(1 mark).
							
							</li>
							<li>
								When it is raining, the car goes slower in this lap by the amount of seconds specified by <span class="code">rainSlowdown</span>. (1 mark)
							</li>
							<li>
								At the end of a lap, the car uses up the amount of fuel given by <span class="code">fuelConsumptionPerLap</span>. (1 mark)
							</li>
							<li>
								The car will need to take a pit stop when the fuel level drops below the amount of fuel that the car requires to complete one lap.
								When the car takes a pit stop, this makes the car go slower in this lap by the amount of seconds specified in
								<span class="code">pitStopTime</span>. This also refuels the car to full capacity. (2 marks)
							</li>
							
						 </ol>
					</li>
				</ol>
				
				<li> 
					Create a class <span class="code">RaceSimulator</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				
				<ol>
					
					<li>
						Create a race track and name the variable holding it <i>silverstone</i>. Set the average lap time of this track to 
						<i>
							<?php 
								echo kToConfig(array("80", "75", "95", "90", "83", "83", "92", "101", "112", "107")); 
							?>
						</i> 
						seconds and make sure it is not raining. (1 mark)</li>
					
					<li>
						Create three cars, which have the following attributes:
					</li>
					
					<ul>
					
						<li>
							Car 1: 
							<ul>
								<li>the id is 
									<i>1</i>,
								</li> 
								<li>the starting fuel is 
									<i>
										<?php 
											echo kToConfig(array("60", "65", "49", "55", "67", "80", "70", "40", "79", "40")); 
										?></i>,
								<li>the low fuel boost
									<i>
										<?php 
											echo kToConfig(array("5", "4", "3", "6", "8", "7", "8", "2", "6" ,"5")); 
										?></i>,
								<li>the high fuel slowdown is
									<i>
										<?php 
											echo kToConfig(array("5", "6", "4", "5", "4", "3", "7", "3", "5", "6")); 
										?></i>,
								<li>the amount of fuel consumed per lap is
									<i>
										<?php 
											echo kToConfig( array("25", "28", "20", "25", "29", "35", "35", "16", "19", "20")); 
										?></i>,
								<li>the time taken for a pit stop is
									<i>
										<?php 
											echo kToConfig(array("20", "18", "15", "12", "16", "21", "27", "16", "25", "13")); 
										?></i>,
								<li>the additional time taken for a lap when it is raining is
									<i>
										<?php 
											echo kToConfig(array("15", "12", "11", "15", "11", "10", "10", "8", "15", "5")); 
										?></i>,
								<li>the total time starts at
									<i>
										0</i>,
							</ul>
						</li>
						
						<li>
							Car 2: 
							<ul>
								<li>the id is <i>2</i>,</li> 
								<li>the starting fuel is 
									<i>
										<?php 
											echo kToConfig(array("49", "55", "40", "60", "41", "49", "49", "35", "67", "35")); 
										?></i>,
								<li>the low fuel boost
									<i>
										<?php 
											echo kToConfig(array("3", "5", "2", "8", "7", "3", "3", "4", "8", "4")); 
										?></i>,
								<li>the high fuel slowdown is
									<i>
										<?php 
											echo kToConfig(array("6", "5", "3", "7", "6", "4", "6", "5", "4", "7")); 
										?></i>,
								<li>the amount of fuel consumed per lap is
									<i>
										<?php 
											echo kToConfig( array("30", "31", "16", "28", "31", "20", "30", "22", "29", "22")); 
										?></i>,
								<li>the time taken for a pit stop is
									<i>
										<?php 
											echo kToConfig(array("30", "23", "16", "14", "18", "15", "30", "14", "16", "17")); 
										?></i>,
								<li>the additional time taken for a lap when it is raining is
									<i>
										<?php 
											echo kToConfig(array("12", "14", "8", "10", "13", "11", "12", "9", "11", "7")); 
										?></i>,
								<li>the total time starts at <i>0</i>,</li>
							</ul>
						<li>
							Car 3: 
							<ul>
								<li>the id is <i>3</i>,</li> 
								<li>the starting fuel is 
									<i>
										<?php 
											echo kToConfig(array("70", "80", "35", "90", "79", "67", "60", "49", "41", "50")); 
										?></i>,
								<li>the low fuel boost
									<i>
										<?php 
											echo kToConfig(array("8", "7", "4", "10", "6", "8", "5", "3", "7", "6")); 
										?></i>,
								<li>the high fuel slowdown is
									<i>
										<?php 
											echo kToConfig(array("7", "3", "5", "6", "5", "4", "5", "4", "6", "2")); 
										?></i>,
								<li>the amount of fuel consumed per lap is
									<i>
										<?php 
											echo kToConfig( array("35", "35", "22", "30", "19", "29", "25", "20", "31", "24")); 
										?></i>,
								<li>the time taken for a pit stop is
									<i>
										<?php 
											echo kToConfig(array("27", "21", "14", "16", "25", "16", "20", "15", "18", "20")); 
										?></i>,
								<li>the additional time taken for a lap when it is raining is
									<i>
										<?php 
											echo kToConfig(array("10", "10", "9", "9", "15", "11", "15", "11", "13", "9")); 
										?></i>,
								<li>the total time starts at <i>0</i>,</li>
							</ul>
						</li>
						(1 mark)
					</ul>
					
					<li>
						Make your cars race for two laps around silverstone, and after each lap, print the id of the leader of the race. (1 mark)
					</li>
					
					<li>
						Make it rain on silverstone. Then, make your cars race for one more lap and, finally, print out the id of the winner of the race. (1 mark)
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
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, submit your assignment using the link marked `Assignment 3: Submission' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 3: Documentation Submission' on KEATS.</p>
		
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
