
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
  <title>PPA Assignment 10</title>
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

        <h4>PPA Assignment 10</h4>

		<h5>This coursework is designed to help you revise the content from Weeks 1-5 and 7-11.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution and make sure you follow it as closely as possible, paying particular attention to the names
		required for elements of your code. Also ensure that you comment your code, as part of the assignment documentation.</p>
		
		<p>You are advised to always access the latest version of this brief through KEATS.</p>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
				
				A farmer wishes to harvest her crops.
				
				</i>
				
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
					
					<li>Model a <span class="code">Crop</span></li>
					
					<ol>
						
						<li>Every crop has a <span class="code">type</span> (e.g. "Corn", "Wheat", etc.), and a <span class="code">value</span> that would be made in profit if that crop were to be sold.</li>
						
						<li>It should be possible to understand the <span class="code">value</span> of a crop.</li>
						
					</ol>
					
					<li>Model a <span class="code">Field</span></li>
					
					<ol>
						
						<li>Every field consists of a set of <span class="code">Crop</span>s, which are all of the same type and value in our simple implementation.</li>
						
						<li>The maximum number of crops that any field can contain is 10.</li>
							
						<li>When a field is made, it should be possible to specify the <span class="code">type</span> and (individual) <span class="code">value</span> of the crops that are to be planted in that field.</li>
						
						<li>It should be possible to <span class="code">plant</span> the maximum number of crops that can exist in a field. When a field is first made, all crops should be <span class="code">plant</span>ed in this way.</li>
						
						<li>It should be possible to <span class="code">harvest</span> a field, such that the total <span class="code">value</span> of all the crops in the field is calculated and returned. As the result of a <span class="code">harvest</span>, all of the <span class="code">Crop</span>s in a field are removed.</li>
						
					</ol>
					
					<li>Model a <span class="code">Harvester</span>, which is a small machine used for harvesting crops:</li>
					
					<ol>
						
						<li>Every harvester has a <span class="code">fuelTankSize</span> and a <span class="code">topSpeed</span>.</li>
						
						<li>A harvester has a <span class="code">harvestingCapacity</span>, which determines how many fields that harvester can harvest in a single harvest (!).  <span class="code">harvestingCapacity</span> is determined by adding the <span class="code">fuelTankSize</span> to the <span class="code">topSpeed</span> of the harvester.</li>
						
					</ol>
					
					<li>Model a <span class="code">CombineHarvester</span>, which is a larger type of <span class="code">Harvester</span>:</li>
					
					<ol>
						
						<li>A combine harvester differs from a normal harvester in that it has a cutter bar at the front, which has a certain <span class="code">length</span>.</li>
						
						<li>This cutter bar allows the combine harvester to harvest more fields, such that its <span class="code">harvestingCapacity</span> is the same as the harvesting capacity of a normal <span class="code">Harvester</span>, multiplied by the <span class="code">length</span> of the cutter bar.</li>
						
					</ol>
					
					<li>Model a <span class="code">Farm</span>:</li>
					
					<ol>
						
						<li>A farm consists of a number of <span class="code">Field</span>s.</li>
						
						<li>A farm consists of a number of <span class="code">Harvester</span>s.</li>
						
						<li>It should be possible to <span class="code">add</span> a <span class="code">Harvester</span> to a farm.</li>
						
						<li>It should be possible to <span class="code">add</span> a <span class="code">Field</span> to a farm, with a certain <span class="code">type</span> of crop with a certain (individual) <span class="code">value</span>.</li>
						
						<li>It should be possible to understand the <span class="code">profit</span> a farm has made.</li> 
							
						<li>It should be possible for a <span class="code">Farm</span> to have a <span class="code">harvest</span>, in which the <span class="code">Field</span>s on the <span class="code">Farm</span> are <span class="code">harvest</span>ed. The total number of fields that are harvested in one harvest should depend on the total <span class="code">harvestingCapacity</span> of all the harvesters the farm owns. If this capacity is less than the number of fields, then not all of the fields can be harvested. If this capacity is equal to or greater than the number of fields, then all of the fields can be harvested. After each <span class="code">Field</span> is <span class="code">harvest</span>ed, we assume the farm sells the crops from that field, such that the farm's <span class="code">profit</span> is updated accordingly.</li>
						
					</ol>
					
				</ol>
						
				<li> 
					Create a class <span class="code">Harvest</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				</li>
				
				<ol>
				
					<li>Create a <span class="code">Farm</span>.</li>
					
					<li>Add a <span class="code">Harvester</span> to the farm, with a <span class="code">fuelTankSize</span> of 1 and a <span class="code">topSpeed</span> of 1.</li>
					
					<li>Add a <span class="code">CombineHarvester</span> to the farm, with a <span class="code">fuelTankSize</span> of 2, a <span class="code">topSpeed</span> of 2 and a <span class="code">length</span> of 3.</li>
					
					<li>Add 20 <span class="code">Field</span>s to the <span class="code">Farm</span>: 5 of corn, 5 of wheat, 5 of oats and 5 of barley. Each crop should have a value of 20.</li>
					
					<li>Run a <span class="code">harvest</span> using the <span class="code">Farm</span>.</li>
					
					<li>Print the <span class="code">Farm</span>'s <span class="code">profit</span>, which should be £2800.</li>
					
				</ol>
					
			</ol>
  
        </p>
		
	</div>
	
	<div class="one-half column" style="margin-top: 5%; font-size: 14px;">
		
		
		<p>Once completed, submit your assignment using the link marked `Assignment 10: Nexus Submission Link' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 10: Documentation Submission' on KEATS.</p>
		
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
