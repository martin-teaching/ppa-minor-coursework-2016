<?php 
	
	if (!array_key_exists('ext_user_username', $_POST)) die();
	
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
  <title>PPA Assignment 7</title>
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

        <h4>PPA Assignment 7</h4>

		<h5>This coursework is designed to test the content from Weeks 1 - 5 and 7 and 8.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>The total marks available for this assignment are 18.</p>
  
        <p>
			
			<p> For this week's assessment, consider the following scenario, and then complete the tasks that follow it:</p>
			
			<p>
			
				<i>
			
				On a series of islands in the Carribean exist a set of hidden treasure chests, buried there by different pirates over many years. Now, a new pirate wishes to sail to each of these islands and find any treasure that is buried there. 
					
				</i>
			
			</p>
			
        	<ol> 
				
				<li>
					
					Model this scenario based on the following requirements:
				
				</li>
					
					<ol>
						
						<li>
							
					
							First model a <span class="code">GoldCoin</span> with the following features. Each gold coin has a <span class="code">coinNumber</span>. This number is stamped onto each coin by the Eastern Trading Company (who mint all gold coins, and wish to keep track of them), when it is first made. Each coin number is <strong>unique</strong>, and is determined using a process that is kept secret by the Eastern Trading Company. To model the secrecy of this process, it should <strong>not</strong> be possible to pass a <span class="code">coinNumber</span> (or indeed any other information) to the <span class="code">GoldCoin</span> class. Instead setting the coin number, and keeping it unique, should be handled internally by the <span class="code">GoldCoin</span> class. However, it should still be be possible to read the number stamped onto a coin. Although not directly useful to a pirate, this information may be important to other individuals who interact with the coins (1 mark).
							
						</li>
						
						<li>
							
							Next, model a <span class="code">TreasureChest</span>. A <span class="code">TreasureChest</span> consists of a set of <span class="code">GoldCoin</span>s. A <span class="code">TreasureChest</span> can hold <?php echo kToConfig(array("10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));?> <span class="code">GoldCoin</span>s; a value that is fixed for all chests. When a chest is first made, it is filled with the maximum number of gold coins it can contain. It should be possible to <span class="code">takeOneGoldCoin</span> from the chest, while there are still coins in the chest, which is then removed from the set of coins in the chest (1 mark).
							
						</li>
						
						<li>
							
							An <span class="code">Island</span> should be modelled as follows: 
							
							<ol>
								
								<li> 
									
									Each <span class="code">Island</span> has a <span class="code">name</span>, and consists of a number of <span class="code">locations</span> (for example a beach, a cave, the top of a mountain etc.), each of which may or may not contain a buried <span class="code">TreasureChest</span>. When an <span class="code">Island</span> is first created, a <span class="code">TreasureChest</span> should be buried at one of these locations, chosen at <strong>random</strong> by the program (1 mark).
									
								</li>
								
								<li>
									
									It should be possible to <span class="code">dig</span> at one of the locations on that island, as indicated by a supplied integer. If, after digging, a location contains a treasure chest, this should be removed from the island and returned as a result of the dig. If a location does not contain a buried treasure chest, then, naturally, no chest should be returned. Appropriate steps should be taken to ensure that the integer supplied corresponds to one of the available locations on the island, and if it does not, then, again, no chest should be returned (1 mark). 
									
								</li>
								
								<li>
									
									Finally, it should be possible to access the <span class="code">name</span> of an island, and the number of bury <span class="code">locations</span> on that island (1 mark).
									
								</li>
							
							</ol>
							
						</li>
						
						<li>
							
							A <span class="code">Pirate</span> should be modelled as follows:
							
							<ol>
								
								<li>A pirate has a <span class="code">name</span>, and a <span class="code">purse</span>, which can hold a number of <span class="code">GoldCoin</span>s. A pirate also has a <span class="code">map</span>, which depicts a number of <span class="code">Island</span>s (1 mark).</li> 
								
								<li>A pirate has the ability to <span class="code">search</span> for an island, which should involve the following process (1 mark):</li>
							
								<ol>
							
									<li>The search starts with a <span class="code">name</span>, which may correspond to an <span class="code">Island</span> on the pirate's <span class="code">map</span> that contains treasure. This name is passed to the <span class="code">Pirate</span>.</li>
									
									<li>The pirate then <span class="code">search</span>es for an <span class="code">Island</span> on their <span class="code">map</span> with this <span class="code">name</span>. If an island with this name is not found on the pirate's map, then a negative result is returned, otherwise the result is the correct <span class="code">Island</span>.</li>
							
								</ol>
								
								<li>A pirate has the ability to <span class="code">getTreasure</span> buried on an <span class="code">Island</span>, which should involve the following process (1 mark):</li>
								
								<ol>
									
									<li>A pirate attempts to <span class="code">getTreasure</span> on an <span class="code">Island</span> by <span class="code">dig</span>ging in each location to see if it contains a <span class="code">TreasureChest</span>. If no chest is found, a negative result is returned.</li>
							
									<li>If a tresure chest is found in one of the locations, the pirate <span class="code">take</span>s<span class="code">OneGoldCoin</span> from that <span class="code">TreasureChest</span>, until all of the <span class="code">GoldCoin</span>s are taken, and places these coins into their own <span class="code">purse</span>. Once this is done, the treasure is obtained, and the result is positive.</li>
								</ol>
								
								<li>A pirate can be asked for the <span class="code">totalCoins</span> in their <span class="code">purse</span> (1 mark).</li>
								
								<li>A pirate can <span class="code">speak</span>, which adds a <strong>randomly selected</strong> pirate-themed suffix, chosen by the program, to a supplied <span class="code">phrase</span>, which is then printed. The list of pirate suffixes are as follows (1 mark):</li>
								
								<ul>
								
									<li><span class="code">phrase</span> followed by ", arrr!"</li>
									<li><span class="code">phrase</span> followed by ", shiver me timbers!"</li>
									<li><span class="code">phrase</span> followed by ", avast!"</li>
									<li><span class="code">phrase</span> followed by ", ahoy, matey!"</li>
									<li><span class="code">phrase</span> followed by ", yo, ho ho!"</li>
									
								</ul>
								
							</ol>
							
						</li>
						
						
					</ol>
					
				</li>
						
				<li> 
					
					Create a class <span class="code">TreasureHunt</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1. For full marks, all print statements should be in <span class="code">Pirate speak</span>.
					
					<ol>
						
						<li>Create a map with three islands. There should be <?php echo kToConfig(array("20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10"));?> possible bury locations on each island. Add these islands to the map in the following order (1 mark):</li>
						
						<ol>
							
							<li><?php echo kToConfig(array("Port Royal", "Tortuga", "Dominica", "Nassau", "Havana", "St Kitts", "Guadeloupe"));?></li>
							<li><?php echo kToConfig(array("Tortuga", "Dominica", "Nassau", "Havana", "St Kitts", "Guadeloupe", "Port Royal"));?></li>
							<li><?php echo kToConfig(array("Dominica", "Nassau", "Havana", "St Kitts", "Guadeloupe", "Port Royal", "Tortuga"));?></li>
							
						</ol>
						
						<li>Create a pirate with an appropriate name. For example, <i>Captain Chapman</i> or <i>Chapbeard</i>. This pirate should also have the map created above (1 mark).</li>
						
						<li>Allow a user to suggest the name of an island to the pirate, who will then <span class="code">search</span> for this island on their map (1 mark).</li>
							
						<li>If the island cannot be found on the pirate's map, print that the suggested island could not be found (1 mark).</li>
						
						<li>If the island is found, prompt the pirate to <span class="code">getTreasure</span> from this island, if any is buried (1 mark).</li>
						
						<li>If a chest is found, print which island the chest was found upon, and the new total coins in the pirate's purse (1 mark).</li>
						
						<li>If a chest is not found, print that the suggested island did not contain any treasure (1 mark).</li>
							
						<li>A user should be able to continuously suggest the names of islands to the pirate, until they enter the word <i>stop</i> (1 mark).</li>
						
					</ol>
					
				</li>
				
			</ol>
			
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, submit your assignment using the link marked `Assignment 7: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 7: Documentation Submission' on KEATS.</p>
		
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
