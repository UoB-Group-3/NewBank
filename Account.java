package com.jogwal;

public class Account {
	private double balance = 0;
	private double interest = 0.02;
	private int accountNumber;
	private static int numberOfAcconts = 1000;

	//this will be the counter for accunt numbers
	Account() {
		accountNumber = numberOfAcconts++;
	}

//getters and setters
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest * 100;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
//________________________________________________________________________________________________________________________
	public void widthdraw(double amount) {
		if ((amount + 5) > balance) {
			System.out.println("You have insufficient funds");
			System.out.println("the bank runs a loans account you may consider taking a loan ");
			return;
		}
		checkInterest(0);
		balance -= amount + 5;
		System.out.println("You have withdrawn : " + amount + "dollar and charged a fee fee of 5$");
		System.out.println("you now have a balance of $" + balance);
	}
//______________________________________________________________________________________________________________________
	public void deposit(double amount) {
		//deposit check
		if (amount <= 0) {
			System.out.println("You can not make negative deposit.");
			return;
		}
		checkInterest(0);
		amount = amount + amount * interest;
		balance += amount;
		System.out.println("You have deposited : " + amount + "dollar with and interest rate" + (interest * 100) + "%");
		System.out.println("you now have a balance of $" + balance);
	}
//______________________________________________________________________________________________________________________
	// this method will check my interest rate before any deposit or withdrawal
	public void checkInterest(double amount) {
		if (balance + amount> 10000) {
			interest = 0.05;
		} else {
			interest=0.02;
		}
	}
}
//========================================================================================================================
//in this section i will add the different accoutn types, premium, savings and loans
class Premium extends Account{
	private static String accountType = "checking";

	Premium(double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		this.checkInterest(0);
	}
	//two string method

	@Override
	public String toString() {
		return "accountType: " + accountType + "Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Account Balance: "  + this.getBalance() + "\n" +
				" interest Rate: " + this.getInterest() + "%\n";
	}
}
//______________________________________________________________________________________________________________________
class Savings extends Account{
	private static String accountType = "savings";
	Savings (double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		this.checkInterest(0);
	}
	@Override
	public String toString() {
		return "accountType: " + accountType + "Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Account Balance: "  + this.getBalance() + "\n" +
				" interest Rate: " + this.getInterest() + "%\n";
	}
}
//______________________________________________________________________________________________________________________
class loans extends Account{
	private static String accountType = "loans";

	loans (double initialDeposit){
		super();
		this.setBalance(initialDeposit);
		this.checkInterest(0);
	}

	@Override
	public String toString() {
		return "accountType: " + accountType + "Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Account Balance: "  + this.getBalance() + "\n" +
				" interest Rate: " + this.getInterest() + "%\n";
	}
}
//______________________________________________________________________________________________________________________
