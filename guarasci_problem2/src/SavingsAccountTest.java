/*
 * Casey Guarasci
 * COP 3330 • Dr. Hollander
 * Assignment 3: Problem 2
 */

import java.text.DecimalFormat;

public class SavingsAccountTest {
	static double saver1BalancetoRound, saver2BalancetoRound, saver1StartBal = 2000.00, saver2StartBal = 3000.00;
	static int i;
	static SavingsAccount saver1 = new SavingsAccount(1, saver1StartBal);
	static SavingsAccount saver2 = new SavingsAccount(2, saver2StartBal);
	static DecimalFormat twoDec = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		SavingsAccount.modifyInterestRate(0.04);
		printTable(1, 12);
		
		SavingsAccount.modifyInterestRate(0.05);
		System.out.print("\n");
		printTable(13, 13);
	}
	
	public static void printTable (int startMonth, int endMonth) {
		System.out.println("Monthly balances with an interest rate of " + SavingsAccount.getAnnualInterestRate()*100 + "%:\n");
		System.out.println("\t\tSaver" + saver1.getSaverNumber() + ":\t\tSaver" + saver2.getSaverNumber() + ":");
		
		for (i=startMonth; i<=endMonth; i++) {
			calcBalances();
			printBalances();
		}
	}
	
	public static void calcBalances () {
			saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest());
			saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest());
	}
	
	public static void printBalances () {
		saver1BalancetoRound = saver1.getSavingsBalance();
		saver2BalancetoRound = saver2.getSavingsBalance();
		
		System.out.println("Month #" + i + ":\t$" + twoDec.format(saver1BalancetoRound) + "\t$" + twoDec.format(saver2BalancetoRound));
	}
}