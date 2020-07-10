package com.jogwal;

import java.util.ArrayList;
import java.util.Scanner;

public class Dashboard {
	//instance varriables
	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;

	public static void main(String[] args) {
		Dashboard dashboard = new Dashboard();
		dashboard.runMenu();
	}
	public void runMenu() {
		printHeader();
		while (!exit) {
			pirntMenue();
			int choice = getInput();
			performAction(choice);
		}
	}
	private void printHeader() {
		System.out.println("**********************************");
		System.out.println("**********|welcome to|************");
		System.out.println("*********GroupThreeBank***********");
		System.out.println("********Cash Money Group *********");
		System.out.println("**********************************");
	}
	private void pirntMenue() {
		System.out.println("1): New Account");
		System.out.println("2): Deposit");
		System.out.println("3): Withdrawal");
		System.out.println("4): Show the lists of accounts");
		System.out.println("0): Exit App");
	}
	private int getInput() {
		int choice = -1;
		do {
			System.out.print("Select choices 0-4: ");
			try {
				choice = Integer.parseInt(keyboard.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Entry, only number 0-1 allowed!");
			}
			if (choice < 0 || choice > 4) {
				System.out.println("Invalid Entry, only number 0-1 allowed!, try again");
			}
		} while (choice < 0 || choice > 4);

		return choice;
	}
	private void performAction(int choice) {
		switch (choice) {
			case 0:
				System.out.println("Thank you for using our selecting to bank with us");
				System.exit(0);
				break;
			case 1:createAccount();break;
			case 2:makeDeposit();break;
			case 3:makeWithdrawal();break;
			case 4:showBalance();break;
			default:System.out.println("Unknown parameter");
		}
	}

	//______________________________________________________________________________________________________________________
	private void showBalance() {
		int account = selectAccount();
		if (account >= 0) {

			System.out.println(bank.getCustomer(account).getAccount());
		}
	}
	//______________________________________________________________________________________________________________________
	private void makeWithdrawal() {
		int account = selectAccount();
		if (account >= 0) {
			System.out.println("How much would you like to withdraw? ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			} catch (NumberFormatException e) {
				amount = 0;
			}
			bank.getCustomer(account).getAccount().widthdraw(amount);
		}
	}
	//______________________________________________________________________________________________________________________
	private void makeDeposit() {
		int account = selectAccount();
		if (account >= 0) {
			System.out.println("How much would you like to deposit? ");
			double amount = 0;
			try {
				amount = Double.parseDouble(keyboard.nextLine());
			} catch (NumberFormatException e) {
				amount = 0;
			}
			bank.getCustomer(account).getAccount().deposit(amount);
		}
	}
//_____________________________________________________________________________________________________________________
	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if (customers.size()<=0){
			System.out.println("No customers at your bank");
			return -1;
		}
		System.out.println("select account");
		for(int i=0; i<customers.size(); i++) {
			System.out.println((i + 1) + ") " + customers.get(i).basicInformation());
		}
		int account =0;
		System.out.print("Please enter your selection");
		try {
			account = Integer.parseInt(keyboard.nextLine())-1;
		}catch (NumberFormatException e){
			account=-1;
		}
		if(account<0 || account>customers.size()){
			System.out.println("Invalid account selected.");
			return account=-1;
		}
		return account;//this return the account we want to make a deposit to
	}
	//______________________________________________________________________________________________________________________
	private void createAccount() {
		String firstName, lastName, socialSecurityNumber, accountType = "";
		double initialDeposit = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print("Please enter you accountType (premium/savings/loans): ");
			accountType = keyboard.nextLine();
			if (accountType.equalsIgnoreCase("premium") || accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("loans")) {
				valid = true;
			} else {
				System.out.print("Invalid input, please enter correct account type");
			}
		}
		System.out.print("Please enter First Name");
		firstName = keyboard.nextLine();
		System.out.print("please enter your lastName");
		lastName = keyboard.nextLine();
		System.out.print("Please enter your social security number");
		socialSecurityNumber = keyboard.nextLine();
		valid = false;
		while (!valid) {
			System.out.print("Enter initial deposit: ");
			try {
				initialDeposit = Double.parseDouble(keyboard.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Deposit must be a number");
			}
			if (accountType.equalsIgnoreCase("premium")) {
				if (initialDeposit < 1000) {
					System.out.println("Premium account requires a minimum of $1000 to open: ");
				} else {
					valid = true;
				}
			} else if (accountType.equalsIgnoreCase("savings")) {
				if (initialDeposit < 200) {
					System.out.println("savings account require a minimum of $500 to open: ");
				}else {
					valid = true;
				}
			}
			if (accountType.equalsIgnoreCase("loans")) {
				if (initialDeposit < 50) {
					System.out.println("Loans account require a minimum of $50 to open: ");
				} else {
					valid = true;
				}
			}
		}
		Account account;
		if (accountType.equalsIgnoreCase("checking")) {
			account = new Premium(initialDeposit);
		} else if (accountType.equalsIgnoreCase("savings")){
			account = new Savings(initialDeposit);
		}
		else {
			account = new loans(initialDeposit);
		}
		//Customer creation
		Customer customer = new Customer(firstName, lastName, socialSecurityNumber, account);
		bank.addCustomer(customer);
	}
}

