
<?php 
	
	if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	function kToConfig($configurations ) {
		
		return $configurations[intval(substr($_POST['ext_user_username'], 1)) % count($configurations)];
	//	return $configurations[intval(substr("k146492", 1)) % count($configurations)];
		//return "Hello";
	}
	
	
?>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 6</title>
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

        <h4>PPA Assignment 6</h4>

		<h5>This coursework is designed to test the content from Weeks 1, 2, 3, 4, 5 and 7.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>The total marks available for this assignment are 7.</p>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					We would like to create a simple door maze game. In this game, there are a number of rooms
					arranged sequentially. The player starts in the first room and must travel through each room
					in the sequence until they reach the final room, in which case they win the game. However,
					in order to go from one room to the next in the sequence, they must choose between two doors:
					a blue door or a red door. Note that the door which they used to enter the room is ignored, as
					the player cannot go back. Only one of the two doors leads to the next room, whereas the other lets
					a monster into the current room, which attacks the player before retreating back through the
					door which it came from. This results in the player losing a life. The player may pick a door
					again if they have at least one life left, otherwise they lose the game.
					
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
				<li>
						A <span class="code">Room</span> has a <span class="code">name</span>.
						Also, it contains a <span class="code">blueDoorRoom</span>,
						which is the room that the player will go to if they choose the blue door.
						Similarly, it also has a <span class="code">redDoorRoom</span>,
						which is the room that the player will go to if they choose the red door.
						Next, it has a status <span class="code">containsMonster</span>, specifying
						that either the room does, or does not, contain the monster. Lastly, 
						it has a status <span class="code">isFinalRoom</span>, indicating whether or
						not the room is the final one.
						(1 mark)
					</li>
					<li>
						A <span class="code">Player</span> has a <span class="code">name</span>,
						a number of <span class="code">lives</span> left and the 
						<span class="code">currentRoom</span> which they are in at any point
						in the game (1 mark)
					</li>
					
					<li>
						A Player can <span class="code">move</span> to a supplied <span class="code">room</span>. We will assume
						that the supplied room is one that is linked to the player's current room, via either the blue door
						or the red door. The method returns
						a result stating if the supplied room was the correct choice or not:
						<ul>
						<li>
							The room may contain the monster which will attack the player, resulting in the player
							losing a life.
						</li>
						<li>
							Otherwise, the room is the correct choice and the player should be moved into the room.
						</li>
						</ul>
						(1 mark)
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
					Create a class <span class="code">DoorMazeGame</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				
				<ol>
					<li>
						Create the following rooms (in any order):
						<ul>
						<li>
							Monster Room:
								<ul>
									<li>
										the variable name must be <i>monsterRoom</i>
									</li>
									<li>
										the <span class="code">name</span> as <i>The Monster Room</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
									<li>
										the <span class="code">containsMonster</span> status as <i>true</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 1:
								<ul>
									<li>
										the variable name must be <i>room1</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The First Room","Room One","The First Chamber","Chamber One","The First Cave","Cave One","The First Pathway","Pathway 1","The First Hall","Hall One")); 
										?></i>
									</li>
									<li>
										the <span class="code">blueDoorRoom</span> as
										<i><?php echo kToConfig(array("monsterRoom","room2","monsterRoom","room2","room2","room2","monsterRoom","monsterRoom","monsterRoom","room2")); 
										?></i>
									</li>
									
									<li>
										the <span class="code">redDoorRoom</span> as 
										<i><?php echo kToConfig(array("room2","monsterRoom","room2","monsterRoom","monsterRoom","monsterRoom","room2","room2","room2","monsterRoom")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 2:
								<ul>
									<li>
										the variable name must be <i>room2</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The Second Room","Room Two","The Second Chamber","Chamber Two","The Second Cave","Cave Two","The Second Pathway","Pathway 2","The Second Hall","Hall Two")); 
										?></i>
									</li>
									<li>
										the <span class="code">blueDoorRoom</span> as
										<i><?php echo kToConfig(array("room3","monsterRoom","room3","monsterRoom","room3","monsterRoom","room3","room3","room3","monsterRoom")); 
										?></i>
									</li>
									<li>
										the <span class="code">redDoorRoom</span> as
										<i><?php echo kToConfig(array("monsterRoom","room3","monsterRoom","room3","monsterRoom","room3","monsterRoom","monsterRoom","monsterRoom","room3")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 3:
								<ul>
									<li>
										the variable name must be <i>room3</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The Third Room","Room Three","The Third Chamber","Chamber Three","The Third Cave","Cave Three","The Third Pathway","Pathway 3","The Third Hall","Hall Three")); 
										?></i>
									</li>
									<li>
										the <span class="code">blueDoorRoom</span> as
										<i><?php echo kToConfig(array("monsterRoom","monsterRoom","room4","room4","monsterRoom","room4","monsterRoom","room4","room4","room4")); 
										?></i>
									</li>
									<li>
										the <span class="code">redDoorRoom</span> as
										<i><?php echo kToConfig(array("room4","room4","monsterRoom","monsterRoom","room4","monsterRoom","room4","monsterRoom","monsterRoom","monsterRoom")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 4:
								<ul>
									<li>
										the variable name must be <i>room4</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The Fourth Room","Room Four","The Fourth Chamber","Chamber Four","The Fourth Cave","Cave Four","The Fourth Pathway","Pathway 4","The Fourth Hall","Hall Four")); 
										?></i>
									</li>
									<li>
										the <span class="code">blueDoorRoom</span> as
										<i><?php echo kToConfig(array("monsterRoom","room5","monsterRoom","monsterRoom","room5","monsterRoom","room5","room5","monsterRoom","room5")); 
										?></i>
									</li>
									<li>
										the <span class="code">redDoorRoom</span> as
										<i><?php echo kToConfig(array("room5","monsterRoom","room5","room5","monsterRoom","room5","monsterRoom","monsterRoom","room5","monsterRoom")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 5:
								<ul>
									<li>
										the variable name must be <i>room5</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The Fifth Room","Room Five","The Fifth Chamber","Chamber Five","The Fifth Cave","Cave Five","The Fifth Pathway","Pathway 5","The Fifth Hall","Hall Five")); 
										?></i>
									</li>
									<li>
										the <span class="code">blueDoorRoom</span> as
										<i><?php echo kToConfig(array("room6","monsterRoom","monsterRoom","monsterRoom","monsterRoom","room6","room6","monsterRoom","room6","monsterRoom"
)); 
										?></i>
									</li>
									<li>
										the <span class="code">redDoorRoom</span> as
										<i><?php echo kToConfig(array("monsterRoom","room6","room6","room6","room6","monsterRoom","monsterRoom","room6","monsterRoom","room6")); 
										?></i>
									</li>
								</ul>
							</li>
							<li>
							Room 6:
								<ul>
									<li>
										the variable name must be <i>room6</i>
									</li>
									<li>
										the <span class="code">name</span> as
										<i><?php echo kToConfig(array("The Last Room","Room Six","The Final Chamber","Chamber Six","The Last Cave","Cave Six","The Final Pathway","Pathway 6","The Great Hall","Great Hall")); 
										?></i>
									</li>
									<li>
										the <span class="code">isFinalRoom</span> status as <i>true</i>
										<i><?php //echo kToConfig(array("London", "Madrid", "Auckland", "Oslo", "Zurich", "Mumbai", "Ottawa", "Beijing", "Buenos Aires", "Colombo", "Cape Town")); 
										?></i>
									</li>
								</ul>
							</li>
						</ul>
						
					(1 mark)
					</li>
					
					<li>
						Create a player, give them a maximum of 2 lives and start them off in room1.
						(1 mark)
					</li>
					
					<li>
						Create the main game using the following guidelines:
						<ul>
							<li>
								The game should first output an introductory message to the user, informing them of the game rules.
							<li>
								Ask the user to input their name, and update the player's name in the game accordingly.
							</li>
							<li>
								Next, repeatedly present the status of the game to the user, including the player's name,
								lives left and details of the current room. This should also repeatedly ask the user to
								input their choice of door, either "blue" or "red". Make the player <span class="code">move</span>
								to the selected room. Any other input from the user should result in a message being output
								stating the acceptable commands they can enter, along with their meaning.
							</li>
							<li>
								Ensure that when the player's lives reach 0, they lose the game.
							</li>
							<li>
								Ensure that when the player's reaches the final room they win the game.
							</li>
							
						</ul>
						
						(2 mark)
					</li>
					
			</ol>
  
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		
		<p>Once completed, submit your assignment using the link marked `Assignment 6: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 6: Documentation Submission' on KEATS.</p>
		
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
