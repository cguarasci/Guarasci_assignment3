import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CAI5 {
	static Scanner in = new Scanner(System.in);
	static int score, difficulty, problemType, currProblemType;
	static double randNumber1, randNumber2, response=0, answer=0;
	static SecureRandom randNum = new SecureRandom();
	private static DecimalFormat threeDec = new DecimalFormat("0.000");
	private static DecimalFormat noDec = new DecimalFormat("0");
	
	public static void quiz () {
		//Contains the program logic
		int i;
		score = 0;
		difficulty = 0;
		problemType = 0;
		currProblemType = 0;
		
		System.out.print("Enter your chosen difficulty level. ");
		
		while (difficulty > 4 || difficulty <= 0) {
			System.out.println("Please select an option 1-4, with 1 being the easiest and 4 being the most difficult):");
			readDifficulty();
		}
		
		System.out.println("Select the type of problems you would like to solve.");
		
		while (problemType > 5 || problemType <= 0) {
			System.out.println("Please enter either 1, 2, 3, or 4.\n1: Addition problems only\n2: Multiplication problems only\n3: Subtraction problems only\n4: Division problems only\n5: A random mixture of all these types");
			readProblemType();
		}
		
		for (i=0; i<10; i++) {
			generateQuestionArgument();
			
			askQuestion ();
			readResponse ();
			score = score + isAnswerCorrect (i);
		}
		
		displayCompletionMessage();
	}
	
	public static void readDifficulty () {
		difficulty = in.nextInt();
	}
	
	public static void readProblemType () {
		int userInputedType = in.nextInt();
		
		problemType = userInputedType;
	}
	
	public static void generateQuestionArgument () {
		String stringAnswer = "0.00";
		
		switch (difficulty) {
			case 1:
				randNumber1 = randNum.nextInt(10);
				if (problemType == 4 || currProblemType == 4) {
					randNumber2 = randNum.nextInt(9) +1;
				}
				else {
					randNumber2 = randNum.nextInt(10);
				}
				break;
			case 2:
				randNumber1 = randNum.nextInt(100);
				if (problemType == 4 || currProblemType == 4) {
					randNumber2 = randNum.nextInt(99) + 1;
				}
				else {
					randNumber2 = randNum.nextInt(100);
				}
				break;
			case 3:
				randNumber1 = randNum.nextInt(1000);
				if (problemType == 4 || currProblemType == 4) {
					randNumber2 = randNum.nextInt(999) +1;
				}
				else {
					randNumber2 = randNum.nextInt(1000);
				}
				break;
			case 4:
				randNumber1 = randNum.nextInt(10000);
				if (problemType == 4 || currProblemType == 4) {
					randNumber2 = randNum.nextInt(9999) +1;
				}
				else {
					randNumber2 = randNum.nextInt(10000);
				}
				break;
		}
		
		if (problemType > 0 && problemType <= 4) {
			currProblemType = problemType;
		}
		else if (problemType == 5) {
			currProblemType = randNum.nextInt(4) + 1;
		}
		
		switch (currProblemType) {
			case 1:
				answer = randNumber1 + randNumber2;
				break;
			case 2:
				answer = randNumber1 * randNumber2;
				break;
			case 3:
				answer = randNumber1 - randNumber2;
				break;
			case 4:
				answer = randNumber1 / randNumber2;
				stringAnswer = threeDec.format(answer);
				answer = Double.valueOf(stringAnswer);
				break;
		}
	}
	
	public static void askQuestion () {
		//Prints the problem to the screen
		System.out.print("How much is " + noDec.format(randNumber1));
		switch (currProblemType) {
			case 1:
				System.out.println(" plus " + noDec.format(randNumber2) + "?");
				break;
			case 2:
				System.out.println(" times " + noDec.format(randNumber2) + "?");
				break;
			case 3:
				System.out.println(" minus " + noDec.format(randNumber2) + "?");
				break;
			case 4:
				System.out.println(" divided by " + noDec.format(randNumber2) + "? (Please round your answer to three decimals)");
				break;
		}
	}
	
	public static void readResponse () {
		//Reads the answer from the student
		response = in.nextDouble();
	}
	
	public static int isAnswerCorrect (int i) {
		//Checks to see if the student's answer matches the correct answer to the problem
		if (response == answer) {
			if (i != 9) {
				displayCorrectResponse ();
			}
			return 1;
		}
		else {
			if (i != 9) {
				displayIncorrectResponse ();
			}
			return 0;
		}
	}
	
	public static void displayCorrectResponse () {
		//Prints out the response when a student enters a correct answer
		int correctResponse = randNum.nextInt(4) + 1;
		switch (correctResponse) {
			case 1: 
				System.out.print("Very good! ");
				break;
			case 2:
				System.out.print("Excellent! ");
				break;
			case 3:
				System.out.print("Nice work! ");
				break;
			case 4:
				System.out.print("Keep up the good work! ");
				break;
		}
	}
	
	public static void displayIncorrectResponse () {
		//Prints out the response when a student enters an incorrect answer
		int incorrectResponse = randNum.nextInt(4) + 1;
		switch (incorrectResponse) {
			case 1: 
				System.out.print("No. Please try again. ");
				break;
			case 2:
				System.out.print("Wrong. Try once more. ");
				break;
			case 3:
				System.out.print("Don't give up! ");
				break;
			case 4:
				System.out.print("No. Keep trying. ");
				break;
		}
	}
	
	public static void displayCompletionMessage () {
		int percentCorrect, startNewSet = 0;
		
		percentCorrect = score * 10;
		
		System.out.printf("You have correctly solved " + percentCorrect + "%% of the problems. ");
		
		if (percentCorrect >= 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
		
		System.out.print("Would you like to start a new problem set? ");
		while (startNewSet != 1 && startNewSet != 2) {
			System.out.println("Please enter 1 for yes and 2 for no.");
			startNewSet = in.nextInt();
		
			if (startNewSet == 1) {
				main(null);
			}
			else if (startNewSet == 2) {
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		//Runs the program by calling the "quiz" method
		quiz();
	}
}