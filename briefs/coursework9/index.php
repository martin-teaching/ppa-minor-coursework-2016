
<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	//function kToConfig($configurations ) {
		
	//	return $configurations[intval(substr($_POST['ext_user_username'], 1)) % count($configurations)];
		
	//}
	
	
?>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 9</title>
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

        <h4>PPA Assignment 9</h4>

		<h5>This coursework is designed to test the content from Weeks 1-5 and 7-10.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>You are advised to always access the latest version of this brief through KEATS.</p>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
				
				In the game of Battleship, each player positions a set of ships at a set of unknown grid references, and then take it it turns to guess their opponent's grid references, in order to sink their opponent's ships (Reference: https://en.wikipedia.org/wiki/Battleship_(game)). Each ship has multiple parts, each of which is destroyed when a hit is specified at the same row and column as that part.
				
				</i>
				
			</p>
			
			<p>
				<i>
						
				In this assignment, we will consider a simplified version of the game, which is shown in Figure 1, in which only one player (our program) positions the ships, and the other player (the player) guesses (purely numerical) grid references. Moreover, we will assume that ships are only positioned horizontally, from left to right, and always have their leftmost part at column zero.
					
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
					
					<li>First model a ship <span class="code">Part</span>:</li>
					
					<ol>
						
						<li>
							
							As we can see from Figure 1, each part of a ship exists at a specific <span class="code">row</span> and <span class="code">column</span> number.
						
						</li>
						
						<li>
							
							As we can also see from Figure 1, a part can either be <span class="code">destroyed</span> or hidden (i.e. not destroyed). It should be possible to <span class="code">set</span> a part to be destroyed, and understand when a part <span class="code">is</span> destroyed.
						
						</li>
						
						<li>
							
							Model that one <span class="code">Part</span> can be compared to another <span class="code">Part</span>, and these parts are considered equivalent when their <span class="code">row</span> and <span class="code">column</span> values match.
							
						</li>
						
						<li>
							
							A part should have a string representation that, based upon whether that part of the ship is destroyed or still hidden to the player, shows either a hit symbol ("[X]") or a blank symbol ("[ ]"), respectively. This is shown in Figure 2.
						
						</li>
						
						<li>
							
							To receive full marks for this question, there should not be any way to access the <span class="code">row</span> or <span class="code">column</span> values from outside the <span class="code">Part</span> class.
						
						</li>
					
					</ol>
					
					<li>Next, model a <span class="code">Battleship</span>:</li>
					
					<ol>
						
						<li>
							
							As can be seen from Figure 1, a battleship consists of a number of <span class="code">parts</span>.
						
						</li>
						
						<li>
							
							Initially a battleship does not consist of any <span class="code">parts</span>. So, when a battleship is first created, these parts need to be created, and stored as <span class="code">parts</span>, in order to represent the row and columns occupied by the ship. As can be seen from Figure 1, in our simplified game, all the parts of a ship are on the same <span class="code">row</span>, which should be specified when the ship is first created. Given this row, N parts should be created on this row, in the appropriate columns, where N is the size of the ship. For example, in the case of the battleship shown in Figure 1, 5 <span class="code">Part</span>s should be created and added as <span class="code">parts</span>:
						
						</li>
						
						<ol>
							
							<li>Part 1: Row = 0, Column 0.</li>
							<li>Part 2: Row = 0, Column 1.</li>
							<li>Part 3: Row = 0, Column 2.</li>
							<li>Part 4: Row = 0, Column 3.</li>
							<li>Part 5: Row = 0, Column 4.</li>
							
						</ol>
						
						<li>
							
							A battleship can be <span class="code">hit</span> at a particular <span class="code">row</span> and <span class="code">column</span>. If these values correspond to a <span class="code">part</span> that exists within the ship's <span class="code">parts</span>, then this part should be <span class="code">set</span> as destroyed, and <span class="code">hit</span> should confirm that part of the ship has been destroyed. If the part of the ship to which the <span class="code">row</span> and <span class="code">column</span> values pertain has already been destroyed, <span class="code">hit</span> should simply confirm the previous hit. Otherwise, this method should confirm that the hit has failed.
							
						</li>
						
						<li>
							
							Model that one ship can be compared to another ship, and the two are the same when the number of <span class="code">parts</span> in one ship is the same as the number of <span class="code">parts</span> in another ship. Indeed, this fact can be seen from Figure 1. However, if all the parts in this other ship have been destroyed, then it is not considered equal to the current ship, as it has been sunk. Similarly, if a destroyed ship is compared to a floating ship, even if they are of the have the same number of parts, they should not be equal. Ergo, two sunken ships of the same size are equivalent.
						
						</li>
						
						<li>
							
							A ship should have a default string representation, which returns all of its parts side-by-side, which is a sufficient representation as we only consider horizontally positioned ships in our simplified game.
							
						</li>
						
						<li>
							
							To receive full marks for this question, there should not be any way to access the number of parts in a ship from outside the <span class="code">Battleship</span> class.
							
						</li>
						
					</ol>
					
					<li>Create a <span class="code">Cruiser</span> which is a type of <span class="code">Battleship</span> that is defined as having 4 parts.</li>
					
					<li>Create a <span class="code">Frigate</span> which is a type of <span class="code">Battleship</span> that is defined as having 3 parts.</li>
					
					<li>Create a <span class="code">Minesweeper</span> which is a type of <span class="code">Battleship</span> that is defined as having 2 parts.</li>
					
					<ol>
						
						<li>
							
							Model that there is a 50% chance that, when hit, the resilient minesweeper will not be damaged by an opponent's hit.
							
						</li>
						
					</ol>
					
					<li>Next, create a <span class="code">Board</span>:</li>
					
					<ol>
						
						<li>
							
							Given that our ships contain their own row and column information in the form of <span class="code">parts</span>, there is no need for us to explicitly model a board as 2D plane. Instead, a board is simply defined by a list of <span class="code">Battleship</span>s (<span class="code">ships</span>).
							
						</li>
						
						<li>
							
							When a board is created, the ships shown in Figure 1 should be added to the board at the correct rows: 1 Battleship, 2 Cruisers, 1 Frigate and 1 Minesweeper. It should be possible to <span class="code">get</span> the ships currently on the board.
							
						</li>
						
						<li>
							
							It should be possible for a <span class="code">hit</span> to be specified on a board, in the form of a <span class="code">row</span> and <span class="code">column</span> value. <span class="code">hit</span> should check each ship to see whether that hit has been successful or not, and return a positive result if it has, and a negative result if it has not.
							
						</li>
						
						<li>
							
							The board should have a default string representation, as shown in Figure 2, that shows each ship (with each part, which is either hidden, or hit), and any empty locations. To achieve this, consider the following:
							
							<ol>
								
							<li>
							
							Give that we know that, in our simplified version of the game, each row of the board will only contain a single horizontally positioned ship, we can make each ship from <span class="code">ships</span> appear on a new line in our string representation, in order to get an accurate representation of the board, as shown in Figure 1. 
							
							</li>
							
							<li>
								
							For those locations on the board not occupied by part of a ship, a blank character ("[ ]") should be added. Again, because of the simplified nature of our game, to do this, it might be useful to understand the type of each ship that is positioned in each row (i.e. on each line), so that it is possible to simply enter a suitable number (5 - N) of blank ("[ ]") symbols after the string representation of each ship on each row.
						
							</li>
							
					</ol>
						
				</ol>
				
			</ol>
						
				<li> 
					Create a class <span class="code">Game</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				</li>
				
				<ol>
				
					<li>First of all, create the board.</li>
					
					<li>At the start of the main game loop, print the number of ships of each type that are currently on the board (i.e. those ships that have not been sunk), as shown in Figure 2. To do this, you may wish to look at the static method <i>frequency</i> in the <i>Collections</i> class.</li>
					
					<li>Then, print the board.</li>
					
					<li>Next prompt the user to enter a single row and column number on a single line, separated by a space, again as shown in Figure 2.</li>
					
					<li>Check whether that row and column number constitutes a hit on the board, if it does, print "Hit!", if it does not, print "Miss!".</li>
					
					<li>The loop should continue until the user enters "quit".</li>
					
					<li><i>For simplicity, we will not consider the case in which the user enters anything but a single row and column number separated by a space, or how to proceed once the game has ended, but you are welcome to add this (unmarked) functionality</i>.</li>
				
				</ol>
					
			</ol>
  
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		
		<p>Once completed, submit your assignment using the link marked `Assignment 9: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 9: Documentation Submission' on KEATS.</p>
		
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
