
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
  <title>PPA Assignment 4</title>
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

        <h4>PPA Assignment 4</h4>

		<h5>This coursework is designed to test the content from Topics 1, 2, 3, 4 and 5.</h5>
		
		<h6>Do you think there is a problem with any of the content below? Let us know immediately at <a href="mailto:programming@kcl.ac.uk">programming@kcl.ac.uk.</a></h6>
  
        <p>
			<p> For this week's assessment, consider the following scenario, and then complete the
			tasks that follow it:</p>
			
			<p>
				<i>
					We would like to create an exam attempt marker. Exams questions can be of multiple types,
					such as: one that requires a single numerical value as its answer, one that requires a
					either 'yes' or 'no' as its answer, or a multiple choice question which requires one or more of
					its options to be selected. An exam attempt is marked using a mark scheme, which is a special
					version of an exam attempt in which each question's answer is set to its correct value, and  
					the total possible mark for the question set to its maximum. Marking an exam attempt awards a
					mark, out of the total number possible, for each question. Then, the sum of the mark
					awarded for each question is calculated to give a total mark for the attempt, out of the total possible for the exam. Finally, the
					attempt's total mark is converted to a degree classification; either
					1.1, 2.1, 2.2 or 0.0.
				</i>
			</p>
			
        	<ol> 
				
				<li>
					Model this scenario based on the following requirements:
				</li>
				
				<ol>
					<li>
						The first question type is a <span class="code">NumericalQuestion</span>. A numerical question will have
						one <span class="code">answer</span>, used either for a student's attempt or for the correct value.
						It will also have a <span class="code">mark</span>, used either for the mark awarded to the student
						in an attempt or the total mark available for the question in a mark scheme. Both of these
						pieces of data are whole number values. When we create a numerical question, we should be able
						to specify values for these pieces of data. (1 mark)
					</li>
					<li>
						The next question type is a <span class="code">BooleanQuestion</span>. A boolean question will have
						one <span class="code">answer</span>, used either for a student's attempt or for the correct value. This
						can either be <i>yes</i> or <i>no</i>. This kind of question will also have a <span class="code">mark</span>, used 
						either for the mark awarded to the student in an attempt or the total mark available for the
						question in a mark scheme. When we create a boolean question, we should be able
						to specify values for these pieces of data. (1 mark)
					</li>
					<li>
						The final question type is a <span class="code">MultipleChoiceQuestion</span>. A multiple choice 
						question will have three possible options: <span class="code">option1</span>, 
						<span class="code">option2</span> and <span class="code">option3</span>. In addition, a multiple
						choice question also has a <span class="code">mark</span>, used either for the mark awarded to the student
						in an attempt or the total mark available for the question in a mark scheme. Each of these options 
						can either be selected or not selected. When we create a multiple choice question, we should be able
						to specify values for all of these pieces of data.
						(1 mark)
					</li>
				
					<li>
						Create a class to represent an <span class="code">Exam</span>. This will be used either for a
						mark scheme or a student's attempt at the exam.
						An Exam consists of three questions as follows: 
						<span class="code">question1</span> which is a <span class="code">NumericalQuestion</span>,
						<span class="code">question2</span> which is a <span class="code">BooleanQuestion</span>,
						and <span class="code">question3</span> which is a <span class="code">MultipleChoiceQuestion</span>.
						It also has a <span class="code">totalMark</span>, which is used either for the mark awarded to the student
						for the entire exam attempt, or the total mark available for the entire exam in a mark scheme.
						When we create a copy/object of this class, we should be able to specify values for all of these pieces of data.
						(1 mark)
					</li>
					
					
					<li>
						Create a class to represent a <span class="code">Marker</span>, which will be used for the process of marking exams.
						A marker has two behaviours.
						The first is that it can <span class="code">markAttempt</span>, which works as follows:
						<ol>
							<li>
								It performs the marking procedure on a supplied <span class="code">examAttempt</span>, using a supplied <span class="code">markScheme</span>,
								then returns the total mark awarded to the attempt.
							</li>
							<li>
								For Question 1, the attempt must have the same answer as the answer in the mark scheme, in order to
								receive the maximum mark for this question. However, the answer in the attempt might be 1 higher or 1
								lower than the answer in the mark scheme, in which case the question in the attempt is awarded
								1 mark lower than the maximum mark.
								Furthermore, the answer in the attempt might be <i>up to and including</i> 5 higher or 5 lower than the answer in the mark scheme,
								in which case the attempt receieves 1 mark for this question. Otherwise, the question is awarded a mark of 0.
							</li>
							<li>
								For Question 2, the attempt must have the same answer as the answer in the mark scheme in order to receive
								the maximum mark. Otherwise, the question is awarded a mark of 0.
							</li>
							<li>
								For Question 3, each option in an attempt that is the same as its corresponding option in the mark scheme
								results in one mark being awarded to the question in the attempt. This means that the first option in the attempt
								must be the same as the first option in the mark scheme in order to get one mark, the second
								option in the attempt must be the same as the second option in the mark scheme in order to get
								one mark, and the same is true for the third option. 
							</li>
							<li>
								The mark awarded for each question in an attempt must be stored in that question, and the 
								<span class="code">totalMark</span> of the attempt should be updated accordingly.
							</li>
						</ol>
						(2 mark)
					</li>
						
					<li>
						A <span class="code">Marker</span> can also <span class="code">convertMarksToClassification</span>, which converts a supplied 
						<span class="code">mark</span> number to a numerical degree classification,
						which is then returned. This is done using the following supplied values: <span class="code">firstBoundary</span>,
						<span class="code">upperSecondBoundary</span> and <span class="code">lowerSecondBoundary</span>. In order to obtain
						a classification of <i>1.1</i>, the mark must be at least the value in <span class="code">firstBoundary</span>. A mark of less than this
						but higher than or equal to <span class="code">upperSecondBoundary</span> is awarded a classification of <i>2.1</i>. A mark of lower than this
						but at least equal to the value in <span class="code">lowerSecondBoundary</span> is awarded a classification of<i>2.2</i>. Any lower mark number
						results in a fail, represented as a classification of <i>0.0</i>. (2 mark)
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
					Create a class <span class="code">MarkExams</span>, which can be compiled and run from the command line. Use this class to do the
					following (in order), using the classes and methods you have created for Question 1.
				
				<ol>
					<li>
						Create a <span class="code">NumericalQuestion</span> and name the variable holding it <i>nqMarkScheme</i>, to be used for the mark scheme.
						The answer for this question is <i><?php echo kToConfig(array("31", "76", "124", "198", "1150", "1748", "23609", "48055", "120369", "263074")); ?></i> and the maximum mark available is <i><?php echo kToConfig(array("3", "4", "5", "6", "7", "8", "9", "10", "11", "12")); ?></i>
						(1 mark)
					</li>
					
					<li>
						Create a <span class="code">BooleanQuestion</span> and name the variable holding it <i>bqMarkScheme</i>, to be used for the mark scheme.
						The answer for this question is 
							<i><?php 
							echo kToConfig(array("true", "false", "false", "true", "false", "true", "false", "true", "true", "false")); 
							?></i> and the maximum mark available is <i>1</i>.
							
						(1 mark)	
					</li>
					
					<li>
						Create a <span class="code">MultipleChoiceQuestion</span> and name the variable holding it <i>mcqMarkScheme</i>. 
						This will be used for the mark scheme. Set the mark as 3 and the options as follows:
						<ol>
							<li>
								option1 as 
									<?php 
										echo kToConfig(array("false", "false", "true", "false", "true", "false", "true", "false", "true", "true")); 
									?>,
								 
							</li>
							<li>
								option2 as 
									<?php 
										echo kToConfig(array("true", "true", "false", "false", "true", "true", "true", "false", "false", "false")); 
									?>,
								 
							</li>
							<li>
								option3 as
									<?php 
										echo kToConfig(array("false", "true", "true", "false", "false", "true", "true", "true", "false", "true")); 
									?>,
								
							</li>
						</ol>
						(1 mark)
					</li>
						
					<li>
						Create a mark scheme and name the variable holding it <i>markScheme</i>. It's set of questions
						are made up of the questions defined for the mark scheme in the previous sub-questions.
					(1 Mark)
					</li>
					
					<li>
						Create a <span class="code">NumericalQuestion</span> and name the variable holding it <i>nqAttempt</i>, to be used for a student's attempt
						at the exam.
						The answer for this question is <i><?php echo kToConfig(array("29", "75", "256", "196", "1149", "1700", "23608", "4022", "120368", "263073"));?></i> and the mark is 0 (because the question has not yet been marked). (1 mark)
					</li>
					
					<li>
						Create a <span class="code">BooleanQuestion</span> and name the variable holding it <i>bqAttempt</i>, to be used for a student's attempt
						at the exam.
						The answer for this question is <i><?php 
								echo kToConfig(array("true", "true", "false", "true", "false", "false", "false", "true", "false", "true")); 
							?></i> and the mark is <i>0</i> (because the question has not yet been marked).
							
						(1 mark)	
					</li>
					
					<li>
						Create a <span class="code">MultipleChoiceQuestion</span> and name the variable holding it <i>mcqAttempt</i>. This will be used for the exam attempt.
						Set the mark as 0 (because the attempt has not yet been marked) and set the (attempted) options as follows:
						<ol>
							<li>
								option1 as <?php 
										echo kToConfig(array("false", "true", "true", "false", "true", "false", "false", "true", "false", "true")); 
									?>,
									
								 
							</li>
							<li>
								option2 as <?php 
										echo kToConfig(array("true", "true", "true", "false", "true", "true", "false", "false", "true", "true")); 
									?>,
									
								 
							</li>
							<li>
								option3 as <?php 
										echo kToConfig(array("false", "false", "false", "false", "false", "true", "true", "false", "true", "false")); 
									?>,
									
								
							</li>
						</ol>
						(1 mark)
					</li>
						
					<li>
						Create an exam attempt and name the variable holding it <i>examAttempt</i>. It should be made up of the
						attempts at questions defined in the previous subquestions. (1 Mark)
					</li>
					</li>
					
					<li>
						Perform the marking process on the exam attempt. For each question, print out the mark awarded and the total possible for that question e.g.,
						"Question 1: 1 out of 1".
						 (1 mark)
					</li>
					<li>
						Print the total mark awarded for the entire attempt. Then, convert this total to a classification and print this classification, using the following 
						grade boundaries:
						<ul>
							<li>
								A mark of at least <?php 
										echo kToConfig(array("5", "6", "7", "9", "10", "11", "12", "11", "13", "13")); 
									?> is awarded a classification of 1.1.
							</li>
							<li>
								A mark that is lower than the previous boundary, but is at least <?php 
										echo kToConfig(array("4", "5", "6", "7", "8", "9", "10", "9", "11", "10")); 
									?> is awarded a classification of 2.1.
							</li>
							<li>
									A mark that is lower than the previous boundary, but is at least <?php 
										echo kToConfig(array("3", "4", "5", "6", "7", "8", "7", "6", "8", "7")); 
									?> is awarded a classification of 2.2.
							</li>
							<li>
								A mark lower than the previous boundary is awarded a classification of 0.0.
							</li>
						</ul
						(2 mark)
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
		
		<p>Once completed, submit your assignment using the link marked `Assignment 4: Submission' on KEATS.</p>
		
		<p style="font-weight: bold;">You must complete the plagiarism and collusion training before submitting this assignment.</p>
		
		<p>You must also submit complete documentation of your solution. You will find a sample piece of documentation in the Support section on KEATS marked `Sample Assignment Documentation'. Submit your documentation using the link marked `Assignment 4: Documentation Submission' on KEATS.</p>
		
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
