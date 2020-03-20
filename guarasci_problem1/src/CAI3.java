/*
 * Casey Guarasci
 * COP 3330 • Dr. Hollander
 * Assignment 3: Problem 1
 */

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	static Scanner in = new Scanner(System.in);
	static int answer=0, response=0, score;
	static SecureRandom randNum = new SecureRandom();
	
	public static void quiz () {
		//Contains the program logic
		int i;
		score = 0;
		
		for (i=0; i<10; i++) {
			int randNumber1 = randNum.nextInt(10);
			int randNumber2 = randNum.nextInt(10);
			answer = randNumber1 * randNumber2;
			
			askQuestion (randNumber1, randNumber2);
			readResponse ();
			score = score + isAnswerCorrect (i);
		}
		
		displayCompletionMessage();
	}
	
	public static void askQuestion (int randNumber1, int randNumber2) {
		//Prints the problem to the screen
		System.out.println("How much is " + randNumber1 + " times " + randNumber2 + "?");
	}
	
	public static void readResponse () {
		//Reads the answer from the student
		response = in.nextInt();
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