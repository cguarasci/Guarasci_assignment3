
public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public double calculateMonthlyInterest (double annualInterestRate) {
		savingsBalance = savingsBalance + (savingsBalance * (annualInterestRate / 12));
		
		return savingsBalance;
	}
	
	public static void modifyInterestRate () {
		int newValue=0;
		setAnnualInterestRate(newValue);
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
}