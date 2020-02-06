
<?php 
	
//	if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
	function kToConfig($configurations ) {
		
		return $configurations[intval(substr($_POST['ext_user_username'], 1)) % count($configurations)];
		
	}
	
?>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>PPA Assignment 13</title>
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

      <div class="two-thirds column" style="margin-top: 5%">

        <h4>PPA Assignment 13</h4>
		
		<h5>Overview</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution. Also ensure that you comment your code.</p>
		
		<p>You are not advised to print this assignment, but instead to always access the latest version of this brief through KEATS, which will evolve with minor clarifications and corrections throughout the assessment period. Students will be notified of any major modifications to the brief by email.</p>
		
		<p>A partner from your lab session should be selected for this piece of work at the next available opportunity, typically your next lab session. You must not complete any of the assignment below without your chosen partner present, as doing so is likely to jeopardise your grade.</p>
		
		<p>You must select a new partner for this piece of work, to ensure that there is no impact on your mark.</p>
  
  	  	<h5>Aims</h5>
		
		<p>The aims of this piece of coursework are as follows:<p>
			
			<ul>
				
				<li>To better understand and critique the model-view-controller (MVC) paradigm.</li>
				
				<li>To practise further with the use of widgets (components) and event handlers.</li>
				
				<li>To practise using the Java API, and associated resources, to work with new UI concepts, such as the use of images.</li>
				
			</ul>
		
        <p>As this assignment is designed to test the knowledge acquired over a two week period, you may not be able to complete all of this assignment until after the PPA lecture following its release, where further language concepts will be presented to you.</p>
		
		<p>In addition, as with many of the tasks this semester, and as part of your development as programmers, you will be expected to conduct some additional research, using the Java API, in order to complete some parts of this assignment.</p>
		
		<h5>Preliminary Tasks</h5>
		
		<p>In CW12, you were asked to implement a flight simulator, and in doing so consider how best to structure such a program.</p>
		
		<p>You probably considered a natural structure, in which you developed a set of classes -- like the ones you implemented in the first semester of PPA -- to represent the key entities in your program (e.g. the plane, the runway), and a class, or set of classes, to represent the new visual elements of your program, which you are learning this semester.</p>
		
		<p>Following Lecture 5, you should now be aware that this natural structure is formalised and developed by the model-view-controller paradigm.</p>
		
		<p>Therefore, as a preliminary task for CW13, you are asked to review the structure you chose for CW12, and if necessary, restructure it so that the communication between your classes fits the MVC structure given on Slide 18 of Lecture 5.</p>
		
		<p><a href="e6FdNaws/approach-a.png"><img class="u-max-full-width" src="e6FdNaws/approach-a.png" /></a></p>
		
		<p>Note that the unmarked line between the controller and the view here is optional.</p>
		
		<p>You will need to select one solution to modify: either yours, or your partners. Which you choose doesn't really matter, but you should probably choose the solution that you feel is most complete. If you feel that both of your solutions are complete, or both equally incomplete, select a solution at random. If the solution you choose is incomplete, then don't spend too long completing the functionality from CW12 (perhaps add print statements to show the functionality that you would have liked to include in a complete solution to CW12), but instead simply construct the outline MVC structure, so that you can demonstrate information and control passing through your program.</p>
		
		<p>If you feel that the solution you have chosen already matches the structure shown on this slide, you should add additional comments to your code in order to highlight where each element of the diagram shown on Slide 18 is implemented in your code.</p>
		
		<p>The classes you create or update for this task should be stored in a package called `preliminaries' in your `assignment13' project</p>
		
  		<h5>Task Overview</h5>
		
		<p>For the main part of this piece of coursework, you will build a program to allow the <a href="https://en.wikipedia.org/wiki/Fox,_goose_and_bag_of_beans_puzzle">Fox, Goose and Bag of Beans</a> puzzle to be played and solved. You are encouraged to read up on this problem, if you are not already familiar with it, before proceeding.</p>
		
		<p>A proposed UI for this task is as follows:</p>
		 
		<p><a href="e6FdNaws/ui.png"><img class="u-max-full-width" src="e6FdNaws/ui.png" /></a></p>
		
		<p>Based on this UI, and the problem, an overview of the functionality required by your program is as follows:</p>
		
		<ol>
		
			<li>The UI should be separated into distinct sections showing the two sides of the river, and the river in the middle.</li>
			
			<li>Appropriate icons should be placed on the right hand side of the river (where the farmer and his purchased products start, hereinafter called pieces), and a boat icon should be placed in the river.</li>
			
			<li>Labelled buttons should appear along the bottom of the screen, enabling the user to move each piece either left or right. Naturally, if a piece cannot move left or right because they are, for example, at the edge of the board, then nothing should happen when this button is clicked. Alternative mechanisms for interacting with the pieces on the board are acceptable, so long as the functionality is the same.</li>
			
			<li>It should only be possible to move the boat when the farmer is on it.</li>
			
			<li>The player should be scored, such that every time the boat moves, 1 is subtracted from their score, which starts at 0. Therefore, players who make the least moves will have the highest scores, although these scores will always be negative. This information should be shown in the title of the main frame, replacing the text shown in the image above.</li>
			
			<li>There should only be room for two pieces on the boat at the same time, which must always include the farmer if the boat is to move.</li>
			
			<li>A piece should only be allowed to move into the boat, if the boat is currently adjacent to the side of the river upon which that piece currently exists.</li>
			
			<li>If, at any point, a fail state is reached in the game (e.g. the fox is left alone with the goose, or the goose with the beans), then the frame title text should be replaced in order to inform the user of this, and it should not be possible for the user to continue using the controls to navigate through the game.</li>
			
			<p><a href="e6FdNaws/ui-2.png"><img class="u-max-full-width" src="e6FdNaws/ui-2.png" /></a></p>
			
			<li>Once all the pieces, including the farmer, are on the left hand side of the river, the game should end with a message of success being displayed in the title of the main frame.</li> 
			
			<li>Choose an appropriate package structure to hold the classes you write for this assignment.</li>
			
		</ol>
		
		<h5>Important</h5>
		
		<ol>
		
			<li>When completing your solution examine the MVC diagram above carefully, and adhere to the restrictions it places on the structure of your code closely, using your solution to the preliminary task as a reference. Don't add any additional lines of communication, or different forms of communication, between the model, view or the controller. This will be closely checked by your examiner. Specifically:</li>
			
			<ol>
			
				<li>When interacting with the model from the view (Step 4., above), it is essential that you only do so in a read-only fashion. In other words, no values in any objects associated with the model of your program should be set from the view via mutator methods. Instead, only accessor methods should be used. This will be checked especially carefully by your examiner.</li>
				
				<li>In addition, the model should hold no reference to any objects associated with the view, and thus call no methods from them (Step 3., above).</li>
				
			</ol>
			
			<li>Naturally, despite these restrictions, not every line of communication in the diagram shown may be required in your chosen solution.</li>
		
		</ol>
		
		<h5>Considerations</h5>
		
		<ol>
		
			<li>Overall, you should carefully consider whether you have the correct division between the view element of your program and the model element of your program, by asking the following question: would your program still provide the required functionality if any classes containing UI code were removed, and replaced with a simple main method that makes direct calls to the methods of the remaining classes, and prints results, like we saw last term? If not, you may need to separate your code further.</li>
			
			<li>In addition, you might like to consider how your code could be evolved further, in order to enable the view to also function if the model element of your program were to be removed. But you are not required to implement anything for this.</li>
				
			<li>In your model, you should aim to create the richest and most accurate representation of the entities in the domain as you can. This should include logical inheritance hierarchies, with no common parent classes where this doesn't make sense conceptually. You are advised to make use of interfaces to help you with this.</li>
			
			<li>In addition, we want to make our code as extensible as possible, and account for the introduce of similar types of pieces in the future (e.g. animals with similar traits to foxes and geese). Again, the use of interfaces may help you obtain this extensibility.</li>
			
			<li>To add images to your view, you may like to look into the capabilities offered by the <a href="https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html">JLabel</a> class.</li>
			
			<li>In order to update the background image of a panel you are encouraged to consult this <a href="https://docs.oracle.com/javase/tutorial/uiswing/painting/index.html">tutorial</a>. Note that not all of this tutorial will be relevant, particularly the opening discussion on threading. Instead, you are directed towards the discussion of the <span class="code"></span>paintComponent</span> method.</li> 
			
			<li>You are encouraged to source your own images for this assignment, but the images used in the screenshots above are available <a href="resources.zip">here</a>. If you wish to include labels describing what the images would show, rather than the images themselves, you are we</li>
					
		</ol>
		
		<h5>Optional tasks</h5>
		
		<ol>
			
			<li>When a fail state is reached, you may like to indicate why this is using the images on the UI themselves, such as a graphic to indicate who has eaten what. You should also capture this in your model, and ensure that you do so with extensibility in mind, as mentioned above.</li>
			
			<li>Once you have solved the game yourself, make a start on writing an AI to solve the game for you. Which techniques can you use for doing this? Attempting this task will also be a good test of whether the model is set up correctly, and captures all the interactions that the UI does, as a non-human player should be able to interact directly with the model classes in your program, and have access to discreet state information.</li>
		
		</ol>
		
	</div>
	
	<div class="one-third column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, both you and your partner must submit your assignment using the link marked `Assignment 13: Nexus Submission Link' on KEATS, which will become available after the first pair programming lab session. However, this is not enough to receive a mark for this piece of work. You must also attend the lab session following your submission, so that one of the teaching assistants can mark your work with you present, and ask you detailed questions about it. Revisit the `Lab Assessment and Pair Programming Q&A' guide on KEATS for more information.</p>
		
		<p>Any submitted code that is found to be unduly similar to the code submitted by any other pair(s) of students, will result in a penalty for those involved.</p> 
		
		<p>Provisional marks for your code will be released on KEATS within one week of the final lab assessment. Final assignment grades will be submitted to the exam board at the end of the semester.</p> 
		
		<p>For all other queries, see the Support section on KEATS, specifically the `Lab Assessment and Pair Programming Q&A' guide.</p>
  
      </div>
  
    </div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
