
public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	int saverNumber;
	
	public SavingsAccount (int saverNumber, double savingsBalance) {
		this.saverNumber = saverNumber;
		this.savingsBalance = savingsBalance;
	}
	
	public double calculateMonthlyInterest () {
		double tempSavingsBalance = getSavingsBalance() * (getAnnualInterestRate() / 12);
		
		return tempSavingsBalance;
	}
	
	public static void modifyInterestRate (double inputtedInterestRate) {
		annualInterestRate = inputtedInterestRate;
	}
	
	public int getSaverNumber () {
		return saverNumber;
	}
	
	public double getSavingsBalance () {
		return savingsBalance;
	}
	
	public void setSavingsBalance (double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
}