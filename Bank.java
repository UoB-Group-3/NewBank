package com.jogwal;
import java.util.ArrayList;

/*
 * NewBank Account logic
 * @Authors: Jonathan Ogwal, Alex Lempka
 * Version 3
 * Edit date: 19/07/20
 */


public class Bank {
	ArrayList<Customer> customers = new ArrayList<Customer>();
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	Customer getCustomer(int account) {
		return customers.get(account);
	}
	ArrayList<Customer> getCustomers(){
		return customers;
	}
}
//______________________________________________________________________________________________________________________
class Customer{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Account account;
  private final String localSubsidiary;


	public Customer(String firstName, String lastName, String socialSecurityNumber, Account account, String localSubsidiary ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.account = account;
    this.localSubsidiary = localSubsidiary;

	}
	
	Account getAccount(){
		return account;
	}
	@Override
	public String toString() {
		return "\ncustomer information\n" +
				"firsName : " + firstName +
				"lastName: " + lastName +
				"socialSecurityNumber" + socialSecurityNumber +
        "localSubsidiary" + localSubsidiary +
				account
				;
	}
	public String basicInformation() {
		return "\ncustomer information\n" +
				" firsName : " + firstName + "\n" +
				" lastName: " + lastName + "\n" +
				" socialSecurityNumber" + socialSecurityNumber + "\n" +
        "localSubsidiary" + localSubsidiary + "\n" +
				" Acccount Number: " + account.getAccountNumber()
				;
	}
}
