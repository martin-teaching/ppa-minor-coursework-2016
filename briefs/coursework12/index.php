
<?php 
	
	//if (!array_key_exists('ext_user_username', $_POST)) die(); 
	
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
  <title>PPA Assignment 12</title>
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

        <h4>PPA Assignment 12</h4>
		
		<h5>Overview</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution. Also ensure that you comment your code.</p>
		
		<p>You are not advised to print this assignment, but instead to always access the latest version of this brief through KEATS, which will evolve with minor clarifications and corrections throughout the assessment period. Students will be notified of any major modifications to the brief by email.</p>
		
		<p>A partner from your lab session should be selected for this piece of work at the next available opportunity, typically your next lab session. You must not complete any of the assignment below without your chosen partner present, as doing so is likely to jeopardise your grade.</p>
		
		<p>You must select a new partner for this piece of work, to ensure that there is no impact on your mark.</p>
  
  	  	<h5>Aims</h5>
		
		<p>The aims of this piece of coursework are as follows:<p>
			
			<ul>
				
				<li>To explore the roles different components can have in a GUI;</li>
				<li>To explore the use of GUI layouts;</li>
				<li>To employ simple event handlers;</li>
				<li>To understand how to layout and structure GUI code;</li>
				<li>To solve basic problems in Java.</li>
				
			</ul>
		
        <p>As this assignment is designed to test the knowledge acquired over a two week period, you may not be able to complete all of this assignment until after the PPA lecture following its release, where further language concepts will be presented to you.</p>
			
  		<h5>Task Overview</h5>
		
		<p>In this piece of work, we are going to build a very simple <a href="https://en.wikipedia.org/wiki/Microsoft_Flight_Simulator">Flight Simulator</a>, the graphical component of which will be constructed using the basic UI components offered to us by Java Swing:</p>
		
		<img class="u-max-full-width" src="txHs5YMS/diagrams.001.jpeg" />
		
		<p>As you can see from the left image above, a typical flight simulator places the player at the viewpoint of a pilot in a plane. Therefore, the screen is separated into two parts: the top of the screen shows the view the pilot has out of the window of the cockpit, facing forward, and the bottom of the screen shows a view of the plane controls in the cockpit, which the pilot (the player) can interact with.</p>
		
		<p>As can also be seen from the left image above, the plane starts on a runway, facing forward. In this assignment, we will only consider the phase of the flight simulation in which the plane takes off.</p>
		
		<p>The right image above shows how we will replicate the flight simulator UI to the left in Java. Rather than displaying a graphic of the world outside the plane, our UI will simply describe this world using a series of printed statements. Details of what these statements are to say will follow.</p>
		
		<p>In addition, rather than a comprehensive set of controls, as shown in the image on the left, we will only consider two main controls, as shown in the image on the right, designed to set the x position and the speed of the plane, as shown below:</p>
		
		<img class="u-max-full-width" src="txHs5YMS/diagrams.002.jpeg" />
		
		<p>We will also consider a reset button, that restarts the simulation.</p>
		
		<h5>Simulation Timeline</h5>
		
		<p>When the program starts, the simulation should start.</p>
		
		<p>The passage of time in the simulation is quantified by updating the state of the aircraft every second, based upon the current state of the aircraft controls. Details of the current state of the aircraft should be output, at each timestamp, to the UI. This information should include the current time, the x and y position of the plane, the plane's speed and its elevation (i.e. how high it is in the air). Examples of this output are shown in the demonstrations below.</p>
		
		<p>At the start of the simulation, the aeroplane has not yet taken off, so it is at the start of the runway, in the centre. For formality, we will measure the position of the plane from the nose, but this should not have a significant impact on how we construct our simulator. Note that the below image is rotated 90 degrees clockwise:<p>
		
		<p><img class="u-max-full-width" src="txHs5YMS/diagrams.003.jpeg" /></p>
		
		<p>So, if the user does not interact with the controls during the simulation, time passes with the aeroplane staying in this position at the start of the runway. This, and the general passage of time, can be seen below, as a looping GIF:</p> 
		
		<p><img class="u-max-full-width" src="BwXugrm3/1.gif" /></p>
		
		<p>The aim of the player is to make the plane take off. In order for the plane to successfully take off, once it exceeds the end of the runway, it must:</p>
		
		<ol>
		
			<li>Have exceeded a certain elevation</li>
			<li>Be in the centre of the runway.</li>
		
		</ol>
		
		<p>If the plane does not exceed this elevation once it exceeds the end of the runway, or is not at its central position once it exceeds the end of the runway, the take off should fail.</p>
		
		<p>In order to lift off from the ground (i.e. gain elevation), and climb towards a given elevation, the plane must be going at a certain speed for a given number of seconds. When the plane reaches this speed, and has been travelling at this speed for the given number of seconds, then the plane's elevation increases by 1 for each second that passes.</p>
		
		<p>Therefore, the plane may gain enough elevation to exceed the elevation required for a take off before it exceeds the end of the runway (i.e. take off early). In this instance, the plane should only take off (early) if it is in the centre of the runway. However if it is not, then the pilot still has a chance to correct the position of the plane before it exceeds the end of the runway. If he does not, then the take off fails.</p>
		
		<h5>Simulation Parameters</h5>
		
		<p>We will assume the following about the state of the world for the flight simulation:</p>
		
		<ol>
			
			<li>Plane minimum and maximum speed: 0 and 10.</li>
			<li>Plane minimum and maximum x position: 0 and 10.</li>
			<li>Runway width: 10.</li>
			<li>Runway length: 100.</li>
			<li>Plane initial x: 5.</li>
			<li>Plane initial y: 0.</li>
			<li>Speed required to increase elevation: 10.</li>
			<li>Time at this speed (speed required to increase elevation) in order to increase elevation: 5.</li>
			<li>Elevation required for a successful take off: 5.</li>
			
		</ol>
		
		<h5>Demonstrations</h5>
		
		<p>A successful takeoff is therefore as follows...</p>
		
		<p><img class="u-max-full-width" src="BwXugrm3/2.gif" /></p>
		
		<p>...while this is an unsuccessful takeoff due to a lack of speed (i.e. the front of the plane exceeds the end of the runway, but it is not moving quick enough)...</p>
		
		<p><img class="u-max-full-width" src="BwXugrm3/3.gif" /></p>
		
		<p>..and this is an unsuccessful takeoff due to incorrect x positioning...</p>
		
		<p><img class="u-max-full-width" src="BwXugrm3/4.gif" /></p>
		
		<p>As shown in these graphics, the simulation ends (i.e. the passage of time stops) when the plane is either in flight, or the takeoff has failed.</p>
		
		<h5>Considerations</h5>
		
		<p>You will need to consider the following when building your simulator:</p>
		
		<ol>
			
		<li>You might like to start by building your frame. Which components will you use? How will you get these components to appear in the correct positions on the frame? How can you neatly arrange your components so that when the window is sized, they remain in appropriate positions?</li>
			
		<li>Which classes can we reuse from previous assignments? If we can reuse any, we should, in order to avoid duplicating work. If you do reuse classes, they should be stored in a separate package in your solution.</li>
		
		<li>How will you represent the runway in your program? Are there any existing library classes that can help us with this?</li>
		
		<li>How can we control the passage of time in Java? The answer is to use a static method from the class <span class="code">Thread</span> called <span class="code">Sleep</span>. This allows us to put pauses in our program. The code you will need is as follows, where the value passed to the sleep method is the number of milliseconds you wish your program to pause for. What all the facets of this code do, including the notion of an exception, will become clear later in the course:</li>
		
<pre>
		
try {
			
	Thread.sleep( ... );
				
} catch ( InterruptedException e ) { ... }

</pre>
		
		<li>You will need to update the position of the plane every second, based upon the state of the plane controls in the simulator. For the X position of the plane this involves simply translating the position of the centre stick to the position of the plane. For the Y position of the plane, you will need to combine the average speed of the plane (the position of the throttle) with the time the plane has been moving, in order to derive an incremented y position. In reality, this translates to an incrementation by the current speed of the plane each second. For simplicity, we will not consider the time it takes for a plane to reach a certain speed, but instead consider it to reach that speed immediately. The graphics above may be useful in observing this fact.</li>
		
		<li>You will need to update the elevation of the plane every second, based upon whether it is going at the required speed, and whether it has been going at that required speed for the required duration.</li>
		
		<li>How will you determine whether the plane is in flight or when a take off has failed, and how will this information be used to stop the progression of the simulation if necessary?</li>
		
		<li>How will you deal with edge cases, such as what happens if the pilot reduces speed prior to elevation, or if the pilot immediately reduces speed while the plane is in elevation? There are several options here, any of which will suffice, so long as your choices are logical, and you can explain these to your examiner.</li>
		
		<li>Consider how you might formally separate the key elements of your program into different classes, and into different packages. We may not have yet covered enough in the course in order for you to be aware of, or to achieve, the optimum separation, so this will not affect your marks, but try and achieve the most natural separation of your code as you can.</li>
			
		</ol>
		
		<h5>Optional tasks</h5>
		
		<ol>
		
		<li>As an optional task, you may like to implement the reset button functionality, which may not be as trivial as it seems.</li>
		
		<ol>
		
		<li>When clicked, the position of the plane, and all of its associated attributes, should be reset, as should the position of the controls in the UI. Then the main simulation loop should begin again.</li>
		
		<li>Depending on how you've separated your code you may need to consider different techniques for inter-object communication.</li>
		
		<li>Do you experience any unusual behaviour from your GUI when trying to implement this functionality? If so, consider why this might be, and what a proposed solution may be.</li>
		
		<li>Regardless of whether you complete this task, your UI should still display the reset button.</li>
		
		</ol>
			
		<li>The current controls are very simple in appearance. Try adding some extra information to them, such as labels for the throttle and centre stick. You may even wish to add an extra component to display speed and elevation information.</li>
		
		<ol>
			
			<li>Any modifications you make to the UI for this additional task should not affect the basic functionality you have implemented.</li>
			
		</ol>
		
		</ol>
		
	</div>
	
	<div class="one-third column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, both you and your partner must submit your assignment using the link marked `Assignment 12: Nexus Submission Link' on KEATS, which will become available after the first pair programming lab session. However, this is not enough to receive a mark for this piece of work. You must also attend the lab session following your submission, so that one of the teaching assistants can mark your work with you present, and ask you detailed questions about it. Revisit the `Lab Assessment and Pair Programming Q&A' guide on KEATS for more information.</p>
		
		<p>Any submitted code or documentation that is found to be unduly similar to the code or documentation submitted by any other pair(s) of students, will result in a penalty for those involved.</p> 
		
		<p>Provisional marks for your code will be released on KEATS within one week of the final lab assessment. Final assignment grades will be submitted to the exam board at the end of the semester.</p> 
		
		<p>For all other queries, see the Support section on KEATS, specifically the `Lab Assessment and Pair Programming Q&A' guide.</p>
  
      </div>
  
    </div>
  
  </div>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
