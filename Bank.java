package com.jogwal;

import java.util.ArrayList;

/*
 * NewBank Bank customer logic
 * Enables setting up of a customer with personal and account details and retrieval of the information
 * @Authors: Jonathan Ogwal, Thomas Nuttall-Smith
 * Version 2
 * Edit date: 14/07/20 
 */
public class Bank {
  ArrayList<Customer> customers = new ArrayList<Customer>();

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  Customer getCustomer(int account) {
    return customers.get(account);
  }

  ArrayList<Customer> getCustomers() {
    return customers;
  }
}

//______________________________________________________________________________________________________________________
class Customer {
  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;
  private final Account account;

  public Customer(String firstName, String lastName, String socialSecurityNumber, Account account) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.account = account;
  }
//TODO: not sure if this duplication is required?
  /*
   * public Customer(String firstName, String middleName, String lastName, String
   * socialSecurityNumber, Account account) { this.firstName = firstName;
   * this.lastName = lastName; this.socialSecurityNumber = socialSecurityNumber;
   * this.account = account; }
   */

  Account getAccount() {
    return account;
  }

  @Override
  public String toString() {
    return "\nCustomer information:\n" + "First Name: " + firstName + "Last Name: " + lastName
        + "Social Security Number: " + socialSecurityNumber + account;
  }

  public String basicInformation() {
    return "\nCustomer information:\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n"
        + "Social Security Number: " + socialSecurityNumber + "\n" + "Acccount Number: " + account.getAccountNumber();
  }
}
