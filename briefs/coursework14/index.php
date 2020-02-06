
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
  <title>PPA Assignment 14</title>
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

        <h4>PPA Assignment 14</h4>
		
		<h5>Overview</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
		
		<p>Read through this brief carefully before starting your attempted solution. Also ensure that you comment your code.</p>
		
		<p>You are not advised to print this assignment, but instead to always access the latest version of this brief through KEATS, which will evolve with minor clarifications and corrections throughout the assessment period. Students will be notified of any major modifications to the brief by email.</p>
		
		<p>A partner from your lab session should be selected for this piece of work at the next available opportunity, typically your next lab session. You must not complete any of the assignment below without your chosen partner present, as doing so is likely to jeopardise your grade.</p>
		
		<p>For this piece of coursework, you may work with someone you have worked with previously, if you wish to, but selecting a new partner will be beneficial for your continued exploration of different approaches to programming.</p>
		
  	  	<h5>Aims</h5>
		
		<p>The aims of this piece of coursework are as follows:<p>
			
			<ul>
				
				<li>To use regular expressions to solve practical problems;</li>
				
				<li>To continue working with components, layout manager and events.</li>
				
			</ul>
		
		<p>As with many of the tasks this semester, and as part of your development as programmers, you will be expected to conduct some additional research, using the Java API, in order to complete some parts of this assignment. However, none of the tasks in this assignment are entirely unrelated to content taught directly in the course.</p>
		
  		<h5>Task Overview</h5>
		
		<p>Entering information into a calendar, such as the name, time, date and location of an event, or entering information into a list of reminders, can be tedious, especially <a href="dt4WZMKh/1.jpeg">under the traditional types of UI offered by major companies</a>.</p>
		
		<p>To respond to these limitations, companies like <a href="https://flexibits.com/fantastical">Fantastical</a> are introducing <a href="https://en.wikipedia.org/wiki/Natural_language_processing">natural language processing</a> into their calendar and reminder applications, in order to allow users to enter details of events, or to add reminders, in natural language. The application then processes this natural language, in order to extract information pertinent to the event, which can be added to other services such as shared calendars.</p>
		
		<p>In this piece of coursework, we will replicate such as an application as follows:</p>
		
		<p><a href="dt4WZMKh/1.gif"><img class="u-max-full-width" src="dt4WZMKh/1.gif" /></a>&#128519; .</p>
		
		<p>Your application is required to do the following:</p>
		
		<ol>
			
			<li>The main window should present two tabs (<a href="http://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html">more information here</a>), labelled calendar and reminders.</li>
			
			<li>Each tab should contain a list and a text box. Into the text box, the user should be able to enter natural text describing either an event, or a reminder. This text should then be processed, and displayed in the list:</li>
			
			<p><a href="dt4WZMKh/2.gif"><img class="u-max-full-width" src="dt4WZMKh/2.gif" /></a></p>
			
			<li>Once the natural text is entered into the text box, the user should be able to press return in order to begin the parsing process, and display the results in the list.</li>
			
			<li>The information in the list needs to include: the details of the event (Event), the date of the event (Date), the time of the event (Time), and the location of the event (Location).</li>
			
			<li>The format of the date shown in the list (output) <i>must</i> be: [Day of Week] [Date] [Month], as shown in the GIF above. The date of the event is identified by a suitable date string (input). Examples of the date formats that <i>must</i> be matched by your program are as follows, but you are strongly encouraged to make your program as receptive to different date formats as possible:
			
			<ol>
			
				<li>Wednesday 8th March</li>
				
				<li>08/03/2017</li>
				
				<li>On Wednesday (the date of the next day that occurs with this name).</li>
				
				<li>Next Wednesday (the date of the next day that occurs with this name, plus 7 days).</li>
				
			</ol>
			
			</li>
			
			<li>The format of the time shown in the list <i>must</i> be the time in 24 hour format, with the hours and minutes separated by a colon. The time of the event is identified by a suitable time string. Examples of the time formats that <i>must</i> be matched by your program are as follows, but you are strongly encouraged to make your program as receptive to different time formats as possible:
			
			<ol>
				
				<li>13:00</li>
				
				<li>1pm</li>
				
				<li>Evening (enters the time as 20:00)</li>
				
				<li>Morning (enters the time as 09.00)</li>
			
			</ol>
			
			</li>
			
			<li>If any information (date, time or location) is not included in the natural text entered, a dash should be shown instead of that information.</li>
			
			<li>We will assume that the location of an event is always identified by the prefix `at'. The location itself is the single word following the word `at'.</li>
			
			<li>The details of the event are described by any text that is entered that does not refer to the date, time or location of the event.</li>
			
			<li>A reminder is identified by the prefix `Remind me to' and should simply be displayed in the list on the reminders tab as this text minus the `Remind me to' prefix, as shown in the first screenshot.</li>
			
			<ol>
			
				<li>If a reminder contains time or date information, this should also be parsed, as with the event information, and displayed in the list, along with the reminder, in a similar style to the event information. If this information is not included, this can be omitted, as in the first GIF.</li>
			
			</ol>
			
			<li>In order to remove an item from the list, the user should be able to double click on an entry in this list.</li>
			
			<li>Any calendar entries or reminders that are entered into the application must to be visible when the application is reloaded.</li>
			 
		</ol>
		
		<h5>Considerations</h5>
		
		<ol>
		
			<li>Your application must be implemented in accordance with the model-view-controller (MVC) paradigm.</li>
		
			<li>[Update] Remember, your application must have the flexibility to find any of the input information no matter where it appears in the string entered by the user, as illustrated by the following additional example:
			
			
			
			</li>
			
			<p><a href="dt4WZMKh/3.gif"><img class="u-max-full-width" src="dt4WZMKh/3.gif" /></a></p>
			
			
			<li>Which class(es) can you extend in your model in order to store the information held by your program, and add additional features such as parsing and storage?</li>
			
			<li>It might be tempting to extract some of the functionality for this assignment directly from online resources like <i>StackOverflow</i>. We don't want to strictly forbid the use of resources like this, but remember you should only use these resources to inspire your code, rather than copying code directly, as latter constitutes plagiarism, and may affect your ability to explain your code during your lab assessment.</li>
			
			<li>How will you identify whether a date should be suffixed by `st', `nd', `rd' or `th'?</li>
			
			<li>How will you identify a double click on your list? Which listener would be appropriate for this?</li> 
					
		</ol>
		
		<h5>Optional tasks</h5>
		
		<ol>
			
			<li>Implement a login system for your application, requiring both a username and a password, that keeps your calendar entries and reminders secure. You should be able to change any password you select.</li>
			
			<li>As noted in the main body of the brief, try and make your application even more flexible in respect of the different formats of information (date, time and location) entered.</li>
			
			<li>Export your application as a jar file, so that it can be run from the command line without requiring distinct compilation and run processes. Which command will you need to run a jar file from the command line?</li>
			
			<li>It would be nice if our calendar application could be synchronised with services such as Office 365 and Exchange. You aren't required to implement anything for this task unless you wish to, but consider the services that might be available to allow us to implement such functionality.</li>
		
		</ol>
		
	</div>
	
	<div class="one-third column" style="margin-top: 5%; font-size: 14px;">
		
		<p>Once completed, both you and your partner must submit your assignment using the link marked `Assignment 14: Nexus Submission Link' on KEATS, which will become available after the first pair programming lab session. However, this is not enough to receive a mark for this piece of work. You must also attend the lab session following your submission, so that one of the teaching assistants can mark your work with you present, and ask you detailed questions about it. Revisit the `Lab Assessment and Pair Programming Q&A' guide on KEATS for more information.</p>
		
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
