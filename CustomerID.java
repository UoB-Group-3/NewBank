package NewBank.newbank.server;

public class CustomerID {
	private String key;
	
	public CustomerID(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	int maxLoginAttempts = 3;
	String userName;
	String password;
	private loginAttemps(){
		if (maxLoginAttempts != 0){
			if (userName == Username){
				if (password == Password){
					System.out.println("Welcome");
				}
				else{
					maxLoginAttempts--;
					System.out.println("Incorrect password")
				}
			else{
			maxLoginAttempts--;
			System.out.println("Incorrect Username")
			}				
			}
		else{
		System.out.println("Your account is blocked as the maximum number of attempts have been reached");
		}
		
		}
}
