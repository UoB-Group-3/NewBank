package com.jogwal;

/*
 * NewBank Account logic
 * @Authors: Jonathan Ogwal, Thomas Nuttall-Smith
 * Version 2
 * Edit date: 14/07/20
 */
public class Account {
  private double balance = 0;
  private double interest = 0.02;
  private int accountNumber;
  private static int numberOfAcconts = 1000;

  // incremental counter for account numbers
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
      System.out.println("The bank runs a loans account you may consider taking a loan ");
      return;
    }
    checkInterest(0);
    balance -= amount + 5;
    System.out.println("You have withdrawn: $" + amount + "  and charged a withdrawal fee of $5");
    System.out.println("Account: " + accountNumber + " now has a balance of $" + balance + "\n");
  }

//______________________________________________________________________________________________________________________
  // TODO: adds the interest to the amount deposited to the account
  public void deposit(double amount) {
    // deposit check
    if (amount <= 0) {
      System.out.println("You can not make negative deposit.");
      return;
    }
    checkInterest(0);
    amount = amount + amount * interest;
    balance += amount;
    System.out.println("You have deposited: " + amount + " dollar with an interest rate of " + (interest * 100) + "%");
    System.out.println("Account: " + accountNumber + "now has a balance of $" + balance + "\n");
  }

//______________________________________________________________________________________________________________________
  // this method will check the interest rate before any deposit or withdrawal
  public void checkInterest(double amount) {
    if (balance + amount > 10000) {
      interest = 0.05;
    } else {
      interest = 0.02;
    }
  }
}

//========================================================================================================================
/*
 * This section contains the different account types, premium, savings and loans
 */
class Premium extends Account {
  private static String accountType = "checking";

  Premium(double initialDeposit) {
    super();
    this.setBalance(initialDeposit);
    this.checkInterest(0);
  }

  // two string method
  // TODO: reformat to reduce repetition if possible?
  @Override
  public String toString() {
    return "Account Type: " + accountType + " Account\n" + "Account Number: " + this.getAccountNumber() + "\n"
        + "Account Balance: " + this.getBalance() + "\n" + "Interest Rate: " + this.getInterest() + "%\n";
  }
}

//______________________________________________________________________________________________________________________
class Savings extends Account {
  private static String accountType = "savings";

  Savings(double initialDeposit) {
    super();
    this.setBalance(initialDeposit);
    this.checkInterest(0);
  }

  @Override
  public String toString() {
    return "AccountType: " + accountType + " Account\n" + "Account Number: " + this.getAccountNumber() + "\n"
        + "Account Balance: " + this.getBalance() + "\n" + " Interest Rate: " + this.getInterest() + "%\n";
  }
}

//______________________________________________________________________________________________________________________
class Loans extends Account {
  private static String accountType = "loans";

  Loans(double initialDeposit) {
    super();
    this.setBalance(initialDeposit);
    this.checkInterest(0);
  }

  @Override
  public String toString() {
    return "AccountType: " + accountType + " Account\n" + "Account Number: " + this.getAccountNumber() + "\n"
        + "Account Balance: " + this.getBalance() + "\n" + "Interest Rate: " + this.getInterest() + "%\n";
  }
}
//______________________________________________________________________________________________________________________
