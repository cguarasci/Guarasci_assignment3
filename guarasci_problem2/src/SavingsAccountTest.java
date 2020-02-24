
public class SavingsAccountTest {
	double saver1 = 2000.00, saver2 = 3000.00;
	double annualInterestRate = 0.04, monthlyInterest;
	
	public static void main(String[] args) {
		int i;
		
		for (i=0; i<12; i++) {
			monthlyInterest = SavingsAccount.calculateMonthlyInterest(annualInterestRate);
			annualInterestRate = SavingsAccount.modifyInterestRate();
		}
		//annualInterestRate = 0.04;
	}
}
