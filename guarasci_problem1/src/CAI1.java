/*
 * Casey Guarasci
 * COP 3330 • Dr. Hollander
 * Assignment 3: Problem 1
 */

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	static Scanner in = new Scanner(System.in);
	static int answer=0, response=0;
	static SecureRandom randNum = new SecureRandom();
	
	public static void quiz () {
		//Contains the program logic
		int randNumber1 = randNum.nextInt(10);
		int randNumber2 = randNum.nextInt(10);
		answer = randNumber1 * randNumber2;
		
		askQuestion (randNumber1, randNumber2);
		readResponse ();
		isAnswerCorrect ();
	}
	
	public static void askQuestion (int randNumber1, int randNumber2) {
		//Prints the problem to the screen
		System.out.println("How much is " + randNumber1 + " times " + randNumber2 + "?");
	}
	
	public static void readResponse () {
		//Reads the answer from the student
		response = in.nextInt();
	}
	
	public static void isAnswerCorrect () {
		//Checks to see if the student's answer matches the correct answer to the problem
		if (response == answer) {
			displayCorrectResponse ();
		}
		else {
			displayIncorrectResponse ();
		}
	}
	
	public static void displayCorrectResponse () {
		//Prints out the response when a student enters a correct answer
		System.out.print("Very good! ");
		
		quiz();
	}
	
	public static void displayIncorrectResponse () {
		//Prints out the response when a student enters an incorrect answer
		System.out.println("No. Please try again.");
		
		readResponse();
		isAnswerCorrect();
	}
	
	public static void main(String[] args) {
		//Runs the program by calling the "quiz" method
		quiz();
	}
}
