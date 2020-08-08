import java.util.Scanner;

public class Password {
  public static final int pword_length = 4;

  public static void password (String[] args) {
    Scanner input = new Scanner(System.in);
        System.out.print("A password needs to consist of 4 digits");
        String next_input = input.nextLine();
     }
  
  public static boolean is_digit (char digit){
    return (digit >= 0 && digit < 10);
  }

  public static boolean valid_pword (String pword){
    int count = 0;
    if (pword.length()<pword_length){
      return false;
      for (int i = 0; i<pword.length();i++){
        char index = pword.charAt(i);
        if (is_digit(index)){
        count++;
        } else {
        return false;
      }
    }
   }
  }
}