import java.util.ArrayList;

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

	public Customer(String firstName, String lastName, String socialSecurityNumber, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.account = account;
	}
	public Customer(String firstName, String middleName, String lastName, String socialSecurityNumber, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.account = account;
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
				account
				;
	}
	public String basicInformation() {
		return "\ncustomer information\n" +
				" firsName : " + firstName + "\n" +
				" lastName: " + lastName + "\n" +
				" socialSecurityNumber" + socialSecurityNumber + "\n" +
				" Acccount Number: " + account.getAccountNumber()
				;
	}
}
